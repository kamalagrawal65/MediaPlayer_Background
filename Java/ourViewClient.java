package in.ac.nitrkl.testtttttttttt;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by kamal pc on 14-Aug-16.
 */
public class ourViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView v,String url){
        v.loadUrl(url);
        return true;
    }
}
