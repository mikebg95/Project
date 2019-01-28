package com.example.mike.eattrainreap;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class NewWorkoutActivity extends AppCompatActivity {

    // variables for buttons and views
    Button newExercise;
    ListView workoutExercisesView;
    Button saveWorkout;
    EditText workoutDay;
    EditText workoutMuscles;

    public static String muscle = "";
    public static String day = "";

    // variables for this activity
    Exercise exerciseFound;
    int position;
    int backPress;

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        String muscleValue = workoutMuscles.getText().toString();
//        workoutMuscles.setText(muscleValue);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        // link variables to buttons and views
        newExercise = findViewById(R.id.new_exercise);
        workoutExercisesView = findViewById(R.id.workout_exercises);
        saveWorkout = findViewById(R.id.save_workout);
        workoutDay = findViewById(R.id.day_info);
        workoutMuscles = findViewById(R.id.workout_muscles);

        // link workout exercises to listview via adapter
        final WorkoutExerciseAdapter weAdapter = new WorkoutExerciseAdapter(this, R.layout.workout_exercise_row_editable, MyWorkoutsActivity.workoutExercises);
        workoutExercisesView.setAdapter(weAdapter);

        backPress = 0;

        // set day and muscle to corresponding values
        workoutDay.setText(day);
        workoutMuscles.setText(muscle);

        // get intent
        Intent intent = getIntent();

        // when returning from finding an exercise for workout exercise
        if (intent.getSerializableExtra("exercise") != null) {
            exerciseFound = (Exercise) intent.getSerializableExtra("exercise");
            position = intent.getIntExtra("position", 300);

            // add found exercise to workout exercise and notify adapter
            MyWorkoutsActivity.workoutExercises.get(position).setExercise(exerciseFound);
            weAdapter.notifyDataSetChanged();
        }

        // when clicked on "new exercise"
        newExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // create new workout exercise object with default values
                WorkoutExercise2 newEx = new WorkoutExercise2(null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

                // add to arraylist of exercises for that workout and notify adapter
                MyWorkoutsActivity.workoutExercises.add(newEx);
                weAdapter.notifyDataSetChanged();
            }
        });

        workoutMuscles.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                muscle = s.toString();
            }
        });

        workoutDay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                day = s.toString();
            }
        });

        // when clicked on "save workout"
        saveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // make sure user filled these in
                if (muscle.equals("") && day.equals("")) {
                    Toast.makeText(getApplicationContext(), "please fill in muscle group and workout day", Toast.LENGTH_SHORT).show();
                }
                else if (muscle.equals("")) {
                    Toast.makeText(getApplicationContext(), "please fill in muscle group", Toast.LENGTH_SHORT).show();
                }
                else if (day.equals("")) {
                    Toast.makeText(getApplicationContext(), "please fill in workout day", Toast.LENGTH_SHORT).show();
                }

                // when all obligatory info is filled in
                else {

                    // get date
                    String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

                    // save workout exercises to "dummy" arraylist
                    ArrayList<WorkoutExercise2> workoutExercises = new ArrayList<>();
                    workoutExercises.addAll(MyWorkoutsActivity.workoutExercises);

                    // create new workout and add to workouts
                    Workout newWorkout = new Workout(workoutExercises, day, muscle, "", "added/edited " + date);

                    // clear workout exercises and day and muscle edittext's
                    day = "";
                    muscle = "";
                    MyWorkoutsActivity.workoutExercises.clear();

                    // send workout position as intent to CommentActivity
                    Intent intent = new Intent(NewWorkoutActivity.this, CommentActivity.class);
                    intent.putExtra("newWorkout", newWorkout);
                    startActivity(intent);
                }
            }
        });


    }

    // TODO: make function work correctly!!!
    // takes position of row as argument and makes that row editable
    public void makeEditable(int position) {

        // gets listview row for that workout exercise -> DOESNT WORK (returns null!)
        View row = workoutExercisesView.getChildAt(position);

        if (row == null) {
            Toast.makeText(getApplicationContext(), "row is null", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "row is null", Toast.LENGTH_SHORT).show();
        }

//        // variables to refer to switchers and button in that row
//        ViewSwitcher vsName = row.findViewById(R.id.switcher_name);
//        ViewSwitcher vs1 = row.findViewById(R.id.switcher_1);
//        ViewSwitcher vs2 = row.findViewById(R.id.switcher_2);
//        ViewSwitcher vs3 = row.findViewById(R.id.switcher_3);
//        ViewSwitcher vsRest = row.findViewById(R.id.switcher_rest);
//        Button addEx = row.findViewById(R.id.add);
//
//        // switch to editable views and make add button visible
//        vsName.setDisplayedChild(0);
//        vs1.setDisplayedChild(0);
//        vs2.setDisplayedChild(0);
//        vs3.setDisplayedChild(0);
//        vsRest.setDisplayedChild(0);
//        addEx.setVisibility(View.VISIBLE);

    }

    public void onBackPressed() {
        // go back to home screen
        backPress += 1;


        if (backPress>1) {
            muscle = "";
            day = "";
            MyWorkoutsActivity.workoutExercises.clear();

            Intent intent = new Intent(NewWorkoutActivity.this, MyWorkoutsActivity.class);
            startActivity(intent);
        }

        Toast.makeText(getApplicationContext(), " Press Back again to Exit (this workout won't be saved!) ", Toast.LENGTH_SHORT).show();
    }
}
