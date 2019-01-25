package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    // arraylist to store favorite/saved exercises (can be accessed from multiple activities)
    public static ArrayList<Exercise> favoriteExercises = new ArrayList<>();

    // variable for intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // link variables to buttons
        Button myWorkouts = findViewById(R.id.myWorkouts);
        Button goalsProgress = findViewById(R.id.goalsProgress);
        Button exercises = findViewById(R.id.exercises_info);

        // when clicked on button, go to corresponding activity (via intent)
        myWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, MyWorkoutsActivity.class);
                startActivity(intent);
            }
        });

        goalsProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, GoalsProgressActivity.class);
                startActivity(intent);
            }
        });

        exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, ExercisesActivity.class);
                startActivity(intent);
            }
        });
    }
}
