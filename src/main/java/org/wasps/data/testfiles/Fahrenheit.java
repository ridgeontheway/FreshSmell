package Main.concretes;

import Annotations.Conversion;
import Annotations.Invariant;
import Main.abstracts.HeatScalable;
import Utilities.Helpers;

public class Fahrenheit implements HeatScalable {
    private double temperature;

    public Fahrenheit(double temperature) {
        this.temperature = temperature;
    }

    @Override
    @Conversion(min = CELSIUS_MINIMUM, max = CONVERSION_MAXIMUM)
    public double toCelsius() {
        return Helpers.roundDouble((temperature - 32) * 5 / 9);
    }

    @Override
    @Invariant
    public double toFahrenheit() {
        return temperature;
    }

    @Override
    @Conversion(min = KELVIN_MINIMUM, max = CONVERSION_MAXIMUM)
    public double toKelvin() {
        return Helpers.roundDouble(toCelsius() + KELVIN_CONST);
    }

    @Override
    @Invariant
    public String toString() {
        return formatter.format(temperature) + 'F';
    }
}
