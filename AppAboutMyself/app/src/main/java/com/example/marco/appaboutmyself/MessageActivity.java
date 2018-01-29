package com.example.marco.appaboutmyself;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    private EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        message = (EditText) findViewById(R.id.message);
    }

    public void Back(View v) {
        Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();
        finish();
    }
}
