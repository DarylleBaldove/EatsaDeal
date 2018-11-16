package darylle.baldove.com.eatsadeal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private final static String DBNAME = "115.db";
    private final static String table = "resto";
    private static final String COL1 = "ID";
    private static final String COL2 = "RESTO_NAME";
    private static final String COL3 = "RESTO_PLACE";
    private static final String COL4 = "RESTO_TYPE";
    private static final String COL5 = "RESTO_BUDGET";
    private final static int VER = 1;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, VER);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE resto (ID INTEGER PRIMARY KEY AUTOINCREMENT, resto_name TEXT, resto_place TEXT, resto_type TEXT, resto_budget INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable = "DROP TABLE IF EXISTS resto";
        db.execSQL(deleteTable);
        onCreate(db);
    }

    public boolean insert(String resto_name, String resto_type, String resto_place, int resto_budget)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("RNAME", resto_name);
        cv.put("RPLACE", resto_place);
        cv.put("RTYPE", resto_type);
        cv.put("RBUDGET", resto_budget);
        long isInserted = db.insert(table, null, cv);
        if(isInserted != -1) {
            return true;
        }
        else
        {
            return false;
        }
    }


    public Cursor populateTable()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM score";
        return db.rawQuery(query, null);
    }
}
