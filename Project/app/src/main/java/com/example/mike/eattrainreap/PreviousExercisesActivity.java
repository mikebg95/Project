package com.example.mike.eattrainreap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PreviousExercisesActivity extends AppCompatActivity {

    ListView previousExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_exercises);

        previousExercises = findViewById(R.id.previousExercises);

        previousExercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // go to that specific exercise
            }
        });
    }
}
