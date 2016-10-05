package in.ac.nitrkl.testtttttttttt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Details extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i=getIntent();
        int a=i.getIntExtra("val",-1);
        Toast.makeText(getApplicationContext(),a+"",Toast.LENGTH_LONG).show();

    }
}
