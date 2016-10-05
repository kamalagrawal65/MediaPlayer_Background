package in.ac.nitrkl.testtttttttttt;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class externaldata extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener{

    private TextView canread,canwrite;
    private String state;
    boolean canw,canr;
    Spinner spinner;
    String[] paths={"Music","Pictures","Downloads"};
    File path=null;
    File file=null;
    EditText etsaveas;
    Button confirm,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externaldata);
        initialize();

        state= Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            canwrite.setText("true");
            canread.setText("true");
            canw=canr=true;
        }
        else if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            canwrite.setText("false");
            canread.setText("true");
            canw=false;
            canr=true;
        }
        else{
            canwrite.setText("false");
            canread.setText("false");
            canw=canr=false;
        }

        confirm.setOnClickListener(this);
        save.setOnClickListener(this);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(externaldata.this,android.R.layout.simple_dropdown_item_1line,paths);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    void initialize(){
        canread=(TextView)findViewById(R.id.canread);
        canwrite=(TextView)findViewById(R.id.canwrite);
        spinner=(Spinner)findViewById(R.id.spinner);
        etsaveas=(EditText)findViewById(R.id.etsaveas);
        confirm=(Button)findViewById(R.id.confirm);
        save=(Button)findViewById(R.id.save);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int position1=spinner.getSelectedItemPosition();
        switch(position1){
            case 0:
                path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                break;
            case 1:
                path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;
            case 2:
                path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm:
                save.setVisibility(View.VISIBLE);
                break;
            case R.id.save:
                path.mkdirs();
                String f=etsaveas.getText().toString();
                file=new File(path,f);
                if(canr==canw==true){
                  /* try {
                        InputStream is = getResources().openRawResource(R.drawable.img1);
                        OutputStream os = new FileOutputStream(file);
                        byte[] data = new byte[is.available()];
                        is.read(data);
                        os.write(data);
                        is.close();
                        os.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/

                }

                break;
        }
    }
}
