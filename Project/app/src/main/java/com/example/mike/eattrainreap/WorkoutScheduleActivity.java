package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class WorkoutScheduleActivity extends AppCompatActivity {

    int backPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_schedule);

        // link variable to listview
        ListView schedule = findViewById(R.id.schedule);

        // link listview to workouts via adapter
        WorkoutAdapter wAdapter = new WorkoutAdapter(this, R.layout.workout_row, MyWorkoutsActivity.workouts);
        schedule.setAdapter(wAdapter);


//        schedule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // go to that specific workout
//            }
//        });
    }

    public void onBackPressed() {
        // go back to home screen
        Intent intent = new Intent(WorkoutScheduleActivity.this, MyWorkoutsActivity.class);
        startActivity(intent);
    }

}
