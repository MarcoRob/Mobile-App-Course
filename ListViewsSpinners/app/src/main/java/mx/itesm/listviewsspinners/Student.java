package mx.itesm.listviewsspinners;

/**
 * Created by marco on 02/02/2018.
 */

public class Student {

    private String nombre;
    private float calification;

    public String getNombre() {
        return nombre;
    }

    public float getCalification() {
        return calification;
    }

    public Student(String nombre, float calification) {
        this.nombre = nombre;
        this.calification = calification;
    }
}
