package in.ac.nitrkl.testtttttttttt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class browser extends AppCompatActivity {
    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        browser=(WebView)findViewById(R.id.browseview);

        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);

        try {
            browser.setWebViewClient(new ourViewClient());
            browser.loadUrl("http://kamalag.esy.es");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
