package io.github.mikolasan.imperialrussia

import java.lang.Exception

object LengthUnits {
    val arshinRatio = mutableMapOf(
            ImperialUnitName.TIP to 0.0625,
            ImperialUnitName.QUARTER to 0.25,
            ImperialUnitName.FOOT to 0.4285714285714286,
            ImperialUnitName.FATHOM to 3.0, // 1 fathom = 3 arshin
            ImperialUnitName.TURN to 1500.0,
            ImperialUnitName.MILE to 10500.0
    )

    val inchRatio = mutableMapOf(
            ImperialUnitName.TIP to 1.75,
            ImperialUnitName.PALM to 2.9375,
            ImperialUnitName.QUARTER to 7.0,
            ImperialUnitName.FOOT to 12.0,
            ImperialUnitName.YARD to 28.0,
            ImperialUnitName.FATHOM to 84.0, // 1 fathom = 84 inches
            ImperialUnitName.TURN to 42000.0,
            ImperialUnitName.MILE to 294000.0
    )

    val centimeterRatio = mutableMapOf(
            ImperialUnitName.METER to 100.0,
            ImperialUnitName.INCH to 2.54,
            ImperialUnitName.TIP to 4.445,
            ImperialUnitName.PALM to 7.5,
            ImperialUnitName.QUARTER to 17.78,
            ImperialUnitName.FOOT to 30.48,
            ImperialUnitName.YARD to 71.12
    )

    val millimeterRatio = mutableMapOf(
            ImperialUnitName.POINT to 0.254,
            ImperialUnitName.LINE to 2.54,
            ImperialUnitName.METER to 0.001,
            ImperialUnitName.YARD to 0.7112
    )

    val kilometerRatio = mutableMapOf(
            ImperialUnitName.TURN to 1.0668,
            ImperialUnitName.MILE to 7.4676,
            ImperialUnitName.METER to 0.001
    )

    val lengthUnits = arrayOf(
            ImperialUnit(R.string.unit_kilometer, ImperialUnitName.KILOMETER, kilometerRatio),
            ImperialUnit(R.string.unit_meter, ImperialUnitName.METER, mutableMapOf(ImperialUnitName.CENTIMETER to 0.01)),
            ImperialUnit(R.string.unit_decimeter, ImperialUnitName.DECIMETER, mutableMapOf(
                    ImperialUnitName.METER to 10.0,
                    ImperialUnitName.YARD to 7.112)),
            ImperialUnit(R.string.unit_centimeter, ImperialUnitName.CENTIMETER, centimeterRatio),
            ImperialUnit(R.string.unit_millimeter, ImperialUnitName.MILLIMETER, millimeterRatio),
            ImperialUnit(R.string.unit_micrometer, ImperialUnitName.MICROMETER, mutableMapOf(ImperialUnitName.MILLIMETER to 10.0)),
            ImperialUnit(R.string.unit_arshin, ImperialUnitName.YARD, arshinRatio),
            ImperialUnit(R.string.unit_inch, ImperialUnitName.INCH, inchRatio),
            ImperialUnit(R.string.unit_point, ImperialUnitName.POINT, mutableMapOf(ImperialUnitName.INCH to 100.0)),
            ImperialUnit(R.string.unit_line, ImperialUnitName.LINE, mutableMapOf(ImperialUnitName.INCH to 10.0)),
            ImperialUnit(R.string.unit_tip, ImperialUnitName.TIP, mutableMapOf(ImperialUnitName.YARD to 16.0)),
            ImperialUnit(R.string.unit_palm, ImperialUnitName.PALM, mutableMapOf(ImperialUnitName.INCH to 16.0/47.0)),
            ImperialUnit(R.string.unit_quarter, ImperialUnitName.QUARTER, mutableMapOf(ImperialUnitName.YARD to 4.0)),
            ImperialUnit(R.string.unit_foot, ImperialUnitName.FOOT, mutableMapOf(ImperialUnitName.YARD to 7.0/3.0)),
            ImperialUnit(R.string.unit_fathom, ImperialUnitName.FATHOM, mutableMapOf(ImperialUnitName.YARD to 1.0/3.0)),
            ImperialUnit(R.string.unit_turn, ImperialUnitName.TURN, mutableMapOf(ImperialUnitName.YARD to 1.0/1500.0)),
            ImperialUnit(R.string.unit_mile, ImperialUnitName.MILE, mutableMapOf(ImperialUnitName.YARD to 1.0/10500.0))
    )

    private fun makeUnitByNameMap(units: Array<ImperialUnit>): Map<ImperialUnitName, ImperialUnit> {
        val map: MutableMap<ImperialUnitName, ImperialUnit> = mutableMapOf()
        units.forEach {
            map[it.unitName] = it
        }
        return map.toMap()
    }

    val imperialUnits = makeUnitByNameMap(lengthUnits)

    fun findConversionRatio(inputUnit: ImperialUnit, outputUnit: ImperialUnit): Double {
        val inputMap = inputUnit.ratioMap
        val outputMap = outputUnit.ratioMap
        val ratio = outputMap.get(inputUnit.unitName)
        if (ratio != null) return ratio

        val inverse = inputMap.get(outputUnit.unitName)
        if (inverse != null) return 1.0/inverse

        for ((unitName,k) in inputMap) {
            val commonUnitRatio = outputMap.get(unitName)
            commonUnitRatio?.let {
                val newRatio = commonUnitRatio / k
                //outputMap[inputUnit.unitName] = newRatio
                return newRatio
            }

            val inverseCommonUnit = imperialUnits[unitName]
            inverseCommonUnit?.let {
                val newRatio = inverseCommonUnit.ratioMap.get(outputUnit.unitName)
                if (newRatio != null)
                    return 1.0 / (k * newRatio)
            }
        }

        for ((unitName,k) in outputMap) {
            try {
                val unit = imperialUnits[unitName]
                if (unit != null) return findConversionRatio(inputUnit, unit) * k
            } catch (e: Exception) {

            }
        }

        throw Exception("no ratio")
    }

    fun convertValue(inputUnit: ImperialUnit?, outputUnit: ImperialUnit?, inputValue: Double): Double {
        val input = inputUnit ?: return 0.0
        val output = outputUnit ?: return 0.0
        return inputValue * findConversionRatio(input, output)
    }
}