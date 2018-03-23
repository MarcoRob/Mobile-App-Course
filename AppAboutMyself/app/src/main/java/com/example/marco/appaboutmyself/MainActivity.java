package com.example.marco.appaboutmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button menuButton;
    private EditText nameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuButton = (Button) findViewById(R.id.button);
        nameUser = (EditText) findViewById(R.id.editText);
    }

    public void goToMenu(View v) {
        Toast.makeText(this, "GO MENU", Toast.LENGTH_SHORT).show();

        String user_name = nameUser.getText().toString();
        Intent menuIntent = new Intent(this, MenuActivity.class);
        menuIntent.putExtra("name", user_name);

        startActivityForResult(menuIntent,0);

    }
}
