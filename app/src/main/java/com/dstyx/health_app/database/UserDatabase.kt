package com.dstyx.health_app.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val USER_TABLE = "USER_TABLE"
const val COLUMN_USER_ID = "USER_ID"
const val COLUMN_USERNAME = "USERNAME"
const val COLUMN_BIRTHDAY = "BIRTHDAY"
const val COLUMN_WEIGHT = "WEIGHT"
const val COLUMN_HEIGHT = "HEIGHT"

class UserDatabase(
    context: Context?,
    name: String = "user.db",
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = 1
) : SQLiteOpenHelper(context, name, factory, version) {

    // Called first time database is accessed
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableStatement = """
            CREATE TABLE $USER_TABLE(
            $COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_USERNAME TEXT UNIQUE,
            $COLUMN_BIRTHDAY TEXT,
            $COLUMN_WEIGHT REAL,
            $COLUMN_HEIGHT REAL
            );
        """.trimIndent()

        db?.execSQL(createTableStatement)
    }

    // Called when version number changes
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    // Add item to database
    fun add(user: User) {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_USERNAME, user.getUsername())
        cv.put(COLUMN_BIRTHDAY, user.getBirthday())
        cv.put(COLUMN_WEIGHT, user.getWeight())
        cv.put(COLUMN_HEIGHT, user.getHeight())

        db.insert(USER_TABLE, null, cv)
    }

    // Returns a list of users
    fun getAll() : List<User> {
        val returnList = ArrayList<User>()

        // Get data from the database
        val queryString = "SELECT * FROM $USER_TABLE"
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery(queryString, null)

        // Loop through results, and create new object for each row
        if (cursor.moveToFirst()) {
            do {
                val userID = cursor.getInt(0)
                val username = cursor.getString(1)
                val birthday = cursor.getString(2)
                val weight = cursor.getFloat(3)
                val height = cursor.getFloat(4)

                val user = User(userID, username, birthday, weight, height)
                returnList.add(user)

            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return returnList
    }

    // Deletes a user
    fun delete(user: User) {
        val db = this.writableDatabase
        val queryString = "DELETE FROM $USER_TABLE WHERE $COLUMN_USER_ID = ${user.getID()};"
        val cursor = db.rawQuery(queryString, null)

        db.close()
        cursor.close()
    }
}