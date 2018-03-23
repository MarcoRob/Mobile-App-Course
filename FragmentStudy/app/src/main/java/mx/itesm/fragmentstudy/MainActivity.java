package mx.itesm.fragmentstudy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragManager;

    private Fragment detail_fragment,
                    no_detail_fragment;
    private boolean isDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fragManager = getFragmentManager();

        this.detail_fragment = new Detail_Fragment();
        this.no_detail_fragment = new NoDetail_Fragment();

        FragmentTransaction ft = this.fragManager.beginTransaction();
        ft.add(R.id.localfragment, this.detail_fragment, "Detail Fragment");
        ft.commit();
        this.isDetail = true;
    }

    public void swapFragments(View v) {
        FragmentTransaction ft = this.fragManager.beginTransaction();
        if(this.isDetail) {
            ft.remove(this.detail_fragment);
            ft.add(R.id.localfragment, this.no_detail_fragment, "Detail Fragment");
            ft.commit();
            this.isDetail = false;
        } else {
            ft.remove(this.no_detail_fragment);
            ft.add(R.id.localfragment, this.detail_fragment, "Detail Fragment");
            ft.commit();
            this.isDetail = true;
        }
    }
}
