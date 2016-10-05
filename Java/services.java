package in.ac.nitrkl.testtttttttttt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class services extends AppCompatActivity implements View.OnClickListener {

    Button startservices,stopservices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        intialize();
        startservices.setOnClickListener(this);
        stopservices.setOnClickListener(this);
    }
    void intialize(){
        startservices=(Button)findViewById(R.id.startservices);
        stopservices=(Button)findViewById(R.id.stopservices);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.startservices:
                startService(new Intent(getBaseContext(), MyService.class));
                break;
            case R.id.stopservices:
                stopService(new Intent(getBaseContext(), MyService.class));
                break;
        }
    }
}
