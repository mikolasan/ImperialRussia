package io.github.mikolasan.ratiogenerator

object MinLengthUnits : ImperialUnitCategory(
    type = ImperialUnitType.LENGTH,
    ratioList = listOf(
        eq(x(1.0, ImperialUnitName.ARSHIN), x(28.0, ImperialUnitName.INCH)),
        eq(x(1.0, ImperialUnitName.ARSHIN), x(16.0, ImperialUnitName.VERSHOK)),
        eq(x(1.0, ImperialUnitName.ARSHIN), x(4.0, ImperialUnitName.SPAN)),
        eq(x(1.0, ImperialUnitName.SAZHEN), x(3.0, ImperialUnitName.ARSHIN)),
        eq(x(1.0, ImperialUnitName.SAZHEN), x(7.0, ImperialUnitName.FOOT)),
        eq(x(1.0, ImperialUnitName.SAZHEN), x(12.0, ImperialUnitName.SPAN)),
        eq(x(1.0, ImperialUnitName.SAZHEN), x(48.0, ImperialUnitName.VERSHOK)),
        eq(x(1.0, ImperialUnitName.SAZHEN), x(84.0, ImperialUnitName.INCH)),
        eq(x(1.0, ImperialUnitName.SPAN), x(4.0, ImperialUnitName.VERSHOK)),
        eq(x(1.0, ImperialUnitName.SPAN), x(7.0, ImperialUnitName.INCH)),
        eq(x(1.0, ImperialUnitName.INCH), x(2.54, ImperialUnitName.CENTIMETER)),
        eq(x(1.0, ImperialUnitName.INCH), x(10.0, ImperialUnitName.LINE)),
        eq(x(1.0, ImperialUnitName.INCH), x(100.0, ImperialUnitName.POINT)),
        eq(x(1.0, ImperialUnitName.FOOT), x(12.0, ImperialUnitName.INCH)),
        eq(x(7.0, ImperialUnitName.FOOT), x(3.0, ImperialUnitName.ARSHIN)),
        eq(x(1.0, ImperialUnitName.ELL), x(2.0, ImperialUnitName.SPAN)),
        eq(x(3.0, ImperialUnitName.ELL), x(2.0, ImperialUnitName.ARSHIN)),
        eq(x(1.0, ImperialUnitName.ELL), x(6.0, ImperialUnitName.PALM)),
        eq(x(1.0, ImperialUnitName.ELL), x(8.0, ImperialUnitName.VERSHOK)),
        eq(x(1.0, ImperialUnitName.MILE), x(7.0, ImperialUnitName.VERST)),
        eq(x(1.0, ImperialUnitName.METER), x(10.0, ImperialUnitName.DECIMETER)),
        eq(x(1.0, ImperialUnitName.METER), x(100.0, ImperialUnitName.CENTIMETER)),
        eq(x(1.0, ImperialUnitName.METER), x(1000.0, ImperialUnitName.MILLIMETER)),
        eq(x(1.0, ImperialUnitName.METER), x(1000000.0, ImperialUnitName.MICROMETER)),
        eq(x(1.0, ImperialUnitName.KILOMETER), x(1000.0, ImperialUnitName.METER)),
        eq(x(1.0, ImperialUnitName.VERST), x(500.0, ImperialUnitName.SAZHEN)),
        eq(x(1.0, ImperialUnitName.POPRISCHE), x(20.0, ImperialUnitName.VERST)),
        eq(x(1.0, ImperialUnitName.VERST), x(1.0668, ImperialUnitName.KILOMETER)),
    ),
    formulaList = listOf())
