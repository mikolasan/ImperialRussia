package io.github.mikolasan.ratiogenerator

class ImperialUnit(val category: ImperialUnitCategory,
                   val unitType: ImperialUnitType,
                   val unitName: ImperialUnitName
//                   var ratioMap: Map<ImperialUnitName, Double>,
//                   var formulaMap: Map<ImperialUnitName, Array<String>>? = null
) {
    var value: Double = 0.0
    var inputString: String = ""
    var formattedString: String = ""

    var ratioMap: Map<ImperialUnitName, Double> = mapOf()
    var formulaMap: Map<ImperialUnitName, Array<String>> = mapOf()

    fun restoreValue(s: String, v: Double) {
        inputString = s
        value = v
    }

//    fun inputStringToValue() {
//        value = BasicCalculator(inputString).eval()
//    }
}