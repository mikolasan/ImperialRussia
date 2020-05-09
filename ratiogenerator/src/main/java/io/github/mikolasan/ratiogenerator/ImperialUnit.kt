package io.github.mikolasan.ratiogenerator

class ImperialUnit(val unitName: ImperialUnitName, val ratioMap: MutableMap<ImperialUnitName, Double>) {
    val type: ImperialUnitType = ImperialUnitType.LENGTH
    var value: Double = 0.0
    var inputString: String = ""
    var formattedString: String = ""

//    fun inputStringToValue() {
//        value = BasicCalculator(inputString).eval()
//    }
}