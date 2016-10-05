package in.ac.nitrkl.testtttttttttt;

import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class accelerometer extends AppCompatActivity implements SensorEventListener, View.OnClickListener{

    Button alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        alert=(Button)findViewById(R.id.alertdialog);
        alert.setOnClickListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.alertdialog:
                AlertDialog ad=new AlertDialog.Builder(this).create();
                ad.setTitle("Message");
                ad.setMessage("My own aalert Dialog");
                ad.show();
                break;
        }
    }
}
