package mx.itesm.appwithkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        printMessage("Hello Kotlin!")
    }

    private fun printMessage(mensaje : String) {
        Log.wtf("PRINT", mensaje);
    }
}
