package com.example.exotica;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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