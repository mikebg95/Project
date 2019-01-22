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

    Workout workout;

    int pos;

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

        // get clicked position and workout from intent
        Intent intent = getIntent();
        pos = intent.getIntExtra("position", 0);
        workout = MyWorkoutsActivity.workouts.get(pos);

        // get list of exercises for that workout (NOT WORKING -> exercisesRetrieved is null!)
//        MyWorkoutsActivity.workoutExercises.addAll(workout.getWorkoutExercises());

//        Toast.makeText(getApplicationContext(), MyWorkoutsActivity.workouts.get(0).getMuscleGroups(), Toast.LENGTH_SHORT).show();

//        MyWorkoutsActivity.workoutExercises = MyWorkoutsActivity.workouts.get(pos).getWorkoutExercises();
//                workout.getWorkoutExercises();

        // test to see if exercises are retrieved
//        if (exercisesRetrieved == null) {
//            Toast.makeText(getApplicationContext(), "exercisesRetrieved is null", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(getApplicationContext(), "exercisesRetrieved is not null", Toast.LENGTH_SHORT).show();
//            Toast.makeText(getApplicationContext(), Integer.toString(exercisesRetrieved.size()), Toast.LENGTH_SHORT).show();
//        }

        //  set editviews to correct information
        changeMuscle.setText(workout.getMuscleGroups());
        changeDay.setText(workout.getWorkoutDay());
        changeComment.setText(workout.getComment());

        // set listview to list of exercises via adapter
        final WorkoutExerciseAdapter adapter = new WorkoutExerciseAdapter(this, R.layout.workout_exercise_row_editable, MyWorkoutsActivity.workoutExercises);
        changeExercises.setAdapter(adapter);

        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create new workout exercise object with default values
                WorkoutExercise2 newEx = new WorkoutExercise2(null, 0, 0, 0, 0);

                // add to arraylist of exercises for that workout and notify adapter
                MyWorkoutsActivity.workoutExercises.add(newEx);
                adapter.notifyDataSetChanged();

                // TODO: make added row in listview Editable
                // returns (correct) position of added exercise
                int position = adapter.getPosition(newEx) - changeExercises.getFirstVisiblePosition();
                Log.d("position", Integer.toString(position));

//                makeEditable(position);

            }
        });

        saveChanges.setOnClickListener(new View.OnClickListener() {
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

                // set edited workout exercises
                MyWorkoutsActivity.workouts.get(pos).setWorkoutExercises(MyWorkoutsActivity.workoutExercises);

                // get and set current date
                String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                MyWorkoutsActivity.workouts.get(pos).setTimestamp(date);

                // clear arraylist of workoutexercises
                MyWorkoutsActivity.workoutExercises.clear();

                Intent intent = new Intent(EditWorkoutActivity.this, WorkoutScheduleActivity.class);
                startActivity(intent);


            }
        });


    }
}
