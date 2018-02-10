package mx.itesm.appwithdb;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HobbiesActivity extends AppCompatActivity {

    private EditText myhobby;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);

        myhobby = (EditText) findViewById(R.id.hobby);
        this.dbManager = new DBManager(this);
    }

    public void saveHobby(View v) {

        Intent intent = new Intent();
        String hobby = this.myhobby.getText().toString();
        this.dbManager.saveNameAndHobby("myself", hobby);
        Toast.makeText(this, "SAVED " + hobby, Toast.LENGTH_SHORT).show();
        /*intent.putExtra("hobby", this.myhobby.getText().toString());
        setResult(Activity.RESULT_OK, intent);*/
        finish();
    }
}
