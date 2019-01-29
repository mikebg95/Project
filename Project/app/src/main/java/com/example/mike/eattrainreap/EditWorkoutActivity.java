package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class EditWorkoutActivity extends AppCompatActivity {

    // variables for views and button
    EditText changeMuscle, changeDay;
    EditText changeComment;
    ListView changeExercises;
    Button saveChanges;
    Button addExercise;

    // variables for workout object and adapter
    Workout workout;
    WorkoutExerciseAdapter adapter;

    // variables related to onBackPressed()
    int pos;
    int backPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_workout);

        // link variables to views
        changeMuscle = findViewById(R.id.change_muscle);
        changeDay = findViewById(R.id.change_day);
        changeComment = findViewById(R.id.change_comment);
        changeExercises = findViewById(R.id.change_exercises);
        saveChanges = findViewById(R.id.save_changes);
        addExercise = findViewById(R.id.add_exercise);

        // get clicked position from intent and retrieve workout
        Intent intent = getIntent();
        pos = intent.getIntExtra("position", 0);
        workout = MyWorkoutsActivity.workouts.get(pos);

        //  set editviews to correct information
        changeMuscle.setText(workout.getMuscleGroups());
        changeDay.setText(workout.getWorkoutDay());
        changeComment.setText(workout.getComment());

        // set listview to list of exercises via adapter
        adapter = new WorkoutExerciseAdapter(this, R.layout.workout_exercise_row_editable, workout.getWorkoutExercises());
        changeExercises.setAdapter(adapter);

        // when clicked on "add exercise"
        addExercise.setOnClickListener(new AddExerciseClicked());

        // when clicked on "save changes"
        saveChanges.setOnClickListener(new SaveChangesClicked());
    }

    public class SaveChangesClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            // set edited muscle group
            String muscle = changeMuscle.getText().toString();
            MyWorkoutsActivity.workouts.get(pos).setMuscleGroups(muscle);

            // set edited workout day
            String day = changeDay.getText().toString();
            MyWorkoutsActivity.workouts.get(pos).setWorkoutDay(day);

            // set edited comment
            String comment = changeComment.getText().toString();
            MyWorkoutsActivity.workouts.get(pos).setComment(comment);


            // get and set current date
            String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
            MyWorkoutsActivity.workouts.get(pos).setTimestamp(date);

            // clear arraylist of workoutexercises
//                MyWorkoutsActivity.workoutExercises.clear();

            Intent intent = new Intent(EditWorkoutActivity.this, WorkoutScheduleActivity.class);
            intent.putExtra("pos", pos);
            startActivity(intent);
        }
    }

    public class AddExerciseClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // create new workout exercise object with default values
            WorkoutExercise2 newEx = new WorkoutExercise2(null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            // add to arraylist of exercises for that workout and notify adapter
            MyWorkoutsActivity.workouts.get(pos).getWorkoutExercises().add(newEx);
            adapter.notifyDataSetChanged();
        }
    }

    public void onBackPressed() {
        // go back to home screen
        backPress += 1;


        if (backPress>1) {
            Intent intent = new Intent(EditWorkoutActivity.this, WorkoutScheduleActivity.class);
            startActivity(intent);
        }

        Toast.makeText(getApplicationContext(), " Press Back again to Exit (changes won't be saved!) ", Toast.LENGTH_SHORT).show();
    }
}
