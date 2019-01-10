package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyWorkoutsActivity extends AppCompatActivity {

    Button workoutSchedule;
    Button previousWorkouts;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_workouts);

        workoutSchedule = findViewById(R.id.schedule);
        previousWorkouts = findViewById(R.id.previous);

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
