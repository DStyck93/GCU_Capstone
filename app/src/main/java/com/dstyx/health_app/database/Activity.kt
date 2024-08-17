package com.dstyx.health_app.database

class Activity (
    private val id: Int,
    private val group: String,
    private val variations: String,
    private val met: Float,
    private val ageGroup: String
){
    fun getID(): Int {return id}
    fun getGroup(): String {return group}
    fun getVariations(): String {return variations}
    fun getMET(): Float {return met}
    fun getAgeGroup(): String {return ageGroup}

    override fun toString(): String {
        return "Activity(id=$id, group='$group', variations=$variations, met=$met, ageGroup='$ageGroup')"
    }
}