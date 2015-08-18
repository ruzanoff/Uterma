package ru.opi_opi.uterma;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataUserHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Opi.db";
    public static final String TABLE_NAME = "user";
    public static final String COL_1 = "USERNAME";
    public static final String COL_2 = "LANG";
    public static final String COL_3 = "SEX";
    public static final String COL_4 = "AGE";
    public static final String COL_5 = "POINTS";
    public static final String COL_6 = "KEY";

    public DataUserHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(USERNAME TEXT, LANG TEXT, SEX TEXT, AGE INTEGER, POINTS INTEGER, KEY TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void firstData(String username, String lang, String sex, Integer age, Integer points) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, "anonimous");
        contentValues.put(COL_2, "EN");
        contentValues.put(COL_3, "sex");
        contentValues.put(COL_4, 0);
        contentValues.put(COL_5, 10);
        contentValues.put(COL_6, "NONE");
        db.insert(TABLE_NAME, null, contentValues);

    }

    public boolean insertData(String username, String lang, String sex, Integer age, Integer points) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, username);
        contentValues.put(COL_2, lang);
        contentValues.put(COL_3, sex);
        contentValues.put(COL_4, age);
        contentValues.put(COL_5, points);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean updateData(String username, String lang, String sex, Integer age, Integer points) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, username);
        contentValues.put(COL_2, lang);
        contentValues.put(COL_3, sex);
        contentValues.put(COL_4, age);
        contentValues.put(COL_5, points);
        long result = db.update(TABLE_NAME, contentValues, "rowid = 1", null);
        if (result == 1)
            return true;
        else
            return false;
    }

}
