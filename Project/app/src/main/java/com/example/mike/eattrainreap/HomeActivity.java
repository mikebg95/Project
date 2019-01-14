package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {

    Button myWorkouts;
    Button goalsProgress;
    Button exercises;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myWorkouts = findViewById(R.id.myWorkouts);
        goalsProgress = findViewById(R.id.goalsProgress);
        exercises = findViewById(R.id.exercises);

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
