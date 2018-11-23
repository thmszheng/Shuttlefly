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

public class ChallengeCourtDisplay extends AppCompatActivity
{
    private ProgressBar progressBar;
    private ArrayList<Integer> courtLocationList;
    private ImageView[][] courtLocationTable;
    private int progressCounter;
    private Handler handler;
    private Runnable runnable;
    private Thread thread;
    private int traineeRowLocation, trainerRowLocation, traineeColumnLocation, trainerColumnLocation,
            trainerDrawableShot, traineeDrawableShot,traineeShotRow, trainerShotRow,shuttle,
            traineeShotColumn,trainerShotColumn,rallyLength,waitTime,rallyTracker,challengeChoice;
    private Button homeButton, againButton;
    private ChallengeRallyGenerator rallyGenerator;
    MediaPlayer beep;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_challenge_court_display);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Intent intent = getIntent();
        challengeChoice = intent.getIntExtra("challengeChoice",1);

        rallyGenerator = new ChallengeRallyGenerator(challengeChoice);
        rallyLength = rallyGenerator.getRallyLength();
        progressCounter = 0;
        rallyTracker = 0;
        handler = new Handler();
        createRunnable();
        initiateImageView();

        thread = new Thread(runnable);
        beep = MediaPlayer.create(ChallengeCourtDisplay.this,R.raw.beep);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        initiateButtons();
        initiateServe();
        beginTraining();
    }


    private void createRunnable()
    {
        runnable = new Runnable()
        {
            @Override
            public void run()
            {
                initiateServe();
                rallyTracker = 0;
                progressCounter = 0;
                for (int rally = 0; rally <= rallyLength; rally++)
                {
                    while (progressCounter < 100)
                    {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                updateCourtDisplay();
                                updateProgressBar();
                                checkGameEnd();
                            }
                        });
                        sleepThread();
                    }
                    resetProgressBar();
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
        if(rallyTracker < rallyLength) {
            trainerColumnLocation = rallyGenerator.getTrainerColumnLocation(rallyTracker);
            trainerRowLocation = rallyGenerator.getTrainerRowLocation(rallyTracker);
            trainerDrawableShot = rallyGenerator.getTrainerShotDrawable(rallyTracker);

            traineeColumnLocation = rallyGenerator.getTraineeColumnLocation(rallyTracker);
            traineeRowLocation = rallyGenerator.getTraineeRowLocation(rallyTracker);
            traineeDrawableShot = rallyGenerator.getTraineeShotDrawable(rallyTracker);

            traineeShotRow = rallyGenerator.getShotRowLocation(rallyTracker);
            traineeShotColumn = rallyGenerator.getShotColumnLocation(rallyTracker);

            shuttle = R.drawable.shuttle;
            waitTime = (rallyGenerator.getShotTime(rallyTracker)) / 100;
        }
    }

    private void initiateServe()
    {
        traineeShotColumn = 1;
        traineeShotRow = 0;
        shuttle = R.color.transparent;

        waitTime = 45;

        trainerColumnLocation = 2;//
        trainerRowLocation = 1;//
        trainerDrawableShot = R.color.transparent;//

        traineeColumnLocation = 1;
        traineeRowLocation = 6;
        traineeDrawableShot = R.drawable.get_ready;

    }
    private void updateCourtDisplay()
    {
        if(progressCounter == 0)
        {
            courtLocationTable[traineeRowLocation][traineeColumnLocation].setImageDrawable(getResources().getDrawable(traineeDrawableShot));
            //courtLocationTable[trainerRowLocation][trainerColumnLocation].setImageDrawable(getResources().getDrawable(trainerDrawableShot));//
            courtLocationTable[trainerRowLocation][trainerColumnLocation].setBackgroundDrawable(getResources().getDrawable(trainerDrawableShot));
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
            //courtLocationTable[trainerRowLocation][trainerColumnLocation].setBackgroundDrawable(null);
            courtLocationTable[traineeShotRow][traineeShotColumn].setImageDrawable(null);
        }
        if(progressCounter == 99)
        {
            updateShots();
            rallyTracker++;
        }
    }
    public void returnHome(View view)
    {
        finish();
    }
    public void runAgain(View view)
    {
        Intent myIntent = new Intent(this, ChallengeCourtDisplay.class);
        myIntent.putExtra("challengeChoice",challengeChoice);
        finish();
        startActivity(myIntent);
    }
    private void checkGameEnd()
    {
        if(rallyTracker > rallyLength && progressCounter == 100)
        {
            initiateEndButtons();
        }
    }

    private void initiateEndButtons()
    {
        homeButton.setVisibility(View.VISIBLE);
        homeButton.setEnabled(true);
        againButton.setEnabled(true);
        againButton.setVisibility(View.VISIBLE);

        progressBar.setProgress(0);
    }
    private void initiateButtons()
    {
        homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setVisibility(View.INVISIBLE);
        homeButton.setEnabled(false);
        againButton = (Button) findViewById(R.id.againButton);
        againButton.setVisibility(View.INVISIBLE);
        againButton.setEnabled(false);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        waitTime = 1;
        rallyLength = 1;
        progressCounter = 99;
        finish();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        waitTime = 1;
        rallyLength = 1;
        progressCounter = 99;
        finish();
    }
}
