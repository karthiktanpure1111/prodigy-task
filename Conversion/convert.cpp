#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

// Function to convert from Celsius
void convertFromCelsius(double temp) {
    double fahrenheit = (temp * 9.0 / 5.0) + 32;
    double kelvin = temp + 273.15;

    cout << fixed << setprecision(2);
    cout << "Fahrenheit: " << fahrenheit << " °F" << endl;
    cout << "Kelvin: " << kelvin << " K" << endl;
}

// Function to convert from Fahrenheit
void convertFromFahrenheit(double temp) {
    double celsius = (temp - 32) * 5.0 / 9.0;
    double kelvin = celsius + 273.15;

    cout << fixed << setprecision(2);
    cout << "Celsius: " << celsius << " °C" << endl;
    cout << "Kelvin: " << kelvin << " K" << endl;
}

// Function to convert from Kelvin
void convertFromKelvin(double temp) {
    double celsius = temp - 273.15;
    double fahrenheit = (celsius * 9.0 / 5.0) + 32;

    cout << fixed << setprecision(2);
    cout << "Celsius: " << celsius << " °C" << endl;
    cout << "Fahrenheit: " << fahrenheit << " °F" << endl;
}

int main() {
    double temperature;
    string unit;

    cout << "Enter the temperature value: ";
    cin >> temperature;

    cout << "Enter the unit (Celsius, Fahrenheit, Kelvin): ";
    cin >> unit;

    // Convert input to lowercase (manual since C++ has no direct tolower for strings)
    for (auto &c : unit) c = tolower(c);

    cout << "\nConverted Temperatures:\n";

    if (unit == "celsius") {
        convertFromCelsius(temperature);
    } else if (unit == "fahrenheit") {
        convertFromFahrenheit(temperature);
    } else if (unit == "kelvin") {
        convertFromKelvin(temperature);
    } else {
        cout << "Invalid unit entered." << endl;
    }

    return 0;
}
