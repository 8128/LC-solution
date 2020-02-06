package ood.Temperature;

import java.util.Date;
import java.util.Map;

public class Patient {
    private String name;
    private int age;
    private Map<Date,Temperature> temperatureMap;
    private Temperature temperature;
    private Date lastSeen;

    public Patient(Temperature temperature, Date lastSeen) {
        this.temperature = temperature;
        this.lastSeen = lastSeen;
        temperatureMap.put(lastSeen,temperature);
    }

    public boolean isFever() {
        for (Temperature temperature : temperatureMap.values()) {
            if (temperature.getLocation()== Body.Mouth && temperature.getTemperatureInCelcius() > 38) {
                return true;
            }
        }
        return false;
    }


}
