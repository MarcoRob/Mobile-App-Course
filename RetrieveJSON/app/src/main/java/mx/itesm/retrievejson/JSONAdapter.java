package mx.itesm.retrievejson;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by marco on 22/03/2018.
 */

public class JSONAdapter extends BaseAdapter {

    private Activity activity;
    private JSONArray json;

    public JSONAdapter(JSONArray json, Activity activity) {
        this.activity = activity;
        this.json = json;
    }

    @Override
    public int getCount() {
        try {
            return this.json.length();
        } catch (Exception e) {
            return 3;
        }

    }

    @Override
    public Object getItem(int i) {
        return i;

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = activity.getLayoutInflater().inflate(R.layout.json_layout, null);
        }

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView hobby = (TextView) view.findViewById(R.id.hobby);

        try {
            name.setText(this.json.getJSONObject(i).getString("name"));
            hobby.setText(this.json.getJSONObject(i).getString("hobby"));
        } catch(Exception e) {
            name.setText("Name");
            hobby.setText("Hobby");
        }
        return view;
    }
}
