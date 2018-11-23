package lichengzheng.ztrainer;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Arrays;

public class CourtDisplay extends AppCompatActivity
{
    private ProgressBar progressBar;
    private ArrayList<Integer> courtLocationList;
    private ImageView[][] courtLocationTable;
    private int progressCounter;
    private Handler handler;
    private Runnable runnable;
    private Thread thread;
    private ShotTimer shotTimer;
    private ShotSelector shotSelector;
    private int traineeRowLocation, trainerRowLocation, traineeColumnLocation, trainerColumnLocation,
                trainerDrawableShot, traineeDrawableShot,traineeShotRow, trainerShotRow,shuttle,
                traineeShotColumn,trainerShotColumn,rallyLength,waitTime,playerLevel,rallyTracker,setTracker,gameSpeed,setCount,restTime,trainingMode;
    private String traineeShot, trainerShot;
    private Button homeButton, againButton,restButton,resumeButton;
    boolean resume = false;
    MediaPlayer beep;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_court_display);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Intent intent = getIntent();
        playerLevel = intent.getIntExtra("playerLevel",1);
        rallyLength = intent.getIntExtra("rallyLength",20);
        gameSpeed   = intent.getIntExtra("shotSpeed",5);
        setCount    = intent.getIntExtra("setCount",1);
        restTime    = intent.getIntExtra("restTime",0);
        trainingMode = intent.getIntExtra("trainingMode",1);

        progressCounter = 0;
        rallyTracker = rallyLength;
        setTracker = setCount;
        handler = new Handler();
        createRunnable();
        initiateImageView();

        thread = new Thread(runnable);
        shotTimer = new ShotTimer(gameSpeed);
        shotSelector = new ShotSelector(playerLevel,trainingMode);

        beep = MediaPlayer.create(CourtDisplay.this,R.raw.beep);

        initiateButtons();
        initiateServe();
        castProgressBar();
        beginTraining();
    }

    private void castProgressBar()
    {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //Drawable progressDrawable = getResources().getDrawable( R.drawable.badminton_court);
        //progressDrawable.setBounds(progressBar.getProgressDrawable().getBounds());
        //progressBar.setProgressDrawable(progressDrawable);
        //progressBar.getProgressDrawable().setColorFilter(R.color.yellow);
    }

    private void createRunnable()
    {
        runnable = new Runnable()
        {
            @Override
            public void run()
            {
                for(int set = 0; set < setCount; set++)
                {
                    initiateServe();
                    rallyTracker = rallyLength;
                    progressCounter = 0;
                    setTracker--;
                    for (int rally = 0; rally <= rallyLength; rally++)
                    {
                        while (progressCounter < 100)
                        {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    clearButtons();
                                    updateCourtDisplay();
                                    updateProgressBar();
                                    checkGameEnd();
                                }
                            });
                            sleepThread();
                        }
                        resetProgressBar();
                    }
                    if(restTime != 0)
                    {
                        waitTime = (restTime * 1000) / 100;
                        progressCounter = 0;
                        rallyTracker = -1;
                        while (progressCounter < 100)
                        {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    initiateRestText();
                                    if(resume)
                                    {
                                        progressCounter = 99;
                                        resume = false;
                                    }
                                    updateProgressBar();
                                    restCheckGameEnd();

                                }
                            });
                            sleepThread();
                        }
                        resetProgressBar();
                    }
                }
            }
            private void sleepThread()
            {
                try
                {
                    thread.sleep(waitTime);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
    }
    private void updateProgressBar()
    {
        progressCounter++;
        progressBar.setProgress(progressCounter);
    }
    private void resetProgressBar()
    {
        progressBar.setProgress(0);
        progressCounter = 0;
    }

    private void initiateImageView()
    {
        courtLocationList = new ArrayList<Integer>(
                Arrays.asList(
                        R.id.clearFarCourtLocation1,R.id.clearFarCourtLocation2,R.id.clearFarCourtLocation3,R.id.smashFarCourtLocation1,R.id.smashFarCourtLocation2,R.id.smashFarCourtLocation3,
                        R.id.dropFarCourtLocation1,R.id.dropFarCourtLocation2,R.id.dropFarCourtLocation3,R.id.netFarCourtLocation1,R.id.netFarCourtLocation2,R.id.netFarCourtLocation3,
                        R.id.netNearCourtLocation1,R.id.netNearCourtLocation2,R.id.netNearCourtLocation3,R.id.dropNearCourtLocation1,R.id.dropNearCourtLocation2,R.id.dropNearCourtLocation3,
                        R.id.smashNearCourtLocation1, R.id.smashNearCourtLocation2,R.id.smashNearCourtLocation3,R.id.clearNearCourtLocation1,R.id.clearNearCourtLocation2, R.id.clearNearCourtLocation3
                        ));
        courtLocationTable = new ImageView[8][3];
        int courtListIndex = 0;
        for(int row = 0; row < 8; row++)
        {
            for(int column = 0; column < 3; column++)
            {
                courtLocationTable[row][column] = (ImageView) findViewById(courtLocationList.get(courtListIndex));
                courtListIndex++;
            }
        }
    }
    private void beginTraining()
    {
            thread.start();
    }

    private void updateShots()
    {
        trainerColumnLocation = traineeShotColumn;//
        trainerRowLocation = traineeShotRow;//
        trainerShot = shotSelector.generateTrainerReturnShot(traineeShot);
        trainerShotColumn = shotSelector.generateReturnShotColumn();
        trainerShotRow = shotSelector.generateReturnShotRow("Trainer_" + trainerShot);
        trainerDrawableShot = shotSelector.returnDrawableShot("Trainer_" + trainerShot);//

        traineeColumnLocation = trainerShotColumn;
        traineeRowLocation = trainerShotRow;
        traineeShot = shotSelector.generateTraineeReturnShot(trainerShot);
        traineeShotColumn = shotSelector.generateReturnShotColumn();
        traineeShotRow = shotSelector.generateReturnShotRow("Trainee_" + traineeShot);
        traineeDrawableShot = shotSelector.returnDrawableShot("Trainee_" + traineeShot);
        shuttle = R.drawable.shuttle;
        waitTime = shotTimer.getShotTime(trainerShot,traineeShot);
    }

    private void initiateServe()
    {

        if(trainingMode == 4 || trainingMode == 5)
        {
            traineeShot = "net";
            traineeShotColumn = 1;
            traineeShotRow = 3;
        }
        else
        {
            traineeShot = "defensiveClear";
            traineeShotColumn = 1;
            traineeShotRow = 0;
        }
        traineeDrawableShot = R.drawable.get_ready;
        trainerShotColumn = 1;
        trainerShotRow = 6;
        trainerDrawableShot = R.color.transparent;//
        waitTime = 45;

        trainerColumnLocation = traineeShotColumn;//
        trainerRowLocation = traineeShotRow;//
        traineeColumnLocation = trainerShotColumn;
        traineeRowLocation = trainerShotRow;
        shuttle = R.drawable.shuttle;
    }
    private void updateCourtDisplay()
    {
        if(progressCounter == 0)
        {
            courtLocationTable[traineeRowLocation][traineeColumnLocation].setImageDrawable(getResources().getDrawable(traineeDrawableShot));
            //courtLocationTable[trainerRowLocation][trainerColumnLocation].setImageDrawable(getResources().getDrawable(trainerDrawableShot));//
            courtLocationTable[trainerRowLocation][trainerColumnLocation].setBackgroundDrawable(getResources().getDrawable(trainerDrawableShot));//
            courtLocationTable[traineeShotRow][traineeShotColumn].setImageDrawable(getResources().getDrawable(shuttle));
        }
        if(progressCounter == 85)
        {
            beep.start();
        }
        if(progressCounter == 50)
        {
            courtLocationTable[trainerRowLocation][trainerColumnLocation].setBackgroundDrawable(null);
        }
        if(progressCounter == 95)
        {
            courtLocationTable[traineeRowLocation][traineeColumnLocation].setImageDrawable(null);
            //courtLocationTable[trainerRowLocation][trainerColumnLocation].setImageDrawable(null);//
            //courtLocationTable[trainerRowLocation][trainerColumnLocation].setBackgroundDrawable(null);//
            courtLocationTable[traineeShotRow][traineeShotColumn].setImageDrawable(null);
        }
        if(progressCounter == 99)
        {
            updateShots();
            rallyTracker--;
        }
    }
    public void returnHome(View view)
    {
        finish();
    }
    public void resume(View view)
    {
        resume = true;
        waitTime = 500;
    }
    public void runAgain(View view)
    {
        Intent myIntent = new Intent(this, CourtDisplay.class);
        myIntent.putExtra("playerLevel",playerLevel);
        myIntent.putExtra("rallyLength",rallyLength);
        myIntent.putExtra("shotSpeed",gameSpeed);
        myIntent.putExtra("setCount",setCount);
        myIntent.putExtra("restTime",restTime);
        myIntent.putExtra("trainingMode",trainingMode);

        finish();
        startActivity(myIntent);
    }
    private void checkGameEnd()
    {
        if(rallyTracker < 0 && progressCounter == 100 && setTracker == 0 && restTime == 0)
        {
            initiateEndButtons();
        }
    }
    private void restCheckGameEnd()
    {
        if(rallyTracker < 0 && progressCounter == 100 && setTracker == 0)
        {
            initiateEndButtons();
        }
    }
    private void clearButtons()
    {
        homeButton.setEnabled(false);
        againButton.setEnabled(false);
        homeButton.setVisibility(View.INVISIBLE);
        againButton.setVisibility(View.INVISIBLE);

        restButton.setEnabled(false);
        resumeButton.setEnabled(false);
        restButton.setVisibility(View.INVISIBLE);
        resumeButton.setVisibility(View.INVISIBLE);
    }
    private void initiateEndButtons()
    {
        homeButton.setVisibility(View.VISIBLE);
        homeButton.setEnabled(true);
        againButton.setEnabled(true);
        againButton.setVisibility(View.VISIBLE);

        progressBar.setProgress(0);

        restButton.setEnabled(false);
        resumeButton.setEnabled(false);
        restButton.setVisibility(View.INVISIBLE);
        resumeButton.setVisibility(View.INVISIBLE);
    }
    private void initiateRestText()
    {
        restButton.setVisibility(View.VISIBLE);
        restButton.setEnabled(true);
        resumeButton.setVisibility(View.VISIBLE);
        resumeButton.setEnabled(true);
    }
    private void initiateButtons()
    {
        homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setVisibility(View.INVISIBLE);
        homeButton.setEnabled(false);
        againButton = (Button) findViewById(R.id.againButton);
        againButton.setVisibility(View.INVISIBLE);
        againButton.setEnabled(false);
        restButton = (Button) findViewById(R.id.restButton);
        restButton.setVisibility(View.INVISIBLE);
        restButton.setEnabled(false);
        resumeButton = (Button) findViewById(R.id.resumeButton);
        resumeButton.setVisibility(View.INVISIBLE);
        resumeButton.setEnabled(false);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        waitTime = 1;
        rallyLength = 1;
        setCount = 1;
        restTime = 0;
        progressCounter = 99;
        finish();
    }



    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        waitTime = 1;
        rallyLength = 1;
        setCount = 1;
        restTime = 0;
        progressCounter = 99;
        finish();
    }
}
