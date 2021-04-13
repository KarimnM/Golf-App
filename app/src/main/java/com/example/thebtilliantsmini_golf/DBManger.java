package com.example.thebtilliantsmini_golf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManger {
    private SQLiteDatabase db;

    public DBManger(Context ctx) {
        DBHelper helper = new DBHelper(ctx);
        db = helper.getReadableDatabase();


    }

    public int getLastId() {
        String SQl = "Select * From " + DBHelper.TableName + " ORDER BY " + DBHelper.C1 + " DESC LIMIT 1";
        Cursor cursor = db.rawQuery(SQl, null);
        int id = 0;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            id = cursor.getInt(cursor.getColumnIndex(DBHelper.C1));
            cursor.moveToNext();
        }
        cursor.close();
        return id;
    }


    public boolean insertIngToDataBase(addPlayerActivity r) { //checks the validity of the database

        ContentValues values = new ContentValues();
        //values.put(DBHelper.C2, r.getContent());
        //values.put(DBHelper.C3, r.getrID());
        return db.insert(DBHelper.TableName2, null, values) > -1;
    }





}