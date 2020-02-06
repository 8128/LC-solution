package ood.Allergy;

public class Allergy {
    private String reporter;
    private Symptoms symptoms;
    private int timeReported;
    private Severity severity;

    public Allergy(String reporter, Symptoms symptoms, int timeReported, Severity severity) {
        this.reporter = reporter;
        this.symptoms = symptoms;
        this.timeReported = timeReported;
        this.severity = severity;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symptoms symptoms) {
        this.symptoms = symptoms;
    }

    public int getTimeReported() {
        return timeReported;
    }

    public void setTimeReported(int timeReported) {
        this.timeReported = timeReported;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

}
