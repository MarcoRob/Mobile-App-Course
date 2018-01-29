package com.example.marco.appaboutmyself;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HobbieActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbie);

        Intent fromMenuActivity = getIntent();

    }

    public void Back (View v) {
        EditText hobbieSkill = (EditText) findViewById(R.id.hobbie);
        String hobbie_str = hobbieSkill.getText().toString();

        Intent response = new Intent();
        response.putExtra("hobbie", hobbie_str);
        setResult(Activity.RESULT_OK, response);

        finish();


    }


}
