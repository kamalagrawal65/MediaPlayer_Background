package in.ac.nitrkl.testtttttttttt;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class async extends AppCompatActivity implements View.OnClickListener{

    EditText asyncedittext;
    TextView asynctextview;
    Button asyncsave,asyncload;
    public static String filename="Mydata";
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        initialize();
        asyncsave.setOnClickListener(this);
        asyncload.setOnClickListener(this);

        try {
            fos=openFileOutput(filename, Context.MODE_PRIVATE);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void initialize(){
        asyncsave=(Button)findViewById(R.id.asyncsave);
        asyncload=(Button)findViewById(R.id.asyncload);
        asyncedittext=(EditText)findViewById(R.id.asyncedittext);
        asynctextview=(TextView)findViewById(R.id.asynctextview);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.asyncsave:
                String stringdata=asyncedittext.getText().toString();
                try {
                    fos=openFileOutput(filename,Context.MODE_PRIVATE);
                    fos.write(stringdata.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.asyncload:
                //when execute is called control goes to doinbackground
                new loadSomeStuff().execute(filename);
                break;
        }
    }

    public class loadSomeStuff extends AsyncTask<String,Integer,String>{    //arg,progress,return type

        ProgressDialog dialog;
       // @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(async.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(100);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String collected=null;
            FileInputStream fis=null;

            for(int i=0;i<20;i++){
                publishProgress(5);
                try {
                    Thread.sleep(88);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dialog.dismiss();

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
                    return collected;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            dialog.incrementProgressBy(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            asynctextview.setText(s);
        }

    }

}
