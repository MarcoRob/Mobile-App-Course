package mx.itesm.partial1_a01229793;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by UXLab on 2/9/18.
 */

public class DBAdapter extends BaseAdapter {

    private DBHelper dbhelper;
    private ArrayList<String> list;
    private Activity activity;

    public DBAdapter(DBHelper dbhelper, Activity activity) {
        this.activity = activity;
        this.dbhelper = dbhelper;
    }

    @Override
    public int getCount() {
        return this.dbhelper.countRows();
    }

    @Override
    public Object getItem(int i) {
        i++;
        return this.dbhelper.findDB(i);

    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        i++;
        if(view == null){
            view = activity.getLayoutInflater().inflate(R.layout.list_columns, null);
        }

        TextView food_name = (TextView)view.findViewById(R.id.food);
        TextView id_food = (TextView)view.findViewById(R.id.id_food);
        TextView price = (TextView)view.findViewById(R.id.price);

        String db_name = this.dbhelper.findDB(i);
        food_name.setText(db_name);

        String db_price = this.dbhelper.findPrice(i);
        price.setText("$" + db_price);

        id_food.setText((i)+"");

        return view;
    }
}