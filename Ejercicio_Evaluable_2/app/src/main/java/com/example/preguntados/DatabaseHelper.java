package com.example.preguntados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DBRanking.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TBL_RANKING = "Ranking";
    private static final String COL_ID = "id";
    private static final String COL_NOMBRE = "nombre";
    private static final String COL_PUNTOS = "puntos";

    private static final String SQL_CREATE = "CREATE TABLE " + TBL_RANKING + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NOMBRE + " TEXT, " +
            COL_PUNTOS + " INTEGER" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_RANKING);
        onCreate(db);
    }

    // Inserta un jugador o suma puntos si ya existe
    public void insertarJugador(String nombre, int puntos) {
        SQLiteDatabase db = getWritableDatabase();

        // Comprobamos si ya existe ese nombre
        String where = COL_NOMBRE + " = '" + nombre + "'";

        try (Cursor c = db.query(
                TBL_RANKING,
                new String[]{COL_PUNTOS},
                where,
                null, null, null, null)) {

            if (c.moveToFirst()) {
                int puntosActuales = c.getInt(0);
                int nuevosPuntos = puntosActuales + puntos;

                ContentValues valores = new ContentValues();
                valores.put(COL_PUNTOS, nuevosPuntos);

                db.update(TBL_RANKING, valores, where, null);
            } else {
                ContentValues valores = new ContentValues();
                valores.put(COL_NOMBRE, nombre);
                valores.put(COL_PUNTOS, puntos);
                db.insert(TBL_RANKING, null, valores);
            }
        }

        db.close();
    }

    // Obtener ranking ordenado por puntos descendente
    public Cursor obtenerRanking() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TBL_RANKING + " ORDER BY " + COL_PUNTOS + " DESC", null);
    }
}
