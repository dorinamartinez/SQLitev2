package com.example.demosqlite02;

public class Constants {

    // nombre de la base de datos
    public static final String DB_NAME = "BD01";
    // db version

    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "CANCIONES";

    // Definir campos de la tabla
    public static final String C_ID = "ID";
    public static final String C_NOMBRE = "NOMBRE";
    public static final String C_IMAGE = "IMAGE";
    public static final String C_ARTISTA = "ARTISTA";
    public static final String C_GENERO = "GENERO";
    public static final String C_PAIS = "PAIS";
    public static final String C_ANIO = "ANIO";

    // Crear consultas de tabla
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_NOMBRE + " TEXT,"
            + C_IMAGE + " TEXT,"
            + C_ARTISTA + " TEXT,"
            + C_GENERO + " TEXT,"
            + C_PAIS + " TEXT,"
            + C_ANIO + " TEXT,"
            + ")";
}