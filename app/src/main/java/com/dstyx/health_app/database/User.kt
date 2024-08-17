package com.dstyx.health_app.database

class User (
    private val id: Int,
    private var username: String,// FIXME -- Change to Date
    private var birthday: String,// Pounds
    private var weight: Float,// Inches
    private var height: Float
) {
    fun getID(): Int {return id}
    fun getUsername(): String {return username}
    fun getBirthday(): String {return birthday}
    fun getWeight(): Float {return weight}
    fun getHeight(): Float {return height}

    override fun toString(): String {
        return "User(id=$id, username='$username', birthday='$birthday', weight=$weight lbs, height=$height)"
    }
}







