package mx.itesm.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDemo extends Fragment {


    private Callback call;

    public FragmentDemo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_demo_lay, container, false);
        Button b = (Button) v.findViewById(R.id.mensaje_interno);
        Button b2 = (Button) v.findViewById(R.id.mensaje_externo);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.wtf("fragment", "si esta jalando wtf");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call.callback("espero que todo funcione");
            }
        });

        return v;

    }

    public void printMessage() {
        Log.wtf("FRAGMENT", "PRITING METHOD");
    }

    public void addCallbackListener(Callback c) {
        this.call = c;
    }

    interface Callback {
        void callback(String messege);
    }


}
