package mx.itesm.comunicationwithactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button, button2;
    private static final int PERRITO_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrieve a reference to the UI widgets
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button  = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        textView.setText("QWERTY");
        editText.setHint("This is an example of a hint!");
        button.setText("Hey LOOK! a button");

        button2.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               Toast.makeText(getApplicationContext(), "Button 2", Toast.LENGTH_SHORT).show();
           }
        });
    }

    // 2 ways to detect a click
    // declare a method that returns void and expects a View as parameter
    public void clickTest(View v) {
        Log.i("MAIN", "Clickitty click");
        // Factory - regresa una instancia Toast
        Toast.makeText(this, "Button 1", Toast.LENGTH_SHORT).show();

        // cambio de actividad
        // - las actividades se manejan a nivel OS
        // - para abrir una nueva actividad solicitamos que se abra
        Intent intent = new Intent(this, PerritoActivity.class);
        intent.putExtra("name", editText.getText().toString());
        intent.putExtra("prueba", 5);


        //startActivity(intent);
        startActivityForResult(intent, PERRITO_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // aqui escuchamos el regreso de una actividad
        if(requestCode == PERRITO_CODE) {
            Toast.makeText(this, "PERRITO EXITOSO " + data.getStringExtra("regreso"), Toast.LENGTH_SHORT).show();
        }
    }
}
