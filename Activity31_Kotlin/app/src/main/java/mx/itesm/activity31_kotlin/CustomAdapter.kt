package mx.itesm.activity31_kotlin

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Text

/**
 * Created by marco on 30/04/2018.
 */
class CustomAdapter (var menuOptions:JSONArray, var activity: Activity) : BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View? = null
        if(view == null) {
            /*val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.custom_row_layout, null)*/
            view = activity.layoutInflater.inflate(R.layout.custom_row_layout, null);
        }

        val name = view?.findViewById<TextView>(R.id.name)
        val price = view?.findViewById<TextView>(R.id.price)

        val menuOption = menuOptions.getJSONObject(p0)

        name?.text = menuOption.get("name").toString()
        price?.text = menuOption.get("price").toString()

        return view as View
    }

    override fun getItem(p0: Int): Any {
        return menuOptions.getJSONObject(p0);
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getCount(): Int {
        return menuOptions.length()
    }
}