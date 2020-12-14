package com.example.demosqlite02;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;

public class RecordDetailActivity extends AppCompatActivity {

    private CircularImageView civImage3;
    private TextView tvNombre, tvArtista, tvGenero, tvPais;
    private ActionBar actionBar;
    private String recordID;
    private HelperDB helperDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Detalles de la canción");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        recordID = intent.getStringExtra("RECORD_ID");

        helperDB = new HelperDB(this);

        civImage3 = findViewById(R.id.civImage3);
        tvNombre = findViewById(R.id.tvNombre);
        tvArtista = findViewById(R.id.tvArtista);
        tvGenero = findViewById(R.id.tvGenero);
        tvPais = findViewById(R.id.tvPais);

        showRecordDetails();

    }

    private void showRecordDetails() {
        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " WHERE " + Constants.C_ID + " =\"" + recordID + "\"";

        SQLiteDatabase db = helperDB.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String id = "" + cursor.getInt(cursor.getColumnIndex(Constants.C_ID));
                String nombre = "" + cursor.getString(cursor.getColumnIndex(Constants.C_NOMBRE));
                String image = "" + cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE));
                String artista = "" + cursor.getString(cursor.getColumnIndex(Constants.C_ARTISTA));
                String genero = "" + cursor.getString(cursor.getColumnIndex(Constants.C_GENERO));
                String pais = "" + cursor.getString(cursor.getColumnIndex(Constants.C_PAIS));
                String anio = "" + cursor.getString(cursor.getColumnIndex(Constants.C_ANIO));

                if (image.equals("null")) {
                    civImage3.setImageResource(R.drawable.ic_launcher_foreground);
                } else {
                    civImage3.setImageURI(Uri.parse(image));
                }
                tvNombre.setText(nombre);
                tvArtista.setText(artista);
                tvGenero.setText(genero);
                tvPais.setText(pais);

            } while (cursor.moveToNext());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}