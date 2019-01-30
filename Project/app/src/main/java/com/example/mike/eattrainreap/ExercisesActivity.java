package com.example.mike.eattrainreap;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExercisesActivity extends AppCompatActivity {

    // variable for intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        // link variables to buttons
        Button findExercise = findViewById(R.id.findExercise);
        Button savedExercises = findViewById(R.id.savedExercises);

        // when clicked on certain button, go to corresponding activity
        findExercise.setOnClickListener(new OnFindClicked());
        savedExercises.setOnClickListener(new OnSavedClicked());
    }

    public class OnFindClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent = new Intent(ExercisesActivity.this, FindExerciseActivity.class);
            startActivity(intent);
        }
    }

    public class OnSavedClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent = new Intent(ExercisesActivity.this, SavedExercisesActivity.class);
            startActivity(intent);
        }
    }
}
