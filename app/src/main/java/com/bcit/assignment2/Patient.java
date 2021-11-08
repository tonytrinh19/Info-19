package com.bcit.assignment2;

// Ended up not needing to parse data, might remove later.

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
