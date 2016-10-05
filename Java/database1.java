package in.ac.nitrkl.testtttttttttt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class database1 extends AppCompatActivity implements View.OnClickListener{

    EditText dbnameet,dbschoolet;
    Button upload,view,getinfo,editinfo,deleteinfo;
    TextView dbnametv,dbschooltv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database1);
        initialize();
    }

    public void initialize(){

        dbnametv=(TextView)findViewById(R.id.dbnametv);
        dbschooltv=(TextView)findViewById(R.id.dbschooltv);
        dbnameet=(EditText) findViewById(R.id.dbnameet);
        dbschoolet=(EditText) findViewById(R.id.dbschoolet);

        upload=(Button)findViewById(R.id.dbupload);
        getinfo=(Button)findViewById(R.id.dbgetinfo);
        deleteinfo=(Button)findViewById(R.id.dbdeleteinfo);
        editinfo=(Button)findViewById(R.id.dbeditinfo);
        view=(Button)findViewById(R.id.dbview);

        upload.setOnClickListener(this);
        view.setOnClickListener(this);
        editinfo.setOnClickListener(this);
        deleteinfo.setOnClickListener(this);
        getinfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dbupload:
                boolean diditwork=true;
                try {
                    String name = dbnameet.getText().toString();
                    String school = dbschoolet.getText().toString();
                    school entry = new school(database1.this);
                    entry.open();
                    long id = entry.createEntry(name, school);
                  //  Toast.makeText(this, "OK " + id,Toast.LENGTH_LONG).show();
                    entry.close();
                }catch(Exception e){
                    diditwork=false;
                    e.printStackTrace();
                }finally {
                    if(diditwork) {
                        /*Dialog d = new Dialog(this);
                        d.setTitle("DataBase");
                        TextView tv=new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();*/
                        AlertDialog.Builder ab=new AlertDialog.Builder(this);
                        ab.setTitle("message");
                        LayoutInflater lf=getLayoutInflater();
                        View v1=lf.inflate(R.layout.dialog,null);
                        ab.setView(v1);
                        ab.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        ab.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        AlertDialog al=ab.create();
                        al.show();


                    }
                }
                break;
            case R.id.dbview:
                Intent i=new Intent("in.ac.nitrkl.testtttttttttt.dbview");
                startActivity(i);
                break;

            case R.id.dbgetinfo:
                String id = dbnameet.getText().toString();
                long l=Long.parseLong(id);
                school information=new school(this);
                information.open();
                String s=information.searchbyid(l);
                Toast.makeText(this,s,Toast.LENGTH_LONG).show();
                information.close();
                break;

            case R.id.dbeditinfo:
                id = dbnameet.getText().toString();
                String school=dbschoolet.getText().toString();
                l=Long.parseLong(id);
                information=new school(this);
                information.open();
                information.editbyid(l,school);
                Toast.makeText(this,"Edited",Toast.LENGTH_LONG).show();
                information.close();
                break;

            case R.id.dbdeleteinfo:
                id = dbnameet.getText().toString();
                l=Long.parseLong(id);
                information=new school(this);
                information.open();
                information.deletebyid(l);
                Toast.makeText(this,"Deleted",Toast.LENGTH_LONG).show();
                information.close();
                break;

        }
    }
}
