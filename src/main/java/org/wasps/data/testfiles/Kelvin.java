package Main.concretes;

import Annotations.Conversion;
import Annotations.Invariant;
import Main.abstracts.HeatScalable;
import Utilities.Helpers;

public class Kelvin implements HeatScalable {
    private double temperature;

    public Kelvin(double temperature) {
        this.temperature = temperature;
    }

    @Override
    @Conversion(min = CELSIUS_MINIMUM, max = CONVERSION_MAXIMUM)
    public double toCelsius() {
        return Helpers.roundDouble(temperature - KELVIN_CONST);
    }

    @Override
    @Conversion(min = FAHRENHEIT_MINIMUM, max = CONVERSION_MAXIMUM)
    public double toFahrenheit() {
        return Helpers.roundDouble((temperature - KELVIN_CONST) * 9 / 5 + 32);
    }

    @Override
    @Invariant
    public double toKelvin() {
        return temperature;
    }

    @Override
    @Invariant
    public String toString() {
        return formatter.format(temperature) + 'K';
    }
}
