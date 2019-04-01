package Main.abstracts;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public interface HeatScalable {
    // #0.## allows for formatting of two decimal places and no more
    NumberFormat formatter = new DecimalFormat("#0.##");
    // Constant values for annotation implementation and to make conversions
    //  to and from Main.concretes.Kelvin easier to read, since C = K - 273.15
    double CONVERSION_MAXIMUM = 10000;
    double CELSIUS_MINIMUM = -273.15;
    double FAHRENHEIT_MINIMUM = -459.67;
    double KELVIN_MINIMUM = 0;
    double KELVIN_CONST = 273.15;

    double toCelsius();

    double toFahrenheit();

    double toKelvin();
}