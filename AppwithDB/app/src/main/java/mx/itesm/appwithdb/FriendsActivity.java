package mx.itesm.appwithdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FriendsActivity extends AppCompatActivity {

    private DBManager dbManager;

    private EditText name;
    private EditText hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        this.dbManager = new DBManager(this);
        this.name = (EditText) findViewById(R.id.name);
        this.hobby = (EditText) findViewById(R.id.Hobby);

    }

    public void saveName(View v) {
        String name = this.name.getText().toString();
        String hobby = this.hobby.getText().toString();
        this.dbManager.saveNameAndHobby(name, hobby);
        Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show();
    }

    public void findName(View v) {
        String name = this.name.getText().toString();
        String hobby = this.dbManager.findByName(name);
        this.hobby.setText(hobby);
        Toast.makeText(this, hobby, Toast.LENGTH_SHORT).show();
    }

    public void deleteName(View v) {
        String name = this.name.getText().toString();
        int res = this.dbManager.deleteByName(name);
        Toast.makeText(this, res + " deleted", Toast.LENGTH_SHORT).show();
    }
}
