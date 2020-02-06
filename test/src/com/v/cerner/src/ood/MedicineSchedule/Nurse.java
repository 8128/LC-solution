package ood.MedicineSchedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Nurse {
    private List<Patient> patients;
    private List<Medication> medications;

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public void scheduler(Medication medication,Patient patient) {
        if (patient.getAge() < 3) {
            patient = new Baby();
            String birthtime = ((Baby) patient).getBirth();
            Date startDate = medication.getStart();
            List<String> times = new ArrayList<>();
            if (medication.getEnd() != null) {
                Date endDate = medication.getEnd();
                int freq = medication.getFreq();

                for (int i = 0; i < 100; i++) {
                    int time = 6;
                    for (int k = 0; k < freq; k++) {
                        time += 14 / k;
                        times.add(String.valueOf(time));
                    }
                }
            }
            System.out.println(times);
        }
    }
}
