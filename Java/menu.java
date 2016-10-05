package in.ac.nitrkl.testtttttttttt;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by kamal pc on 13-Aug-16.
 */
public class menu extends AppCompatActivity {
    String fruits[]={"apple","mango","guava","orange","apple","mango","guava","orange","apple","mango","guava","orange"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fruits));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),fruits[position],Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),Details.class);
                i.putExtra("val",position);
                startActivity(i);
            }
        });
    }


}
