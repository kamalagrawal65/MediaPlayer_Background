package in.ac.nitrkl.testtttttttttt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class email extends AppCompatActivity {
    String Password,Phone,Email;
    EditText passbtn,phonebtn,emailbtn;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        getSupportActionBar().setTitle("EMAIL");
        
        initialize();
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Password=passbtn.getText().toString();
                Phone=phonebtn.getText().toString();
                Email=emailbtn.getText().toString();
                Intent emailintent=new Intent(Intent.ACTION_SEND);
                emailintent.putExtra(Intent.EXTRA_EMAIL,"Kamalagrawal777@gmail.com");
                emailintent.putExtra(Intent.EXTRA_SUBJECT,"Learning Android");
                emailintent.setType("plain/text");
                emailintent.putExtra(Intent.EXTRA_TEXT,"Great Start to it btw");
                startActivity(emailintent);
            }
        });
    }

    void initialize(){
        passbtn=(EditText) findViewById(R.id.password);
        emailbtn=(EditText) findViewById(R.id.email);
        phonebtn=(EditText) findViewById(R.id.phone);
        send=(Button)findViewById(R.id.send);
    }

}
