package com.example.mike.eattrainreap;

import java.util.ArrayList;

public class Workout {

    // variable for this class
    private ArrayList<WorkoutExercise2> workoutExercises;
    private String workoutDate;
    private String muscleGroups;

    // constructor for this class
    public Workout(ArrayList<WorkoutExercise2> workoutExercises, String workoutDate, String muscleGroups) {
        this.workoutExercises = workoutExercises;
        this.workoutDate = workoutDate;
        this.muscleGroups = muscleGroups;
    }

    // getters for this class
    public ArrayList<WorkoutExercise2> getWorkoutExercises() {
        return workoutExercises;
    }
    public String getWorkoutDate() {
        return workoutDate;
    }
    public String getMuscleGroups() {
        return muscleGroups;
    }
}
