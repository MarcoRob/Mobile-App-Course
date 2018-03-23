package mx.itesm.fragments;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by UXLab on 02/03/18.
 */

// JSON - javascript object notation
// XML

    // params - progress - result

public class JSONRequest extends AsyncTask<String, Void, JSONObject> {

    private JSONListener jsonListener;

    public JSONRequest(JSONListener jsonListener){
        this.jsonListener = jsonListener;
    }

    // método que ejecuta lògica de manera asíncrona
    @Override
    protected JSONObject doInBackground(String... strings) {

        JSONObject result = null;

        try{

            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            // 404 - not found
            // 200 - OK
            // 500 - sever error
            // 401 - no authorized
            // 400 - bad request
            // 418 - i'm a teapot
            // 1500 - url invalid
            int code = connection.getResponseCode();
            if(code == HttpURLConnection.HTTP_OK){

                // BUILD JSON SO WE CAN PARSE IT LATER
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                String currentLine = "";

                while((currentLine = br.readLine()) != null){
                    Log.d("JSON", currentLine);
                    sb.append(currentLine);
                }

                // parsing a JSON
                result = new JSONObject(sb.toString());
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        jsonListener.requestDone(jsonObject);
    }

    public interface JSONListener {

        void requestDone(JSONObject jsonObject);
    }
}
