package mx.itesm.retrievejson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class JSONDetail extends AppCompatActivity {

    private JSONObject data;

    private TextView name, hobby, phone, address, age, sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        this.name = (TextView) findViewById(R.id.name);
        this.hobby = (TextView) findViewById(R.id.hobby);
        this.phone = (TextView) findViewById(R.id.phone);
        this.address = (TextView) findViewById(R.id.address);
        this.age = (TextView) findViewById(R.id.age);
        this.sex = (TextView) findViewById(R.id.sex);

        Intent intent = getIntent();
        try {
            this.data = new JSONObject(intent.getStringExtra("json"));
            this.name.setText("Name: " + this.data.getString("name"));
            this.hobby.setText("Hobby: " + this.data.getString("hobby"));
            this.age.setText("Age: " + this.data.getString("age"));
            this.phone.setText("Phone: " + this.data.getString("phone"));
            this.address.setText("Address: " + this.data.getString("address"));
            this.sex.setText("Sex: " + this.data.getString("sex"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
