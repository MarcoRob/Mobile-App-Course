package mx.itesm.appwithdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView myhobby;
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.dbManager = new DBManager(this);
        this.myhobby = (TextView) findViewById(R.id.myhobby);
        this.myhobby.setText(this.dbManager.findByName("myself"));
    }

    public void myHobbyActivity(View v) {
        Intent intent = new Intent(this, HobbiesActivity.class);
        startActivityForResult(intent, 0);
    }

    public void myFriendsHobbiesACt(View v) {
        Intent intent = new Intent(this, FriendsActivity.class);
        startActivityForResult(intent, 1);
    }

   protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 0) {
            this.myhobby.setText(this.dbManager.findByName("myself"));
        }
    }

}
