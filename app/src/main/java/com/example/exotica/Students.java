package com.example.exotica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Students {
   private String studentId;
   private String studentName;
   private String studentRegno;
   private String studentBranch;
   private String studentYear;
   private String studentPhone;
   private String studentEmail;
   private String studentEvents;

   public Students(){

   }

    public Students(String studentId, String studentName, String studentRegno, String studentBranch, String studentYear,  String studentPhone, String studentEmail, String studentEvents) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentRegno = studentRegno;
        this.studentBranch = studentBranch;
        this.studentYear = studentYear;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
        this.studentEvents = studentEvents;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentRegno() {
        return studentRegno;
    }

    public String getStudentBranch() {
        return studentBranch;
    }

    public String getStudentYear() {
        return studentYear;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentEvents() {
        return studentEvents;
    }

}