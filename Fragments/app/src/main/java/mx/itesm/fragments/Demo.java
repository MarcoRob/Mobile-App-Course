package mx.itesm.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Demo extends Fragment {

    private Callback callback;

    public Demo() {
        // Required empty public constructor
    }


    // también tiene lifecycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_demo, container, false);
        Button b = (Button)v.findViewById(R.id.button);
        Button b2 = (Button)v.findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.wtf("fragment", "sí está jalando");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.callback("ESPERO QUE TODO FUNCIONE");
            }
        });

        return v;
    }

    public void printMessage(){
        Log.d("FRAGMENT", "PRINTING MESSAGE");
    }

    public void addCallbackListener(Callback c){
        callback = c;
    }

    interface Callback {
        void callback(String message);
    }
}
