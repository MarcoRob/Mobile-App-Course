package mx.itesm.appwithdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marco on 08/02/2018.
 */

public class DBManager extends SQLiteOpenHelper {
    private static final String DB = "APPDB.db";
    private static final String TABLE = "Hobbies";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_HOBBY = "hobby";

    public DBManager(Context context) {
        super(context, DB, null, 1);
    }

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String HOBBY_TABLE = "CREATE TABLE " + TABLE + "( " +
                             FIELD_NAME + " TEXT, " +
                             FIELD_HOBBY + " TEXT, " +
                             FIELD_ID + " INTEGER PRIMARY KEY)";
        sqLiteDatabase.execSQL(HOBBY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String UPGRADE_HOBBY_TABLE = "DROP TABLE IF EXITS ?";
        String[] params = {TABLE};
        sqLiteDatabase.execSQL(UPGRADE_HOBBY_TABLE);
        this.onCreate(sqLiteDatabase);
    }

    public void saveNameAndHobby(String name, String hobby) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_NAME, name);
        values.put(FIELD_HOBBY, hobby);

        db.insert(TABLE, null, values);
    }

    public String findByName(String name) {
        SQLiteDatabase db = getReadableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] args = {name};
        Cursor cursor = db.query(TABLE, null, clause, args, null, null, null, null);
        String result = "";
        if(cursor.moveToFirst()) {
            result = cursor.getString(1);
        }
        return result;
    }

    public int deleteByName(String name) {
        SQLiteDatabase db = getWritableDatabase();
        String query = FIELD_NAME + " = ?";
        String[] params = {name};
        return db.delete(TABLE, query, params);
    }



}
