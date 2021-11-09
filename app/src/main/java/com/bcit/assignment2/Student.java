package com.bcit.assignment2;

public class Student {

    String studentId;

    String studentFirstName;

    String studentLastName;

    String school;


    public Student() {}


    public Student(String studentId, String studentFirstName,

                   String studentLastName, String school) {

        this.studentId = studentId;

        this.studentFirstName = studentFirstName;

        this.studentLastName = studentLastName;

        this.school = school;

    }


    public String getStudentId() { return studentId; }


    public void setStudentId(String studentId) {

        this.studentId = studentId;

    }


    public String getStudentFirstName() {return studentFirstName;}


    public void setStudentFirstName(String studentFirstName) {

        this.studentFirstName = studentFirstName;

    }


    public String getStudentLastName() {return studentLastName;}


    public void setStudentLastName(String studentLastName) {

        this.studentLastName = studentLastName;

    }


    public String getSchool() {return school;}


    public void setSchool(String school) {

        this.school = school;

    }

}
