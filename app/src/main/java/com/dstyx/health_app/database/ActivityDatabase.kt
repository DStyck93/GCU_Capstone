package com.dstyx.health_app.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val ACTIVITY_TABLE = "ACTIVITY_TABLE"
const val COLUMN_ACTIVITY_ID = "ACTIVITY_ID"
const val COLUMN_VARIATIONS = "VARIATIONS"
const val COLUMN_MET = "MET"
const val COLUMN_AGE_GROUP = "AGE_GROUP"

class ActivityDatabase (
    context: Context?,
    name: String = "activity.db",
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = 1
    ) : SQLiteOpenHelper(context, name, factory, version){

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableStatement = """
            CREATE TABLE $ACTIVITY_TABLE (
            $COLUMN_ACTIVITY_ID INTEGER PRIMARY KEY,
            $COLUMN_VARIATIONS TEXT UNIQUE,
            $COLUMN_MET REAL,
            $COLUMN_AGE_GROUP STRING
            );
        """.trimIndent()

        db?.execSQL(createTableStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun add(activity: Activity) {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_ACTIVITY_ID, activity.getID())
        cv.put(COLUMN_VARIATIONS, activity.getVariations())
        cv.put(COLUMN_MET, activity.getMET())
        cv.put(COLUMN_AGE_GROUP, activity.getAgeGroup())

        db.insert(ACTIVITY_TABLE, null, cv)
    }

    fun delete(activity: Activity) {
        val db = this.writableDatabase
        val queryString = "DELETE FROM $ACTIVITY_TABLE WHERE $COLUMN_ACTIVITY_ID = ${activity.getID()};"
        val cursor = db.rawQuery(queryString, null)

        db.close()
        cursor.close()
    }
}