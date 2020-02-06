package ood.Temperature;

public class Temperature {
    private double temperature;
    private Body location;
    private Unit unit;


    public void setTemperatureByCelcius(double temperature, Unit unit) {
        this.unit = unit;
        this.temperature = temperature;
    }


    public Body getLocation() {
        return location;
    }

    public void setLocation(Body location) {
        this.location = location;
    }



    public Temperature(float temperature, Body location) {
        this.temperature = temperature;
        this.location = location;
    }



    public double getTemperatureInFahrenheit() {
        if (this.unit == Unit.celcius)
            return (temperature - 32) * (5/9.0);
        else
            return this.temperature;
    }

    public double getTemperatureInCelcius() {
        if (this.unit == Unit.celcius)
            return temperature;
        else
            return temperature * (9/5.0) + 32;
    }

}
