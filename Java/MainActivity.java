package in.ac.nitrkl.testtttttttttt;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //for better experience implement the view.onclicklistener and define the onclick function in that b using case statements
    //switch(view.getId()) and proceed

    Button add,sub,secpage,menu,showname,email,image,sti,animate,tab,browser,flipper,sd,async,externaldata,db1,accelerometer,httpclient,services,bluetooth;
    TextView display;
    EditText name;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter=0;
        add=(Button)findViewById(R.id.clickadd);
        sub=(Button)findViewById(R.id.clicksub);
        secpage=(Button)findViewById(R.id.secpage);
        menu=(Button)findViewById(R.id.menu);
        showname=(Button)findViewById(R.id.showname);
        email=(Button)findViewById(R.id.email);
        image=(Button)findViewById(R.id.image);
        sti=(Button)findViewById(R.id.sendinternet);
        animate=(Button)findViewById(R.id.animate);
        tab=(Button)findViewById(R.id.tab);
        browser=(Button)findViewById(R.id.browser);
        flipper=(Button)findViewById(R.id.flipper);
        sd=(Button)findViewById(R.id.savedata);
        async=(Button)findViewById(R.id.asynctask);
        externaldata=(Button)findViewById(R.id.externaldata);
        db1=(Button)findViewById(R.id.database1);
        accelerometer=(Button)findViewById(R.id.accelerometer);
        httpclient=(Button)findViewById(R.id.httpclient);
        services=(Button)findViewById(R.id.service);
        bluetooth=(Button)findViewById(R.id.bluetooth);

        name=(EditText)findViewById(R.id.name);
        name.setInputType(InputType.TYPE_CLASS_PHONE);


        display=(TextView)findViewById(R.id.text);
        display.setGravity(Gravity.CENTER);
        Random rand=new Random();
        display.setTextColor(Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                counter++;
                display.setText("Your counter is "+counter);
            }
        });

        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                counter--;
                display.setText("Your counter is "+counter);
            }

        });

        secpage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent opensec=new Intent("in.ac.nitrkl.testtttttttttt.second");
                startActivity(opensec);
            }
        });

        animate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openanimate=new Intent("in.ac.nitrkl.testtttttttttt.animate");
                startActivity(openanimate);
            }
        });

        email.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openemail=new Intent("in.ac.nitrkl.testtttttttttt.email");
                startActivity(Intent.createChooser(openemail,"Sorry Something went wrong"));
            }
        });

        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openimg=new Intent("in.ac.nitrkl.testtttttttttt.image");
                startActivity(openimg);
            }
        });

        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openmenu=new Intent("in.ac.nitrkl.testtttttttttt.menu");
                startActivity(openmenu);
            }
        });

        showname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myname=name.getText().toString();
                Toast.makeText(getApplicationContext(),myname,Toast.LENGTH_LONG).show();
            }
        });

        sti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opennet=new Intent("in.ac.nitrkl.testtttttttttt.netdata");
                startActivity(opennet);
            }
        });

        tab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent opentab=new Intent("in.ac.nitrkl.testtttttttttt.tab");
                startActivity(opentab);
            }
        });

        browser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openbrowser=new Intent("in.ac.nitrkl.testtttttttttt.browser");
                startActivity(openbrowser);
            }
        });

        flipper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openflip=new Intent("in.ac.nitrkl.testtttttttttt.flipper");
                startActivity(openflip);
            }
        });

        sd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent opensd=new Intent("in.ac.nitrkl.testtttttttttt.savedata");
                startActivity(opensd);
            }
        });

        async.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openasync=new Intent("in.ac.nitrkl.testtttttttttt.async");
                startActivity(openasync);
            }
        });

        externaldata.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openext=new Intent("in.ac.nitrkl.testtttttttttt.externaldata");
                startActivity(openext);
            }
        });

        db1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent opendb=new Intent("in.ac.nitrkl.testtttttttttt.database1");
                startActivity(opendb);
            }
        });

        accelerometer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openac=new Intent("in.ac.nitrkl.testtttttttttt.accelerometer");
                startActivity(openac);
            }
        });

        httpclient.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openhc=new Intent("in.ac.nitrkl.testtttttttttt.httpclient");
                startActivity(openhc);
            }
        });

        services.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openanimate=new Intent("in.ac.nitrkl.testtttttttttt.services");
                startActivity(openanimate);
            }
        });

        bluetooth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openanimate=new Intent("in.ac.nitrkl.testtttttttttt.bluetooth");
                startActivity(openanimate);
            }
        });

        Toast.makeText(MainActivity.this, "On create", Toast.LENGTH_SHORT).show();
    }
    public void onStart(){
        super.onStart();
        Toast.makeText(MainActivity.this, "On Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "On Destroy", Toast.LENGTH_SHORT).show();
    }
}
