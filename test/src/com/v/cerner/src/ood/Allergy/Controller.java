package ood.Allergy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Controller {
    static final int age = 18;

    List<Patient> patients = new ArrayList<>();

    public void getMostCommonSymptons(List<Patient> patients) {
        HashMap<Symptoms, Integer> map = new HashMap<>();
        for (Patient patient : patients) {
            if (patient.getAge() == age) {
                Symptoms s = patient.getAllergy().getSymptoms();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
    }
}
