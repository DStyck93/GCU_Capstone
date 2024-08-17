package com.dstyx.health_app.database

class Food (
    private val id: Int,
    private val description: String,
    private val group: String,
    private val fat: Float,
    private val protein: Float,
    private val carbs: Float,
    private val sugar: Float,
    private val fiber: Float,
    private val cholesterol: Float,
    private val saturatedFat: Float,
    private val calcium: Float,
    private val iron: Float,
    private val potassium: Float,
    private val vitaminC: Float,
    private val vitaminB12: Float,
    private val vitaminD: Float,
    private val transFat: Float,
    private val sodium: Float,
    private val servingSize: Float,
    private val servingDescription: String
){
    fun getID(): Int {return id}
    fun getDescription(): String {return description}
    fun getGroup(): String {return group}
    fun getFat(): Float {return fat}
    fun getProtein(): Float {return protein}
    fun getCarbs(): Float {return carbs}
    fun getSugar(): Float {return sugar}
    fun getFiber(): Float {return fiber}
    fun getCholesterol(): Float {return cholesterol}
    fun getSaturatedFat(): Float {return saturatedFat}
    fun getCalcium(): Float {return calcium}
    fun getIron(): Float {return iron}
    fun getPotassium(): Float {return potassium}
    fun getVitaminC(): Float {return vitaminC}
    fun getVitaminB12(): Float {return vitaminB12}
    fun getVitaminD(): Float {return vitaminD}
    fun getTransFat(): Float {return transFat}
    fun getSodium(): Float {return sodium}
    fun getServingSize(): Float {return servingSize}
    fun getServingDescription(): String {return servingDescription}

    override fun toString(): String {
        return "Food(id=$id, description='$description', group='$group', fat=$fat, protein=$protein, carbs=$carbs, sugar=$sugar, fiber=$fiber, cholesterol=$cholesterol, saturatedFat=$saturatedFat, calcium=$calcium, iron=$iron, potassium=$potassium, vitaminC=$vitaminC, vitaminB12=$vitaminB12, vitaminD=$vitaminD, transFat=$transFat, sodium=$sodium, servingSize=$servingSize, servingDescription='$servingDescription')"
    }
}