package ood.MedicineSchedule;

import java.util.Date;

public abstract class Patient {
    protected String name;
    protected int age;
    protected Date birthDay;

    public Patient() { }

    public Patient(String name, int age, Date birthDay) {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
    }

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




}
