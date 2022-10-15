package com.mobileprojectmanager.mpm;

import android.util.Log;

import java.io.Serializable;

public class Student implements Serializable {

    private String mName;
    private int mStudentID;


    public Student(String inputName, int inputID) {  // Default constructor
        mName = inputName;
        mStudentID = inputID;
    }


    public String getName() {
        return mName;
    }

    public void getInfo() {
       Log.d("MainActivity", "ID : " + mStudentID + " Nom : " + mName);
    }




}
