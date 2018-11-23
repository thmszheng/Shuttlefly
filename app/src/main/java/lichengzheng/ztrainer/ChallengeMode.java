package lichengzheng.ztrainer;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ChallengeMode extends AppCompatActivity {

    private WebView webView1;
    private WebView webView2;
    private WebView webView3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_challenge_mode);

        webView1 = (WebView) findViewById(R.id.webView1);
        webView2 = (WebView) findViewById(R.id.webView2);
        webView3 = (WebView) findViewById(R.id.webView3);
        webView1.setBackgroundColor(getResources().getColor(R.color.transparent));
        webView2.setBackgroundColor(getResources().getColor(R.color.transparent));
        webView3.setBackgroundColor(getResources().getColor(R.color.transparent));

        String video1 = "<html><body style=\"padding: 0; margin: 0;\"></body><div style=\"width:100%;height:0px;position:relative;padding-bottom:63.250%;\"><iframe src=\"https://streamable.com/s/dazc8/glwddf\" frameborder=\"0\" width=\"100%\" height=\"100%\" allowfullscreen style=\"width:100%;height:100%;position:absolute;left:0px;top:0px;overflow:hidden;\"></iframe></div></html>";
        String video2 = "<html><body style=\"padding: 0; margin: 0;\"></body><html><div style=\"width:100%;height:0px;position:relative;padding-bottom:63.250%;\"><iframe src=\"https://streamable.com/s/0979x/stzfwb\" frameborder=\"0\" width=\"100%\" height=\"100%\" allowfullscreen style=\"width:100%;height:100%;position:absolute;left:0px;top:0px;overflow:hidden;\"></iframe></div></html>";
        String video3 = "<html><body style=\"padding: 0; margin: 0;\"></body><html><div style=\"width:100%;height:0px;position:relative;padding-bottom:63.250%;\"><iframe src=\"https://streamable.com/s/yeejn/wwfevi\" frameborder=\"0\" width=\"100%\" height=\"100%\" allowfullscreen style=\"width:100%;height:100%;position:absolute;left:0px;top:0px;overflow:hidden;\"></iframe></div></html>";

        webView1.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webView2.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webView3.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings1 = webView1.getSettings();
        WebSettings webSettings2 = webView2.getSettings();
        WebSettings webSettings3 = webView3.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        webSettings2.setJavaScriptEnabled(true);
        webSettings3.setJavaScriptEnabled(true);
        webView1.loadData(video1, "text/html", "utf-8");
        webView2.loadData(video2, "text/html", "utf-8");
        webView3.loadData(video3, "text/html", "utf-8");
    }

    public void startChallenge1(View view)
    {
        Intent myIntent = new Intent(this, ChallengeCourtDisplay.class);
        myIntent.putExtra("challengeChoice",1);
        finish();
        startActivity(myIntent);
    }

    public void startChallenge2(View view)
    {
        Intent myIntent = new Intent(this, ChallengeCourtDisplay.class);
        myIntent.putExtra("challengeChoice",2);
        finish();
        startActivity(myIntent);
    }

    public void startChallenge3(View view)
    {
        Intent myIntent = new Intent(this, ChallengeCourtDisplay.class);
        myIntent.putExtra("challengeChoice",3);
        finish();
        startActivity(myIntent);
    }

}
