package in.ac.nitrkl.testtttttttttt;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TabHost;
import android.widget.TextView;

public class tab extends AppCompatActivity {

    TextView text1;
    Long time;

    //frame layout allows to draw at top of each other
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        time=System.currentTimeMillis();
        text1=(TextView)findViewById(R.id.tab1);
        if(time!=0)
            text1.setText(String.format("%02d:%d:%04d",time,time,time));

        TabHost th=(TabHost)findViewById(R.id.tabHost);
        th.setup();

        TabHost.TabSpec specs= th.newTabSpec("tag1");
        specs.setContent(R.id.tabno1);
        specs.setIndicator("About Us");
        th.addTab(specs);

        specs= th.newTabSpec("tag2");
        specs.setContent(R.id.tabno2);
        specs.setIndicator("Reach Us");
        th.addTab(specs);

        specs= th.newTabSpec("tag3");
        specs.setContent(R.id.tabno3);
        specs.setIndicator("Contact");
        th.addTab(specs);

        //Dynamically create tabs like this and set the content using tabcontentfactory method --nice
        /*specs.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                return null;
            }
        });*/





    }
}
