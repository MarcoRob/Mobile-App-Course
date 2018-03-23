package mx.itesm.fragments;


import android.app.*;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// fragments and async task
// async task - ejecutar lógica que no sabemos cuanto va a durar y no queremos que bloquee

public class MainActivity extends AppCompatActivity implements Demo.Callback,
        Fragment2.OnFragmentInteractionListener, JSONRequest.JSONListener {

    private Demo d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add fragment from code
        d = new Demo();
        d.addCallbackListener(this);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, d, "fragmentito");
        ft.commit();

        // PRUEBAS CON JSON
        // objetos - entre {}
        String jsonTest = "[{ 'nombre' : 'Humberto', 'calificacion' : [20, 16, 70] }," +
                "{ 'nombre' : 'Marco', 'calificacion' : [10, 5, 71] }," +
                "{ 'nombre' : 'Ponchito', 'calificacion' : [-10, -20, -100] }]";

        try {
            JSONArray obj = new JSONArray(jsonTest);

            for(int i = 0; i < obj.length(); i++){
                JSONObject actual = (JSONObject)obj.get(i);
                Log.d("JSON TEST", actual.getString("nombre"));
                JSONArray calificaciones = actual.getJSONArray("calificacion");

                for(int j = 0; j < calificaciones.length(); j++){
                    Log.d("CALIFICACION ACTUAL", calificaciones.get(j).toString());
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void imprimirMensajeFragmento(View v){
        d.printMessage();
    }

    public void callback(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void swapFragment(View v){

        FragmentManager fm = getFragmentManager();
        Fragment f = fm.findFragmentByTag("fragmentito");

        if(f != null){
            FragmentTransaction ft = fm.beginTransaction();

            Fragment2 f2 = new Fragment2();
            ft.remove(f);
            ft.add(R.id.container, f2, "fragmentito");
            ft.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void jsonRequest(View v){
        JSONRequest request = new JSONRequest(this);
        request.execute("https://api.github.com/", "todos", "los", "argumentos", "que", "se", "les", "ocurra");
    }

    @Override
    public void requestDone(JSONObject jsonObject) {

        try {
            Toast.makeText(this, jsonObject.getString("current_user_url"), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}



