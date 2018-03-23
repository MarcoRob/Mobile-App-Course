package mx.itesm.comunicationwithactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PerritoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perrito);

        Intent intent = getIntent();

        Toast.makeText(this,
                intent.getStringExtra("name") + " " + intent.getIntExtra("prueba", 0),
                Toast.LENGTH_SHORT).show();
    }

    public void backAgain(View view) {
        Intent resultado = new Intent();
        resultado.putExtra("regreso", "I'm back");
        setResult(Activity.RESULT_OK, resultado);

        // para regresar
        // NO hacer un nuevo intent
        finish();
    }
}
