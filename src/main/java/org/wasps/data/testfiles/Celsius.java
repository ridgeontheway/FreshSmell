package Main.concretes;

import Annotations.Conversion;
import Annotations.Invariant;
import Main.abstracts.HeatScalable;
import Utilities.Helpers;

public class Celsius implements HeatScalable {
    private double temperature;

    public Celsius(double temperature) {
        this.temperature = temperature;
    }

    @Override
    @Invariant
    public double toCelsius() {
        return temperature;
    }

    @Override
    @Conversion(min = FAHRENHEIT_MINIMUM, max = CONVERSION_MAXIMUM)
    public double toFahrenheit() {
        return Helpers.roundDouble((temperature * 9 / 5 + 32));
    }

    @Override
    @Conversion(min = KELVIN_MINIMUM, max = CONVERSION_MAXIMUM)
    public double toKelvin() {
        return Helpers.roundDouble(temperature + KELVIN_CONST);
    }

    @Override
    @Invariant
    public String toString() {
        return formatter.format(temperature) + 'C';
    }
}
