package lichengzheng.ztrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread splashThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e)
                {
                    // do nothing
                } finally
                {
                    finish();
                    Intent i = new Intent();
                    i.setClassName("lichengzheng.ztrainer","lichengzheng.ztrainer.HomeScreen");
                    startActivity(i);
                }
            }
        };
        splashThread.start();

    }

}
