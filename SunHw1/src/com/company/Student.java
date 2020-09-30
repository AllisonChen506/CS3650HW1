package com.company;

import java.util.Random;

public class Student extends Choice{
    //every student has an id and an answer
    String studentID;
    Choice answer;

    //default constructor
    public Student() {
        this.studentID = null;
        this.answer = null;
    }
    //constructor with parameters
    public Student(String var1, Choice var2) {
        this.studentID = var1;
        this.answer = var2;
    }
    //id getter
    public String getID() {
        return this.studentID;
    }
    //answer getter
    public Choice getAns() {
        return this.answer;
    }
    //changing answer
    public Choice changeAns(Choice var1) {
        Choice var2 = this.answer;
        this.answer = var1;
        return var2;
    }
    //keeping track of number of answers
    public void increment() {
        this.answer.add();
    }

    public void decrement() {
        this.answer.subtract();
    }


}
