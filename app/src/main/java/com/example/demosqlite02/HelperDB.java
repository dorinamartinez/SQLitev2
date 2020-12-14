package com.example.demosqlite02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HelperDB extends SQLiteOpenHelper {

    public HelperDB(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }

    public long insertRecord(String nombre, String image, String artista, String genero, String pais, String anio) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.C_NOMBRE, nombre);
        values.put(Constants.C_IMAGE, image);
        values.put(Constants.C_ARTISTA, artista);
        values.put(Constants.C_GENERO, genero);
        values.put(Constants.C_PAIS, pais);
        values.put(Constants.C_ANIO, anio);

        long id = db.insert(Constants.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public ArrayList<ModelRecord> getAllRecords(String orderBy) {
        ArrayList<ModelRecord> recordArrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " ORDER BY " + orderBy;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelRecord modelRecord = new ModelRecord(
                        "" + cursor.getInt(cursor.getColumnIndex(Constants.C_ID)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_NOMBRE)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_ARTISTA)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_GENERO)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_PAIS)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_ANIO))
                );
                recordArrayList.add(modelRecord);
            } while (cursor.moveToNext());
        }

        db.close();
        return recordArrayList;
    }


    public ArrayList<ModelRecord> searchRecords(String query) {
        ArrayList<ModelRecord> recordArrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " WHERE " + Constants.C_NOMBRE + " LIKE '%" + query + "%'";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelRecord modelRecord = new ModelRecord(
                        "" + cursor.getInt(cursor.getColumnIndex(Constants.C_ID)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_NOMBRE)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_ARTISTA)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_GENERO)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_PAIS)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_ANIO))
                );
                recordArrayList.add(modelRecord);
            } while (cursor.moveToNext());
        }

        db.close();
        return recordArrayList;
    }

    public int countRecords() {
        String countQuery = "SELECT * FROM " + Constants.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();
        return count;
    }



}
