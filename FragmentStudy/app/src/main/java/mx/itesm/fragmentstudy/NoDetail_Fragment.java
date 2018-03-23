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
public class NoDetail_Fragment extends Fragment {


    private Activity fromActivity;

    private Button chuySayHi;

    public NoDetail_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_no_detail_, container, false);
        this.fromActivity = getActivity();
        this.chuySayHi = (Button) v.findViewById(R.id.chuyHi);

        this.chuySayHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Chuy Say: HI...!", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }


}
