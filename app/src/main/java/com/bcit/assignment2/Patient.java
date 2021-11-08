package com.bcit.assignment2;

public class Patient {
    String ageGroup;
    String classificationReported;
    String healthAuthority;
    String reportedDate;
    String sex;

    public Patient(String ageGroup, String classificationReported, String healthAuthority, String reportedDate, String sex) {
        this.ageGroup = ageGroup;
        this.classificationReported = classificationReported;
        this.healthAuthority = healthAuthority;
        this.reportedDate = reportedDate;
        this.sex = sex;
    }
}
