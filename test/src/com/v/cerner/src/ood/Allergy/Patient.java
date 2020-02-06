package ood.Allergy;

public class Patient {
    private String name;
    private int age;
    private Allergy allergy;

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

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    public Patient(String name, int age, Allergy allergy) {
        this.name = name;
        this.age = age;
        this.allergy = allergy;
    }




}
