package com.example.mike.eattrainreap;

import java.io.Serializable;
import java.util.ArrayList;

public class WorkoutExercise implements Serializable {

    // private variables for this class
    private Exercise exercise;
    private int setAmount;
    private ArrayList<Integer> repAmounts;
    private int rest;

    // constructor for this class
    public WorkoutExercise(Exercise exercise, int setAmount, ArrayList<Integer> repAmounts, int rest) {
        this.exercise = exercise;
        this.setAmount = setAmount;
        this.repAmounts = repAmounts;
        this.rest = rest;
    }

    // getters for this class
    public Exercise getExercise() {
        return exercise;
    }
    public int getSetAmount() {
        return setAmount;
    }
    public ArrayList<Integer> getRepAmounts() {
        return repAmounts;
    }
    public int getRest() {
        return rest;
    }
}
