package ood.MedicineSchedule;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Baby extends Patient {
    private String continent;
    private String city;

    public Baby() {}

    public Baby(String name, int age, Date birthDay, String continent, String city) {
        super(name, age, birthDay);
        this.continent = continent;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return convertoTimeZone(continent, city);
    }

    public void setBirth(Date birth) {
        this.birthDay = birth;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthInOtherTimeZone(String continent, String city) {
        return convertoTimeZone(continent, city);
    }

    public String convertoTimeZone(String continent, String city){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.birthDay);

        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");

        formatter.setCalendar(calendar);
        formatter.setTimeZone(TimeZone.getTimeZone(continent + "/" + city ));

        return formatter.format(calendar.getTime());
    }

}
