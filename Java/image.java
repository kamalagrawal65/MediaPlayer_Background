package in.ac.nitrkl.testtttttttttt;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class image extends AppCompatActivity{
    Button takepic;
    ImageView iv;
    Intent i;
    final static int cameraData=0;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initialize();
    }
    void initialize(){
        takepic=(Button)findViewById(R.id.takepic);
        iv=(ImageView)findViewById(R.id.iv);
    }
}
