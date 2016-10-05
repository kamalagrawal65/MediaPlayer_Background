package in.ac.nitrkl.testtttttttttt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class flipper extends AppCompatActivity implements View.OnClickListener{

    ViewFlipper flippy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper);

        flippy=(ViewFlipper)findViewById(R.id.flipper);
        flippy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        flippy.showNext();
    }
}
