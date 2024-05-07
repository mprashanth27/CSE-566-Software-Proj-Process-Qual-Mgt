public class TemperatureConverter {
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public static void main(String[] args) {
        // Example usage
        double celsius = 25.0;
        double fahrenheit = convertCelsiusToFahrenheit(celsius);
        System.out.println(celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit.");

        double originalFahrenheit = 77.0;
        double convertedCelsius = convertFahrenheitToCelsius(originalFahrenheit);
        System.out.println(originalFahrenheit + " degrees Fahrenheit is equal to " + convertedCelsius + " degrees Celsius.");
    }
}
