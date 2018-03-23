package mx.itesm.fragmentstudy;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Detail_Fragment extends Fragment {

    private Activity fromActivity;
    private Button ponchoSayHi;

    public Detail_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail_layout, container, false);
        this.fromActivity = getActivity();
        this.ponchoSayHi = (Button) v.findViewById(R.id.ponchoHi);

        this.ponchoSayHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Poncho Say: I'm Gay...!!", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

}
