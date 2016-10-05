package in.ac.nitrkl.testtttttttttt;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by kamal pc on 17-Aug-16.
 */
public class MyService extends Service {
    public IBinder onBind(Intent arg0){
        return null;
    }

    MediaPlayer mp;

    public void onCreate(){
        super.onCreate();
        mp=MediaPlayer.create(getApplicationContext(),R.raw.songg);
    }

    public int onStartCommand(Intent intent,int flags,int startID){
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        mp.start();
        return 0;
                //START_STICKY;
    }
    public void onDestroy(){
        mp.release();
        super.onDestroy();
        Toast.makeText(this,"Service Stopped",Toast.LENGTH_LONG).show();
    }
}
