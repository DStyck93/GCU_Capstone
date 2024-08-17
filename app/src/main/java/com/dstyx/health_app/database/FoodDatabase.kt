package com.dstyx.health_app.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

const val FOOD_TABLE = "FOOD_TABLE"
const val COLUMN_FOOD_ID = "FOOD_ID"
const val COLUMN_DESCRIPTION = "DESCRIPTION"
const val COLUMN_GROUP = "FOOD_GROUP"
const val COLUMN_FAT = "FAT"
const val COLUMN_PROTEIN = "PROTEIN"
const val COLUMN_CARBS = "CARBS"
const val COLUMN_SUGAR = "SUGAR"
const val COLUMN_FIBER = "FIBER"
const val COLUMN_CHOLESTEROL = "CHOLESTEROL"
const val COLUMN_SATURATED_FAT = "SATURATED_FAT"
const val COLUMN_CALCIUM = "CALCIUM"
const val COLUMN_IRON = "IRON"
const val COLUMN_POTASSIUM = "POTASSIUM"
const val COLUMN_VITAMIN_C = "VITAMIN_C"
const val COLUMN_VITAMIN_B12 = "VITAMIN_B12"
const val COLUMN_VITAMIN_D = "VITAMIN_D"
const val COLUMN_TRANS_FAT = "TRANS_FAT"
const val COLUMN_SODIUM = "SODIUM"
const val COLUMN_SERVING_SIZE = "SERVING_SIZE"
const val COLUMN_SERVING_DESCRIPTION = "SERVING_DESCRIPTION"

class FoodDatabase (
    context: Context?,
    name: String = "food.db",
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = 1
) : SQLiteOpenHelper(context, name, factory, version){

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableStatement = """
            CREATE TABLE $FOOD_TABLE (
            $COLUMN_FOOD_ID INTEGER PRIMARY KEY,
            $COLUMN_DESCRIPTION TEXT UNIQUE,
            $COLUMN_GROUP TEXT,
            $COLUMN_FAT REAL,
            $COLUMN_PROTEIN REAL,
            $COLUMN_CARBS REAL,
            $COLUMN_SUGAR REAL,
            $COLUMN_FIBER REAL,
            $COLUMN_CHOLESTEROL REAL,
            $COLUMN_SATURATED_FAT REAL,
            $COLUMN_CALCIUM REAL,
            $COLUMN_IRON REAL,
            $COLUMN_POTASSIUM REAL,
            $COLUMN_VITAMIN_C REAL,
            $COLUMN_VITAMIN_B12 REAL,
            $COLUMN_VITAMIN_D REAL,
            $COLUMN_TRANS_FAT REAL,
            $COLUMN_SODIUM REAL,
            $COLUMN_SERVING_SIZE REAL,
            $COLUMN_SERVING_DESCRIPTION TEXT
            );
        """.trimIndent()

        db?.execSQL(createTableStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun add(food: Food) {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_FOOD_ID, food.getID())
        cv.put(COLUMN_DESCRIPTION, food.getDescription())
        cv.put(COLUMN_GROUP, food.getGroup())
        cv.put(COLUMN_FAT, food.getFat())
        cv.put(COLUMN_PROTEIN, food.getProtein())
        cv.put(COLUMN_CARBS, food.getCarbs())
        cv.put(COLUMN_SUGAR, food.getSugar())
        cv.put(COLUMN_FIBER, food.getFiber())
        cv.put(COLUMN_CHOLESTEROL, food.getCholesterol())
        cv.put(COLUMN_SATURATED_FAT, food.getSaturatedFat())
        cv.put(COLUMN_CALCIUM, food.getCalcium())
        cv.put(COLUMN_IRON, food.getIron())
        cv.put(COLUMN_POTASSIUM, food.getPotassium())
        cv.put(COLUMN_VITAMIN_C, food.getVitaminC())
        cv.put(COLUMN_VITAMIN_B12, food.getVitaminB12())
        cv.put(COLUMN_VITAMIN_D, food.getVitaminD())
        cv.put(COLUMN_TRANS_FAT, food.getTransFat())
        cv.put(COLUMN_SODIUM, food.getSodium())
        cv.put(COLUMN_SERVING_SIZE, food.getServingSize())
        cv.put(COLUMN_SERVING_DESCRIPTION, food.getServingDescription())

        db.insert(FOOD_TABLE, null, cv)
    }

    fun delete(food: Food) {
        val db = this.writableDatabase
        val queryString = "DELETE FROM $FOOD_TABLE WHERE $COLUMN_FOOD_ID = ${food.getID()};"
        val cursor = db.rawQuery(queryString, null)

        db.close()
        cursor.close()
    }
}