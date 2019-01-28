package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MyWorkoutsActivity extends AppCompatActivity {

    // static arraylists to store workoutExercises and Workouts
    public static ArrayList<WorkoutExercise2> workoutExercises = new ArrayList<>();
    public static ArrayList<Workout> workouts = new ArrayList<>();

    // variables for buttons
    Button workoutSchedule;
    Button newWorkout;

    // variable for intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_workouts);

        // link variables to correct buttons
        newWorkout = findViewById(R.id.new_workout);
        workoutSchedule = findViewById(R.id.schedule);

        // when clicked on button, go to corresponding activity via intent
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
    }

    public void onBackPressed() {
        Intent intent = new Intent(MyWorkoutsActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
