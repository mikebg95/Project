package com.example.mike.eattrainreap;

import java.io.Serializable;

public class WorkoutExercise2 implements Serializable {

    // private variables for this class
    private Exercise exercise;
    private int set1;
    private int set2;
    private int set3;
    private int rest;

    public WorkoutExercise2(Exercise exercise, int set1, int set2, int set3, int rest) {
        this.exercise = exercise;
        this.set1 = set1;
        this.set2 = set2;
        this.set3 = set3;
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
    public int getRest() {
        return rest;
    }
}
