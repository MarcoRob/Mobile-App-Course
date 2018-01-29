package com.example.marco.appaboutmyself;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        Toast.makeText(this, "My FRIENDS", Toast.LENGTH_SHORT).show();
    }
}
