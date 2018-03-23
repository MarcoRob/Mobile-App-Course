package mx.itesm.appwithdb;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    public static final String PROPERTY_FILE = "properties.xml";

    private File file_directory;
    private File property_file;
    private Properties properties;

    private TextView hi_1;
    private TextView hi_2;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.properties = new Properties();
        this.file_directory = getFilesDir();
        this.property_file = new File(this.file_directory, PROPERTY_FILE);

        this.hi_1 = (TextView) findViewById(R.id.hi_1);
        this.hi_2 = (TextView) findViewById(R.id.hi_2);
        this.name = (EditText) findViewById(R.id.name);

        try {
            this.hi_1.setText(this.readFromRaw());
            this.hi_2.setText(this.readFromAssets());

            if(!this.property_file.exists()) {
                this.createPropertyFile();
                //this.setNameFromPropertyFile("NombreTEST");
                String name = this.getNameFromPropertyFile();
                this.name.setText(name);
                Toast.makeText(this, name, Toast.LENGTH_LONG).show();
            } else {
                this.savePropertyFile();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void saveNameBT (View v) {
        String name = this.name.getText().toString();
        Toast.makeText(this, "SAVE " + name, Toast.LENGTH_LONG).show();
        this.setNameFromPropertyFile(name);

        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    private String getNameFromPropertyFile() {
        return this.properties.getProperty("name");
    }

    private void createPropertyFile() throws IOException{
        FileInputStream fileIn = openFileInput(PROPERTY_FILE);
        this.properties.loadFromXML(fileIn);
        fileIn.close();
    }

    private void savePropertyFile() throws IOException {
        FileOutputStream fileOut = openFileOutput(PROPERTY_FILE, Context.MODE_PRIVATE);
        this.properties.storeToXML(fileOut, null);
        fileOut.close();
        Toast.makeText(this, "FILE SAVED", Toast.LENGTH_SHORT).show();
    }

    private void setNameFromPropertyFile(String data)  {
        this.properties.put("name", data);
    }

    private String readFromRaw() throws IOException {
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = br.readLine();
        return str;
    }

    private String readFromAssets() throws IOException {
        AssetManager manager = getAssets();
        InputStream is = manager.open("data.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String data = br.readLine();
        return data;
    }

}
