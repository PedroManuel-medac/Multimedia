package com.example.ejercicio_8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Configuración básica
    private static final String DATABASE_NAME = "DBProfesores.db";
    private static final int DATABASE_VERSION = 1;


    //Esquema de la tabla
    private static final String TBL_PROFESORES = "Profesores";
    private static final String COL_ID = "id";
    private static final String COL_NOMBRE = "nombre";
    private static final String COL_APELLIDO = "apellido";

    private static final String SQL_CREATE = "CREATE TABLE " + TBL_PROFESORES + "(" +
            COL_ID + "Integer Primary KEY AUTOINCREMENT, " + COL_NOMBRE + "TEXT, " +
            COL_APELLIDO + "TEXT" + ")";

    //Constructor
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    //Metodo obligatorio: se ejecuta la primera vez que se crea la BD
    public void onCreate(SQLiteDatabase db){
        //Creamos la tabla
        db.execSQL(SQL_CREATE);

        //Insertar 2 profesores
        insertarProfesor(db, "Pilar", "Garcia");
        insertarProfesor(db, "Jose", "Lopez");
    }

    //Metodo obligatorio: no en este ejercicio pq no habrá cambio de version
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TBL_PROFESORES);
        onCreate(db);
    }


    //Metodos especificos
    //Para insertar profesor

    private void insertarProfesor(SQLiteDatabase db, String nombre, String apellido){
        ContentValues valores = new ContentValues();
        valores.put(COL_NOMBRE, nombre);
        valores.put(COL_APELLIDO, apellido);
        db.insert(TBL_PROFESORES, null, valores);
    }

    //Comprueba si existe un profesor con ese nombre y apellido
    public boolean existeProfesor(String nombre, String apellido){
        SQLiteDatabase db = getReadableDatabase();

        //Construimos manualmente la condición WHERE
        String where = COL_NOMBRE + " = '" + nombre + "' AND " + COL_APELLIDO + " = '" + apellido + "'";

        try(Cursor c = db.query(
                TBL_PROFESORES,
                new String[]{COL_ID}, //Solo pedimos el id
                where,                //Usamos la condicion directamente
                null, null, null, null,
                "1"                   //Limite 1
        )){
            return c.moveToFirst(); //true si hay al menos un registro
        }
    }

}
