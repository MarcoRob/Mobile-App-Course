package mx.itesm.partial1_a01229793;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UXLab on 2/9/18.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "PARTIAL1";
    private static final String TABLE = "FOOD";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_PRICE = "price";

    public DBHelper(Context context) {
        super(context, DATABASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE +
                        "( " + FIELD_ID + " INTEGER PRIMARY KEY, " +
                                FIELD_NAME + " TEXT," +
                                FIELD_PRICE + " TEXT )";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        sqLiteDatabase.execSQL(query, params);
        onCreate(sqLiteDatabase);
    }

    public void addDB(String food_name, String food_price) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_NAME, food_name);
        values.put(FIELD_PRICE, food_price);
        db.insert(TABLE, null, values);
        db.close();
    }

    public String findDB(int id_food) {
        String food_name = "";
        SQLiteDatabase db = getReadableDatabase();
        String query = FIELD_ID + " = ?";
        String[] parameters = {id_food+""};
        Cursor cursor = db.query(TABLE, null, query, parameters, null, null, null);

        if(cursor.moveToFirst()) {
            food_name = cursor.getString(1);
        } else {
            food_name = "";
        }
        db.close();

        return food_name;
    }

    public String findPrice(int id_food){

        SQLiteDatabase db = getReadableDatabase();
        String query = FIELD_ID + " = ?";
        String[] param = {id_food+""};

        Cursor c = db.query(TABLE, null, query, param, null, null, null, null);

        String result = "";

        if(c.moveToFirst()){
            result = c.getString(2);
        }
        db.close();


        return result;
    }

    public int countRows() {
        SQLiteDatabase db = getReadableDatabase();
        int numRows = (int) DatabaseUtils.longForQuery(db, "SELECT COUNT(*) FROM " + TABLE, null);
        db.close();
        return numRows;
        /*String query = "SELECT COUNT(*) FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        return c.getCount();*/
    }

}
