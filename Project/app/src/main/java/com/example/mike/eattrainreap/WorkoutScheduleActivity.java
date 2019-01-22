package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class WorkoutScheduleActivity extends AppCompatActivity {

    ListView schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_schedule);

        schedule = findViewById(R.id.schedule);

        WorkoutAdapter wAdapter = new WorkoutAdapter(this, R.layout.workout_row, MyWorkoutsActivity.workouts);
        schedule.setAdapter(wAdapter);


//        schedule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // go to that specific workout
//            }
//        });
    }
}
