package mx.itesm.localstorage;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbManager;
    private EditText studentId,
                    studentName,
                    studentGrade;

    // usando properties - (otra manera de guardar)
    private Properties properties;
    public static final String PROPERTIES_FILE = "properties.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DBHelper(this);

        studentId = (EditText) findViewById(R.id.studentId);
        studentName = (EditText) findViewById(R.id.studentName);
        studentGrade = (EditText) findViewById(R.id.studentGrade);

        properties = new Properties();
        // manejo de properties
        File file_dir = getFilesDir();
        File file = new File(/*dir*/file_dir, /*name*/PROPERTIES_FILE);
        try {
            if(file.exists()) {
                FileInputStream fis = openFileInput(PROPERTIES_FILE);
                properties.loadFromXML(fis);
                fis.close();

                Toast.makeText(this, "FILE LOADED " + properties.getProperty("name"), Toast.LENGTH_LONG).show();

            } else {
                // create file
                this.saveProperties();
            }

            // Cargar datos al proyecto
            // Assets y Raw
            // Raw - Folder de resources
            // - Indezado en R
            // - No procesa lo que está adentro
            InputStream is = getResources().openRawResource(R.raw.ejemplo);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String temp = "";
            while((temp = br.readLine()) != null) {
                Log.d("RAW", temp);
            }

            AssetManager manager = getAssets();
            is = manager.open("saludos.txt");
            br = new BufferedReader(new InputStreamReader(is));
            while((temp = br.readLine()) != null) {
                Log.d("ASSETS", temp);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }




    }

    public void saveToMemory(View v) {
        properties.put("name", studentName.getText().toString());
    }

    public void saveToFile(View v) {
        try {
            this.saveProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "SAVE TO FILE", Toast.LENGTH_SHORT).show();
    }

    private void saveProperties() throws IOException {
        FileOutputStream fos = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
        properties.storeToXML(fos, null);
        fos.close();

        Toast.makeText(this, "FILE SAVED", Toast.LENGTH_SHORT).show();
    }

    public void insertDB(View v) {
        Toast.makeText(this, "NAME " + studentName.getText().toString()
                                    + " SAVING " + Integer.parseInt(studentGrade.getText().toString()),
                            Toast.LENGTH_SHORT).show();
        dbManager.save(studentName.getText().toString(),
                        Integer.parseInt(studentGrade.getText().toString())
        );

        Toast.makeText(this, "SAVING", Toast.LENGTH_SHORT).show();
    }

    public void findDB(View v) {
        int result = dbManager.find(studentName.getText().toString());
        studentGrade.setText(result + "");

    }

    public void deleteDB(View v) {
        int result = dbManager.delete(Integer.parseInt(studentId.getText().toString()));

        Toast.makeText(this, result + " rows affected", Toast.LENGTH_SHORT).show();

    }
}
