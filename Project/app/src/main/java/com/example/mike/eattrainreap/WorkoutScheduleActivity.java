package com.example.mike.eattrainreap;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WorkoutScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_schedule);

        // link variable to listview
        ListView schedule = findViewById(R.id.schedule);

        // link listview to workouts via adapter
        WorkoutAdapter wAdapter = new WorkoutAdapter(this, R.layout.workout_row,
                                                        MyWorkoutsActivity.workouts);
        schedule.setAdapter(wAdapter);
    }

    public void onBackPressed() {
        // go back to home screen
        Intent intent = new Intent(WorkoutScheduleActivity.this, MyWorkoutsActivity.class);
        startActivity(intent);
    }

}
