package in.ac.nitrkl.testtttttttttt;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class savedata extends AppCompatActivity implements View.OnClickListener{

    EditText saveedittext;
    TextView savetextview;
    Button save,load;
    public static String filename="Mydata";
    //FileOutputStream fos;

    SharedPreferences somedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedata);
        initialize();
        save.setOnClickListener(this);
        load.setOnClickListener(this);
       /* try {
           // fos=openFileOutput(filename, Context.MODE_PRIVATE);
           // fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //0 for private mode
        somedata=getSharedPreferences(filename,0);
    }

    void initialize(){
        save=(Button)findViewById(R.id.save);
        load=(Button)findViewById(R.id.load);
        saveedittext=(EditText)findViewById(R.id.saveedittext);
        savetextview=(TextView)findViewById(R.id.savetextview);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.save:
                String stringdata=saveedittext.getText().toString();
              /*  try {
                    fos=openFileOutput(filename,Context.MODE_PRIVATE);
                    fos.write(stringdata.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

               /* File f=new File(filename);
                try {
                    fos=new FileOutputStream(f);
                    //writing to file

                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */

                //Toast.makeText(this,"Kamal",Toast.LENGTH_LONG).show();
                //Method1 Shared Preferences

                String stringdta=saveedittext.getText().toString();
                SharedPreferences.Editor editor=somedata.edit();
                editor.putString("sharedString",stringdta);
                editor.commit();

                break;
            case R.id.load:
               /* String collected=null;
                FileInputStream fis=null;
                try {
                    fis=openFileInput(filename);
                    byte[] dataarray=new byte[fis.available()];
                    while(fis.read(dataarray)!= -1){
                        collected=new String(dataarray);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally{
                    try {
                        fis.close();
                        savetextview.setText(collected);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }*/
                //Method1 Shared Preferences

                somedata=getSharedPreferences(filename,0);
                String datareturned=somedata.getString("sharedString","Some Default Value if string var is not found");
                savetextview.setText(datareturned);

                break;
        }
    }

}
