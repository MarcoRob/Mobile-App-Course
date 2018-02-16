package mx.itesm.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentDemo.Callback{

    private FragmentDemo d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add fragment from code
        this.d = new FragmentDemo();
        this.d.addCallbackListener(this);


        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, d, "fragmentito");
        ft.commit();
    }


    public void imprimitMensajeFragmento(View v) {
        d.printMessage();
    }

    @Override
    public void callback(String messege) {
        Toast.makeText(this, messege, Toast.LENGTH_SHORT).show();
    }
}
