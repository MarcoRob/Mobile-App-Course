package com.example.marco.appaboutmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView user_name;
    private EditText empty_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        user_name = (TextView) findViewById(R.id.name);
        empty_text = (EditText) findViewById(R.id.empty);

        Intent fromMainIntent = getIntent();
        String user_name_str = "Hi, " + fromMainIntent.getStringExtra("name");

        user_name.setText(user_name_str);

    }

    public void goHobbie(View v) {
        Intent goHobbie_intent = new Intent(this, HobbieActivity.class);

        startActivityForResult(goHobbie_intent, 0);
    }

    public void goFriends(View v) {
        Intent goFriends_intent = new Intent(this, FriendsActivity.class);
        startActivity(goFriends_intent);
    }

    public void goMessage(View v) {
        Intent goMessage_intent = new Intent(this, MessageActivity.class);
        startActivity(goMessage_intent);
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {
            String response = data.getStringExtra("hobbie");
            empty_text.setText(response);
        }
    }
}
