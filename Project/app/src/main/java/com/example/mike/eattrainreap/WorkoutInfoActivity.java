package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_info);

        // link variables to views
        TextView muscle = findViewById(R.id.muscle_info);
        TextView day = findViewById(R.id.day_info);
        ListView exercises = findViewById(R.id.exercises_info);
        TextView comment = findViewById(R.id.comment_info);
        TextView date = findViewById(R.id.date_info);

        // get workout position from intent and retrieve corresponding workout
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 300);
        Workout workout = MyWorkoutsActivity.workouts.get(position);

        // get needed values from workout
        String muscleString = workout.getMuscleGroups();
        String dayString = workout.getWorkoutDay();
        String commentString = workout.getComment();
        String dateString = workout.getTimestamp();
        ArrayList<WorkoutExercise2> workoutExercises = workout.getWorkoutExercises();

        // fill in values in views
        muscle.setText(muscleString);
        day.setText(dayString);
        comment.setText(commentString);
        date.setText(dateString);

        // link listview to workout exercises via adapter
        WorkoutExerciseAdapter adapter = new WorkoutExerciseAdapter(this, R.layout.workout_exercise_row_editable, workoutExercises);
        exercises.setAdapter(adapter);

    }
}
