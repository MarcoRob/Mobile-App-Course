package mx.itesm.retrievejson;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by marco on 22/03/2018.
 */

public class RetrieveJson extends AsyncTask<String, Void, JSONArray> {

    private JSONListener jsonListener;

    public RetrieveJson(JSONListener jsonListener) {
        this.jsonListener = jsonListener;
    }

    @Override
    protected JSONArray doInBackground(String... strings) {
        JSONArray result = null;

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int code = connection.getResponseCode();
            if(code == HttpURLConnection.HTTP_OK) {
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader((new InputStreamReader(is)));
                StringBuilder sb = new StringBuilder();
                String currentLine = "";

                while((currentLine = br.readLine()) != null) {
                    sb.append(currentLine);
                    Log.d("JSON", currentLine);
                }
                result = new JSONArray(sb.toString());
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        super.onPostExecute(jsonArray);
        jsonListener.requestDone(jsonArray);
    }

    public interface JSONListener {
        void requestDone(JSONArray jsonArray);
    }
}
