package in.ac.nitrkl.testtttttttttt;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kamal pc on 13-Aug-16.
 */
public class second extends Activity {
    MediaPlayer mysong;
    Button play,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.econd);
        mysong=MediaPlayer.create(this,R.raw.songg);
        play=(Button)findViewById(R.id.play);
        stop=(Button)findViewById(R.id.stop);

        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mysong.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mysong.pause();
            }
        });

        /*Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent opensecond=new Intent("in.ac.nitrkl.testtttttttttt.second");
                    startActivity(opensecond);
                }
            }
        }*/

    }
}
