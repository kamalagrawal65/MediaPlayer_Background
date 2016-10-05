package in.ac.nitrkl.testtttttttttt;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class bluetooth extends AppCompatActivity {

    BluetoothAdapter BA;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        /*if(BA.isEnabled()){
            Toast.makeText(this,"Bluetooth is On.",Toast.LENGTH_LONG).show();
        }else{
            Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(i);
            if(BA.isEnabled()){
                Toast.makeText(this,"Bluetooth has been turned On.",Toast.LENGTH_LONG).show();
            }
        }*/
        Intent intent=new Intent(getApplicationContext(),bluetooth.class);
        PendingIntent pendingintent=PendingIntent.getActivity(getApplicationContext(),1,intent,0);

        Notification notif=new Notification.Builder(getApplicationContext())
                .setContentTitle("Oh yeah! First Notif")
                .setContentText("Its Raining now")
                .setContentIntent(pendingintent)
                .addAction(R.drawable.icon,"See",pendingintent)
                .setSmallIcon(R.drawable.icon)
                .build();

        NotificationManager nf=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nf.notify(1,notif);

    }

   /* public void turnbtoff(){
        BA.disable();
        if(BA.isEnabled())
            Toast.makeText(this,"Unable to turn off Bluetooth.",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Bluetooth has been turned Off.",Toast.LENGTH_LONG).show();
    }*/

}
