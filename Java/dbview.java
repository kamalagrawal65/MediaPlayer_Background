package in.ac.nitrkl.testtttttttttt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kamal pc on 15-Aug-16.
 */
public class dbview extends AppCompatActivity {

    TextView info;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbview);
        initialize();
        school information=new school(this);
        information.open();
        String data=information.getData();
        information.close();
        info.setText(data);
    }

    void initialize(){
        info=(TextView)findViewById(R.id.tvsqlinfo);
    }

}
