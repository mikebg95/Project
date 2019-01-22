package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class WorkoutInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_info);

        TextView muscle = findViewById(R.id.muscle_info);
        TextView day = findViewById(R.id.day_info);
        ListView exercises = findViewById(R.id.exercises_info);
        TextView comment = findViewById(R.id.comment_info);
        TextView date = findViewById(R.id.date_info);

        // get workout object from intent
        Intent intent = getIntent();
        Workout workout = (Workout) intent.getSerializableExtra("workoutClicked");

        // get needed values from workout
        String muscleString = workout.getMuscleGroups();
        String dayString = workout.getWorkoutDay();
        String commentString = workout.getComment();
        String dateString = workout.getTimestamp();

        // fill in values in views
        muscle.setText(muscleString);
        day.setText(dayString);
        comment.setText(commentString);
        date.setText(dateString);

    }
}
