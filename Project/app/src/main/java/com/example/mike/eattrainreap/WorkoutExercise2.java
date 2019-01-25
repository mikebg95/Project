package com.example.mike.eattrainreap;

import java.io.Serializable;

public class WorkoutExercise2 implements Serializable {

    // private variables for this class
    private Exercise exercise;
    private int set1;
    private int set2;
    private int set3;
    private int set4;
    private int set5;
    private int rest;

    public WorkoutExercise2(Exercise exercise, int set1, int set2, int set3, int set4, int set5, int rest) {
        this.exercise = exercise;
        this.set1 = set1;
        this.set2 = set2;
        this.set3 = set3;
        this.set4 = set4;
        this.set5 = set5;
        this.rest = rest;
    }

    // getters for this class
    public Exercise getExercise() {
        return exercise;
    }
    public int getSet1() {
        return set1;
    }
    public int getSet2() {
        return set2;
    }
    public int getSet3() {
        return set3;
    }
    public int getSet4() {
        return set4;
    }
    public int getSet5() {
        return set5;
    }
    public int getRest() {
        return rest;
    }

    // setters for this workout
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    public void setSet1(int set1) {
        this.set1 = set1;
    }
    public void setSet2(int set2) {
        this.set2 = set2;
    }
    public void setSet3(int set3) {
        this.set3 = set3;
    }
    public void setSet4(int set4) {
        this.set4 = set4;
    }
    public void setSet5(int set5) {
        this.set5 = set5;
    }
    public void setRest(int rest) {
        this.rest = rest;
    }
}
