package mx.itesm.activity31_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import org.json.JSONArray

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    var foodMenu : ListView? = null;
    var foodOptions : JSONArray = JSONArray("[{'name':'burger', 'price':15, 'description':'a juicy burger!'}," +
                                                "{'name':'hotdog', 'price':20, 'description':'an ok hot dog'}," +
                                                "{'name':'tacos', 'price':12, 'description':'some pretty good tacos'}," +
                                                "{'name':'torta', 'price':22, 'description':'nice torta'}," +
                                                "{'name':'carne asada', 'price':50, 'description':'a great carne asada'}]")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.foodMenu =  findViewById(R.id.foodMenu);
        var customAdapter : CustomAdapter = CustomAdapter(foodOptions, this);

        foodMenu?.adapter = customAdapter;
        foodMenu?.setOnItemClickListener(this);
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var description : String = foodOptions.getJSONObject(p2).getString("description").toString();
        Toast.makeText(this, description, Toast.LENGTH_SHORT).show();
    }


}
