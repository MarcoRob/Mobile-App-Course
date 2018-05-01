package mx.itesm.retrievejson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements RetrieveJson.JSONListener, AdapterView.OnItemClickListener{

    public ListView list_hobbies;
    private JSONArray json_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.list_hobbies = (ListView) findViewById(R.id.friends);
        this.list_hobbies.setOnItemClickListener(this);
    }

    public void LoadList(View view) {
        RetrieveJson retrieveJson = new RetrieveJson(this);
        retrieveJson.execute("https://raw.githubusercontent.com/MarcoRob/marcorob.github.io/master/friends.json");

        /*JSONAdapter adpater = new JSONAdapter(this.json_data, this);
        this.list_hobbies.setAdapter(adpater);*/
    }

    @Override
    public void requestDone(JSONArray jsonArray) {
        try {
            this.json_data = jsonArray;
            JSONAdapter adapter = new JSONAdapter(jsonArray, this);
            this.list_hobbies.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this, i+" pos", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, JSONDetail.class);
        try {
            Log.d("JSON POS " + i, this.json_data.getJSONObject(i).toString());
            intent.putExtra("json", this.json_data.getJSONObject(i).toString());
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Try Later", Toast.LENGTH_SHORT).show();
        }
    }

}
