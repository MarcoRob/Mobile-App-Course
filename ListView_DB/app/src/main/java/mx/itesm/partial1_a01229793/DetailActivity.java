package mx.itesm.partial1_a01229793;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView name;
    private TextView id;
    private TextView price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        this.name = (TextView) findViewById(R.id.food);
        this.id = (TextView) findViewById(R.id.id);
        this.price = (TextView) findViewById(R.id.price);

        this.name.setText("FOOD: " + intent.getStringExtra("name"));
        this.price.setText("$" + intent.getStringExtra("price"));
        this.id.setText("ID: " + intent.getIntExtra("id", 0));

    }

    public void regresar(View v){
        finish();
    }
}
