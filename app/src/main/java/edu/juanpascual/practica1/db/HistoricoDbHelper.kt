package edu.juanpascual.practica1.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import edu.juanpascual.practica1.model.Persona
import edu.juanpascual.practica1.model.Registro

class HistoricoDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "historico.db"
        private const val DATABASE_VERSION = 1

        const val TABLE_REGISTRO = "registro"
        const val COLUMN_ID = "ID"
        const val COLUMN_FECHA = "fecha"
        const val COLUMN_SEXO = "sexo"
        const val COLUMN_IMC = "imc"
        const val COLUMN_PESO = "peso"
        const val COLUMN_ALTURA = "altura"
        const val COLUMN_ESTADO = "estado"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE $TABLE_REGISTRO ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "$COLUMN_FECHA TEXT,"
                + "$COLUMN_SEXO TEXT,"
                + "$COLUMN_IMC REAL,"
                + "$COLUMN_PESO REAL,"
                + "$COLUMN_ALTURA REAL,"
                + "$COLUMN_ESTADO TEXT)")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_REGISTRO")
        onCreate(db)
    }

    // Insert a new registro
    fun insertRegistro(registro: Registro): Long {
        val fecha = registro.getFecha()
        val sexo = registro.getPersona().getGenero()
        val imc = registro.getPersona().getIMC()
        val peso = registro.getPersona().getPeso()
        val altura = registro.getPersona().getAltura()
        val estado = registro.getPersona().getCalificacion()

        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_FECHA, fecha)
            put(COLUMN_SEXO, sexo)
            put(COLUMN_IMC, imc)
            put(COLUMN_PESO, peso)
            put(COLUMN_ALTURA, altura)
            put(COLUMN_ESTADO, estado)
        }
        return db.insert(TABLE_REGISTRO, null, values)
    }

    // Read all registros
    fun getAllRegistros(): MutableList<Registro> {
        val db = this.readableDatabase
        val registros = mutableListOf<Registro>()

        db.rawQuery("SELECT * FROM $TABLE_REGISTRO", null).use { cursor ->
            while (cursor.moveToNext()) {
                val registro = parseCursorToRegistro(cursor)
                registros.add(registro)
            }
        }


        return registros
    }

    // Read a single registro by ID
    fun getRegistroById(id: Int): Registro? {
        val db = this.readableDatabase
        var registro: Registro? = null

        db.rawQuery("SELECT * FROM $TABLE_REGISTRO WHERE $COLUMN_ID = ?", arrayOf(id.toString())).use { cursor ->
            while (cursor.moveToNext()) {
                registro = parseCursorToRegistro(cursor)
            }
        }

        return registro
    }

    // Update a registro
    fun updateRegistro(id: Int, registro: Registro): Int {
        val fecha = registro.getFecha()
        val sexo = registro.getPersona().getGenero()
        val imc = registro.getPersona().getIMC()
        val peso = registro.getPersona().getPeso()
        val altura = registro.getPersona().getAltura()
        val estado = registro.getPersona().getCalificacion()

        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_FECHA, fecha)
            put(COLUMN_SEXO, sexo)
            put(COLUMN_IMC, imc)
            put(COLUMN_PESO, peso)
            put(COLUMN_ALTURA, altura)
            put(COLUMN_ESTADO, estado)
        }
        return db.update(TABLE_REGISTRO, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }

    // Delete a registro
    fun deleteRegistro(id: Int): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_REGISTRO, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }

    private fun parseCursorToRegistro(cursor: Cursor): Registro {
        val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
        val fecha = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FECHA))
        val peso = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_PESO))
        val altura = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_ALTURA))
        val sexo = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SEXO))

        val persona = Persona(peso, altura, sexo)

        return Registro(persona, id, fecha)
    }
}
