package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MyWorkoutsActivity extends AppCompatActivity {

    public static ArrayList<WorkoutExercise2> workoutExercises = new ArrayList<>();

    public static ArrayList<Workout> workouts = new ArrayList<>();

    Button workoutSchedule;
    Button previousWorkouts;
    Button newWorkout;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_workouts);

        newWorkout = findViewById(R.id.new_workout);
        workoutSchedule = findViewById(R.id.schedule);
        previousWorkouts = findViewById(R.id.previous);

        newWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MyWorkoutsActivity.this, NewWorkoutActivity.class);
                startActivity(intent);
            }
        });

        workoutSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MyWorkoutsActivity.this, WorkoutScheduleActivity.class);
                startActivity(intent);
            }
        });

        previousWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MyWorkoutsActivity.this, PreviousWorkoutsActivity.class);
                startActivity(intent);
            }
        });
    }
}
