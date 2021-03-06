package io.github.mikolasan.imperialrussia

import io.github.mikolasan.ratiogenerator.ImperialUnit
import io.github.mikolasan.ratiogenerator.ImperialUnitName
import io.github.mikolasan.ratiogenerator.ImperialUnitType
import io.github.mikolasan.ratiogenerator.ImperialUnits
import kotlin.Array
import kotlin.collections.Map

object VolumeUnits : ImperialUnits() {
    override val units: Array<ImperialUnit> = arrayOf(
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.GARNETS, mapOf(
                    ImperialUnitName.GARNETS to 1.0,
                    ImperialUnitName.VEDRO to 0.25,
                    ImperialUnitName.OSMINA to 0.03125,
                    ImperialUnitName.SHKALIK to 50.0,
                    ImperialUnitName.SHTOF to 2.5,
                    ImperialUnitName.CHARKA to 100.0,
                    ImperialUnitName.SOROKOVKA to 0.625,
                    ImperialUnitName.LITER to 0.2538600486611126,
                    ImperialUnitName.MILLILITER to 0.8130081300813008,
                    ImperialUnitName.GALLON to 0.09225092250922509,
                    ImperialUnitName.FLUID_ONCE to 23.148148148148145,
                    ImperialUnitName.PINT to 1.1574074074074072,
                    ImperialUnitName.QUART to 0.28851702250432776,
                    ImperialUnitName.BOCHKA to 10.0)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.VEDRO, mapOf(
                    ImperialUnitName.GARNETS to 4.0,
                    ImperialUnitName.VEDRO to 1.0,
                    ImperialUnitName.OSMINA to 0.125,
                    ImperialUnitName.SHKALIK to 200.0,
                    ImperialUnitName.SHTOF to 10.0,
                    ImperialUnitName.CHARKA to 400.0,
                    ImperialUnitName.SOROKOVKA to 2.5,
                    ImperialUnitName.LITER to 8.130081300813009,
                    ImperialUnitName.MILLILITER to 3.252032520325203,
                    ImperialUnitName.GALLON to 0.36900369003690037,
                    ImperialUnitName.FLUID_ONCE to 92.59259259259258,
                    ImperialUnitName.PINT to 4.629629629629629,
                    ImperialUnitName.QUART to 1.154068090017311,
                    ImperialUnitName.BOCHKA to 40.0)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.OSMINA, mapOf(
                    ImperialUnitName.GARNETS to 32.0,
                    ImperialUnitName.VEDRO to 8.0,
                    ImperialUnitName.OSMINA to 1.0,
                    ImperialUnitName.SHKALIK to 1600.0,
                    ImperialUnitName.SHTOF to 80.0,
                    ImperialUnitName.CHARKA to 3200.0,
                    ImperialUnitName.SOROKOVKA to 20.0,
                    ImperialUnitName.LITER to 8.123521557155604,
                    ImperialUnitName.MILLILITER to 26.016260162601625,
                    ImperialUnitName.GALLON to 2.952029520295203,
                    ImperialUnitName.FLUID_ONCE to 740.7407407407406,
                    ImperialUnitName.PINT to 37.03703703703703,
                    ImperialUnitName.QUART to 9.232544720138488,
                    ImperialUnitName.BOCHKA to 320.0)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.SHKALIK, mapOf(
                    ImperialUnitName.GARNETS to 0.02,
                    ImperialUnitName.VEDRO to 0.005,
                    ImperialUnitName.OSMINA to 6.25E-4,
                    ImperialUnitName.SHKALIK to 1.0,
                    ImperialUnitName.SHTOF to 0.049999999999999996,
                    ImperialUnitName.CHARKA to 2.0,
                    ImperialUnitName.SOROKOVKA to 0.0125,
                    ImperialUnitName.LITER to 0.04065040650406505,
                    ImperialUnitName.MILLILITER to 0.016260162601626018,
                    ImperialUnitName.GALLON to 0.001845018450184502,
                    ImperialUnitName.FLUID_ONCE to 0.4629629629629629,
                    ImperialUnitName.PINT to 0.023148148148148143,
                    ImperialUnitName.QUART to 0.005770340450086555,
                    ImperialUnitName.BOCHKA to 0.19999999999999998)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.SHTOF, mapOf(
                    ImperialUnitName.GARNETS to 0.4,
                    ImperialUnitName.VEDRO to 0.1,
                    ImperialUnitName.OSMINA to 0.0125,
                    ImperialUnitName.SHKALIK to 20.0,
                    ImperialUnitName.SHTOF to 1.0,
                    ImperialUnitName.CHARKA to 40.0,
                    ImperialUnitName.SOROKOVKA to 0.25,
                    ImperialUnitName.LITER to 0.8130081300813008,
                    ImperialUnitName.MILLILITER to 8.14700919626251E-4,
                    ImperialUnitName.GALLON to 0.057870370370370364,
                    ImperialUnitName.FLUID_ONCE to 9.259259259259258,
                    ImperialUnitName.PINT to 0.4629629629629629,
                    ImperialUnitName.QUART to 0.23148148148148145,
                    ImperialUnitName.BOCHKA to 4.0)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.CHARKA, mapOf(
                    ImperialUnitName.GARNETS to 0.01,
                    ImperialUnitName.VEDRO to 0.0025,
                    ImperialUnitName.OSMINA to 3.125E-4,
                    ImperialUnitName.SHKALIK to 0.5,
                    ImperialUnitName.SHTOF to 0.024999999999999998,
                    ImperialUnitName.CHARKA to 1.0,
                    ImperialUnitName.SOROKOVKA to 0.00625,
                    ImperialUnitName.LITER to 0.020325203252032523,
                    ImperialUnitName.MILLILITER to 0.008130081300813009,
                    ImperialUnitName.GALLON to 9.22509225092251E-4,
                    ImperialUnitName.FLUID_ONCE to 0.23094688221709006,
                    ImperialUnitName.PINT to 0.011574074074074072,
                    ImperialUnitName.QUART to 0.0028851702250432777,
                    ImperialUnitName.BOCHKA to 0.09999999999999999)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.SOROKOVKA, mapOf(
                    ImperialUnitName.GARNETS to 1.6,
                    ImperialUnitName.VEDRO to 0.4,
                    ImperialUnitName.OSMINA to 0.05,
                    ImperialUnitName.SHKALIK to 80.0,
                    ImperialUnitName.SHTOF to 4.0,
                    ImperialUnitName.CHARKA to 160.0,
                    ImperialUnitName.SOROKOVKA to 1.0,
                    ImperialUnitName.LITER to 3.252032520325203,
                    ImperialUnitName.MILLILITER to 0.003258803678505004,
                    ImperialUnitName.GALLON to 0.23148148148148145,
                    ImperialUnitName.FLUID_ONCE to 37.03703703703703,
                    ImperialUnitName.PINT to 1.8518518518518516,
                    ImperialUnitName.QUART to 0.9259259259259258,
                    ImperialUnitName.BOCHKA to 16.0)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.LITER, mapOf(
                    ImperialUnitName.GARNETS to 3.9391783200000003,
                    ImperialUnitName.VEDRO to 0.9847945800000001,
                    ImperialUnitName.OSMINA to 0.12309932250000001,
                    ImperialUnitName.SHKALIK to 98.195328,
                    ImperialUnitName.SHTOF to 1.23,
                    ImperialUnitName.CHARKA to 196.390656,
                    ImperialUnitName.SOROKOVKA to 0.3075,
                    ImperialUnitName.LITER to 1.0,
                    ImperialUnitName.MILLILITER to 0.003999991201230068,
                    ImperialUnitName.GALLON to 0.28413,
                    ImperialUnitName.FLUID_ONCE to 45.46079999999999,
                    ImperialUnitName.PINT to 0.5694444444444444,
                    ImperialUnitName.QUART to 1.13652,
                    ImperialUnitName.BOCHKA to 19.639065600000002)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.MILLILITER, mapOf(
                    ImperialUnitName.GARNETS to 490.9777200000001,
                    ImperialUnitName.VEDRO to 122.74443000000002,
                    ImperialUnitName.OSMINA to 15.343053750000003,
                    ImperialUnitName.SHKALIK to 61.5,
                    ImperialUnitName.SHTOF to 1227.4443,
                    ImperialUnitName.CHARKA to 123.0,
                    ImperialUnitName.SOROKOVKA to 306.861075,
                    ImperialUnitName.LITER to 250.00054992433044,
                    ImperialUnitName.MILLILITER to 1.0,
                    ImperialUnitName.GALLON to 71.03265625,
                    ImperialUnitName.FLUID_ONCE to 28.47222222222222,
                    ImperialUnitName.PINT to 568.26125,
                    ImperialUnitName.QUART to 284.130625,
                    ImperialUnitName.BOCHKA to 4909.7772)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.GALLON, mapOf(
                    ImperialUnitName.GARNETS to 10.84,
                    ImperialUnitName.VEDRO to 2.71,
                    ImperialUnitName.OSMINA to 0.21600000000000003,
                    ImperialUnitName.SHKALIK to 542.0,
                    ImperialUnitName.SHTOF to 27.099999999999998,
                    ImperialUnitName.CHARKA to 691.2,
                    ImperialUnitName.SOROKOVKA to 4.32,
                    ImperialUnitName.LITER to 3.519515714637666,
                    ImperialUnitName.MILLILITER to 0.014078031891141618,
                    ImperialUnitName.GALLON to 1.0,
                    ImperialUnitName.FLUID_ONCE to 159.99999999999997,
                    ImperialUnitName.PINT to 8.0,
                    ImperialUnitName.QUART to 4.0,
                    ImperialUnitName.BOCHKA to 108.39999999999999)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.FLUID_ONCE, mapOf(
                    ImperialUnitName.GARNETS to 0.0432,
                    ImperialUnitName.VEDRO to 0.0108,
                    ImperialUnitName.OSMINA to 0.00135,
                    ImperialUnitName.SHKALIK to 2.16,
                    ImperialUnitName.SHTOF to 0.108,
                    ImperialUnitName.CHARKA to 4.33,
                    ImperialUnitName.SOROKOVKA to 0.027000000000000003,
                    ImperialUnitName.LITER to 0.08780487804878051,
                    ImperialUnitName.MILLILITER to 0.0351219512195122,
                    ImperialUnitName.GALLON to 0.003985239852398525,
                    ImperialUnitName.FLUID_ONCE to 1.0,
                    ImperialUnitName.PINT to 0.049999999999999996,
                    ImperialUnitName.QUART to 0.01246393537218696,
                    ImperialUnitName.BOCHKA to 0.432)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.PINT, mapOf(
                    ImperialUnitName.GARNETS to 0.8640000000000001,
                    ImperialUnitName.VEDRO to 0.21600000000000003,
                    ImperialUnitName.OSMINA to 0.027000000000000003,
                    ImperialUnitName.SHKALIK to 43.2,
                    ImperialUnitName.SHTOF to 2.16,
                    ImperialUnitName.CHARKA to 86.4,
                    ImperialUnitName.SOROKOVKA to 0.54,
                    ImperialUnitName.LITER to 0.43993946432970826,
                    ImperialUnitName.MILLILITER to 0.0017597539863927023,
                    ImperialUnitName.GALLON to 0.125,
                    ImperialUnitName.FLUID_ONCE to 19.999999999999996,
                    ImperialUnitName.PINT to 1.0,
                    ImperialUnitName.QUART to 0.5,
                    ImperialUnitName.BOCHKA to 8.64)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.QUART, mapOf(
                    ImperialUnitName.GARNETS to 3.466,
                    ImperialUnitName.VEDRO to 0.8665,
                    ImperialUnitName.OSMINA to 0.1083125,
                    ImperialUnitName.SHKALIK to 86.4,
                    ImperialUnitName.SHTOF to 4.32,
                    ImperialUnitName.CHARKA to 172.8,
                    ImperialUnitName.SOROKOVKA to 1.08,
                    ImperialUnitName.LITER to 0.8798789286594165,
                    ImperialUnitName.MILLILITER to 0.0035195079727854046,
                    ImperialUnitName.GALLON to 0.25,
                    ImperialUnitName.FLUID_ONCE to 39.99999999999999,
                    ImperialUnitName.PINT to 2.0,
                    ImperialUnitName.QUART to 1.0,
                    ImperialUnitName.BOCHKA to 17.28)),
            ImperialUnit(ImperialUnitType.VOLUME, ImperialUnitName.BOCHKA, mapOf(
                    ImperialUnitName.GARNETS to 0.1,
                    ImperialUnitName.VEDRO to 0.025,
                    ImperialUnitName.OSMINA to 0.003125,
                    ImperialUnitName.SHKALIK to 5.0,
                    ImperialUnitName.SHTOF to 0.25,
                    ImperialUnitName.CHARKA to 10.0,
                    ImperialUnitName.SOROKOVKA to 0.0625,
                    ImperialUnitName.LITER to 0.20325203252032523,
                    ImperialUnitName.MILLILITER to 0.08130081300813008,
                    ImperialUnitName.GALLON to 0.00922509225092251,
                    ImperialUnitName.FLUID_ONCE to 2.3148148148148144,
                    ImperialUnitName.PINT to 0.11574074074074073,
                    ImperialUnitName.QUART to 0.02885170225043278,
                    ImperialUnitName.BOCHKA to 1.0))
            )

    override val nameMap: Map<ImperialUnitName, ImperialUnit> = makeUnitByNameMap(units)
}
