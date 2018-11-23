package lichengzheng.ztrainer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
import android.widget.ImageView;
import android.os.Handler;
import android.media.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeScreen extends AppCompatActivity
{
    private ArrayList<Integer> levelButtonIdList,radioButtonIdList;
    private ArrayList<Button> levelButtonList;
    private ArrayList<RadioButton> radioButtonList;
    private int chosenPlayerLevel,chosenTrainingMode,rallyLength,shotSpeed,setCount,restTime;
    private SeekBar rallySeekBar,speedSeekBar,setSeekBar,restSeekBar;
    private TextView rallySeekBarText,speedSeekBarText,setSeekBarText,restSeekBarText;
    MediaPlayer mySong;
    private Button challengeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_home_screen);
        levelButtonIdList = new ArrayList<Integer> (Arrays.asList(R.id.eLevelButton, R.id.dLevelButton,
                                                                  R.id.cLevelButton, R.id.bLevelButton,R.id.aLevelButton));
        radioButtonIdList = new ArrayList<Integer> (Arrays.asList(R.id.fullCourtRadio, R.id.sixCornersRadio,R.id.fourCornersRadio,
                                                                  R.id.twoCornersRadio, R.id.netReturnsRadio,R.id.dropReturnsRadio,
                                                                  R.id.smashReturnsRadio,R.id.clearReturnsRadio));
        levelButtonList = new ArrayList<Button>();
        radioButtonList = new ArrayList<RadioButton>();
        chosenPlayerLevel = 1;
        chosenTrainingMode = 1;
        rallyLength = 20;
        shotSpeed = 5;
        setCount = 1;
        restTime = 0;

        initiateButton(levelButtonIdList);
        initiateRadioButton(radioButtonIdList);
        setLevelButtonListener();
        setRadioButtonListener();

        rallySeekBarText = (TextView) findViewById(R.id.rallySeekBarText);
        rallySeekBar = (SeekBar) findViewById(R.id.rallySeekBar);
        setRallySeekBarListener();

        speedSeekBarText = (TextView) findViewById(R.id.speedSeekBarText);
        speedSeekBar = (SeekBar) findViewById(R.id.speedSeekBar);
        setSpeedSeekBarListener();

        setSeekBarText = (TextView) findViewById(R.id.setSeekBarText);
        setSeekBar = (SeekBar) findViewById(R.id.setSeekBar);
        setSetSeekBarListener();

        restSeekBarText = (TextView) findViewById(R.id.restSeekBarText);
        restSeekBar = (SeekBar) findViewById(R.id.restSeekBar);
        setRestSeekBarListener();

        mySong = MediaPlayer.create(HomeScreen.this,R.raw.song);
        playMusic();

        challengeButton = (Button) findViewById(R.id.challengeButton);

    }

    private void initiateButton(ArrayList<Integer> levelButtonIdList)
    {
        for(int id : levelButtonIdList)
        {
            final Button levelButton = (Button) findViewById(id);
            levelButtonList.add(levelButton);
        }
        ((Button) findViewById(R.id.eLevelButton)).setPressed(true);
        ((Button) findViewById(R.id.eLevelButton)).setBackgroundResource(R.drawable.yellow_button);
    }
    private void initiateRadioButton(ArrayList<Integer> radioButtonIdList)
    {
        for(int id: radioButtonIdList)
        {
            final RadioButton radioButton = (RadioButton) findViewById(id);
            radioButtonList.add(radioButton);
        }
        ((RadioButton) findViewById(R.id.fullCourtRadio)).setChecked(true);
    }
    @SuppressLint("ClickableViewAccessibility")
    private void setLevelButtonListener()
    {
        for(Button levelButton : levelButtonList)
        {
            levelButton.setOnTouchListener(new View.OnTouchListener()
            {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent)
                {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    {
                        ((Button) view).setPressed(true);
                        ((Button) view).setBackgroundResource(R.drawable.yellow_button);
                        for(Button otherLevelButton : levelButtonList)
                            if((Button) view != otherLevelButton)
                            {
                                otherLevelButton.setBackgroundResource(R.drawable.white_button);
                                otherLevelButton.setPressed(false);
                            }
                    }
                    chosenPlayerLevel = levelButtonList.indexOf((Button) view) + 1;
                    return true;
                }
            });
        }
    }
    private void setRadioButtonListener()
    {
        for(RadioButton radioButton : radioButtonList)
        {
            radioButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    ((RadioButton) view).setChecked(true);
                    for(RadioButton otherRadioButton :radioButtonList)
                        if((RadioButton) view != otherRadioButton)
                            otherRadioButton.setChecked(false);
                    chosenTrainingMode = radioButtonList.indexOf((RadioButton) view) + 1;
                }
            });
        }
    }


    public void startTraining(View view)
    {
        Intent myIntent = new Intent(this, CourtDisplay.class);
        myIntent.putExtra("playerLevel",chosenPlayerLevel);
        myIntent.putExtra("rallyLength",rallyLength);
        myIntent.putExtra("shotSpeed",shotSpeed);
        myIntent.putExtra("setCount",setCount);
        myIntent.putExtra("restTime",restTime);
        myIntent.putExtra("trainingMode",chosenTrainingMode);

        startActivity(myIntent);
    }

    private void setRallySeekBarListener()
    {
        rallySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b)
            {
                rallyLength = value;
                rallySeekBarText.setText(Integer.toString(rallyLength));
                if(rallyLength == 0)
                {
                    rallyLength = 1;
                    rallySeekBarText.setText(Integer.toString(rallyLength));
                    rallySeekBar.setProgress(1);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                if(rallyLength == 0)
                {
                    rallyLength = 1;
                    rallySeekBarText.setText(Integer.toString(rallyLength));
                    rallySeekBar.setProgress(1);
                }
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                rallySeekBarText.setText(Integer.toString(rallyLength));
                if(rallyLength == 0)
                {
                    rallyLength = 1;
                    rallySeekBarText.setText(Integer.toString(rallyLength));
                    rallySeekBar.setProgress(1);
                }
            }
        });
    }

    private void setSpeedSeekBarListener()
    {
        speedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b)
            {
                shotSpeed = value;
                speedSeekBarText.setText(Integer.toString(shotSpeed));
                if(shotSpeed == 0)
                {
                    shotSpeed = 1;
                    speedSeekBarText.setText(Integer.toString(shotSpeed));
                    speedSeekBar.setProgress(1);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                if(shotSpeed == 0)
                {
                    shotSpeed = 1;
                    speedSeekBarText.setText(Integer.toString(shotSpeed));
                    speedSeekBar.setProgress(1);
                }
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                speedSeekBarText.setText(Integer.toString(shotSpeed));
                if(shotSpeed == 0)
                {
                    shotSpeed = 1;
                    speedSeekBarText.setText(Integer.toString(shotSpeed));
                    speedSeekBar.setProgress(1);
                }
            }
        });
    }
    private void setSetSeekBarListener()
    {
        setSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b)
            {
                setCount = value;
                setSeekBarText.setText(Integer.toString(setCount));
                if(setCount == 0)
                {
                    setCount = 1;
                    setSeekBarText.setText(Integer.toString(setCount));
                    setSeekBar.setProgress(1);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                if(setCount == 0)
                {
                    setCount = 1;
                    setSeekBarText.setText(Integer.toString(setCount));
                    setSeekBar.setProgress(1);
                }
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                setSeekBarText.setText(Integer.toString(setCount));
                if(setCount == 0)
                {
                    setCount = 1;
                    setSeekBarText.setText(Integer.toString(setCount));
                    setSeekBar.setProgress(1);
                }
            }
        });
    }
    private void setRestSeekBarListener()
    {
        restSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b)
            {
                restTime = value;
                restSeekBarText.setText(Integer.toString(restTime));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                restSeekBarText.setText(Integer.toString(restTime));
            }
        });
    }
    private void playMusic()
    {
        mySong.start();
        mySong.setLooping(true);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        if(mySong.isPlaying())
        {
            mySong.pause();
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if(!mySong.isPlaying())
        {
            mySong.seekTo(0);
            mySong.start();
        }
    }

    public void startChallengeMode(View view)
    {
        Intent myIntent = new Intent(this, ChallengeMode.class);
        startActivity(myIntent);
    }

}

