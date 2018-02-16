package mx.itesm.partial1_a01229793;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private ListView food_list;
    private DBAdapter dbadapter;
    private DBHelper dbhelper;
    private TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        food_list = (ListView)findViewById(R.id.food_list);
        label = (TextView) findViewById(R.id.label);

        dbhelper = new DBHelper(this);
        dbadapter = new DBAdapter(dbhelper, this);


        this.addToDB("Chilaquiles", "300");
        this.addToDB("Pizza", "350");
        this.addToDB("Enfrijoladas", "120");
        this.addToDB("Chilaquiles", "780");

        food_list.setAdapter(dbadapter);

        //Toast.makeText(this, this.dbhelper.countRows()+"", Toast.LENGTH_SHORT).show();

        food_list.setOnItemClickListener(this);

    }

    public void addToDB(String food, String price) {
        this.dbhelper.addDB(food, price);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        i++;
        String foodName = this.dbhelper.findDB(i);
        String price = this.dbhelper.findPrice(i);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("name", foodName);
        intent.putExtra("id", i);
        intent.putExtra("price", price);

        startActivityForResult(intent, 0);
        //Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        //Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
