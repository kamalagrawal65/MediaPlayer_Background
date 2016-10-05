package in.ac.nitrkl.testtttttttttt;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class httpclient extends AppCompatActivity implements View.OnClickListener{

    TextView tvhttp;
    Button notification;

    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpclient);
        initialize();
        notification.setOnClickListener(this);
    }

    void initialize(){
        tvhttp=(TextView)findViewById(R.id.tvhttp);
        notification=(Button)findViewById(R.id.notification);
        nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View v) {

            /*final NotificationManager mgr=
                    (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            Notification note=new Notification(R.drawable.icon,
                    "New matching post!",
                    System.currentTimeMillis());
            Intent i=new Intent(this, httpclient.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|
                    Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent pi=PendingIntent.getActivity(this, 0,
                    i,
                    0);
            note.setLatestEventInfo(this, "Identi.ca Post!",
                    "Found your keyword: ",
                    pi);
            int NOTIFICATION_ID=10;
            mgr.notify(NOTIFICATION_ID, note);*/

    }
}
