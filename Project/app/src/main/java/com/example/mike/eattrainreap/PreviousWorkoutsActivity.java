package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PreviousWorkoutsActivity extends AppCompatActivity {

    ListView previousWorkouts;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_workouts);

        previousWorkouts = findViewById(R.id.previousList);

        previousWorkouts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // go to that specific workout

                intent = new Intent(PreviousWorkoutsActivity.this, WorkoutActivity.class);

                // add something to intent

                startActivity(intent);
            }
        });
    }
}
