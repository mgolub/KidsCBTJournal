package golub.kidscbtjournal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hindy on 1/4/2016.
 */
public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TherapyDatabase";
    public static final int DATABASE_VERSION = 1;
    public static final String ENTRY_TABLE_NAME = "Entry";
    public static final String ENTRY_COLUMN_ID = "_id";
    public static final String ENTRY_COLUMN_DATE = "EntryDate";
    public static final String ENTRY_COLUMN_EVENT = "EntryEvent";
    public static final String ENTRY_COLUMN_FEELINGB = "Feeling";
    public static final String ENTRY_COLUMN_FEELING = "Feelingb";
    public static final String ENTRY_COLUMN_RATE = "Rate";
    public static final String ENTRY_COLUMN_ACTION = "Action";
    public static final String ENTRY_COLUMN_THOUGHT = "Thought";
    public static final String ENTRY_COLUMN_YESNO = "YesNo";
    public static final String ENTRY_COLUMN_NEXT_TOUGHT = "NextThought";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ENTRY_TABLE_NAME + "(" +
                ENTRY_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ENTRY_COLUMN_DATE + " TEXT, " +
                ENTRY_COLUMN_EVENT + " TEXT, " + ENTRY_COLUMN_FEELING + " TEXT, " + ENTRY_COLUMN_FEELINGB + " TEXT, " +
                ENTRY_COLUMN_RATE + " INTEGER, " + ENTRY_COLUMN_ACTION + " TEXT, " +
                ENTRY_COLUMN_THOUGHT + " TEXT, " + ENTRY_COLUMN_YESNO + " TEXT, " + ENTRY_COLUMN_NEXT_TOUGHT + " TEXT)");
    }

    public boolean insertEntry(String date, String event, String feeling, String feelingb, String rate, String action, String thought, String yesNo, String nextThought) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ENTRY_COLUMN_DATE, date);
        contentValues.put(ENTRY_COLUMN_EVENT, event);
        contentValues.put(ENTRY_COLUMN_FEELING, feeling);
        contentValues.put(ENTRY_COLUMN_FEELINGB, feelingb);
        contentValues.put(ENTRY_COLUMN_RATE, rate);
        contentValues.put(ENTRY_COLUMN_ACTION, action);
        contentValues.put(ENTRY_COLUMN_THOUGHT, thought);
        contentValues.put(ENTRY_COLUMN_YESNO, yesNo);
        contentValues.put(ENTRY_COLUMN_NEXT_TOUGHT, nextThought);
        db.insert(ENTRY_TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getEntry(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + ENTRY_TABLE_NAME + " WHERE " +
                ENTRY_COLUMN_ID + "=?", new String[]{Integer.toString(id)});
        return res;
    }

    public Cursor getAllEntries() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + ENTRY_TABLE_NAME, null);
        return res;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

