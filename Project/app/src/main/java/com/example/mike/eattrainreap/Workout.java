package com.example.mike.eattrainreap;

import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable {

    // variable for this class
    private ArrayList<WorkoutExercise2> workoutExercises;
    private String workoutDay;
    private String muscleGroups;
    private String comment;
    private String timestamp;

    // constructor for this class
    public Workout(ArrayList<WorkoutExercise2> workoutExercises, String workoutDay, String muscleGroups, String comment, String timestamp) {
        this.workoutExercises = workoutExercises;
        this.workoutDay = workoutDay;
        this.muscleGroups = muscleGroups;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    // getters for this class
    public ArrayList<WorkoutExercise2> getWorkoutExercises() {
        return workoutExercises;
    }
    public String getWorkoutDay() {
        return workoutDay;
    }
    public String getMuscleGroups() {
        return muscleGroups;
    }
    public String getComment() {
        return comment;
    }
    public String getTimestamp() {
        return timestamp;
    }

    public void setWorkoutExercises(ArrayList<WorkoutExercise2> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }
    public void setWorkoutDay(String workoutDay) {
        this.workoutDay = workoutDay;
    }
    public void setMuscleGroups(String muscleGroups) {
        this.muscleGroups = muscleGroups;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
