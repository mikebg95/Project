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
import android.widget.ViewSwitcher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewWorkoutActivity extends AppCompatActivity {

    Button newExercise;
    ListView workoutExercisesView;
    Button saveWorkout;
    EditText workoutDay;
    EditText workoutMuscles;

    Exercise exerciseFound;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        newExercise = findViewById(R.id.new_exercise);
        workoutExercisesView = findViewById(R.id.workout_exercises);
        saveWorkout = findViewById(R.id.save_workout);

        workoutDay = findViewById(R.id.day_info);
        workoutMuscles = findViewById(R.id.workout_muscles);


        final WorkoutExerciseAdapter weAdapter = new WorkoutExerciseAdapter(this, R.layout.workout_exercise_row_editable, MyWorkoutsActivity.workoutExercises);
        workoutExercisesView.setAdapter(weAdapter);


        Intent intent = getIntent();
        if (intent.getSerializableExtra("exercise") != null) {
            exerciseFound = (Exercise) intent.getSerializableExtra("exercise");
            position = intent.getIntExtra("position", 300);

            Toast.makeText(getApplicationContext(), "intent is NOT null", Toast.LENGTH_SHORT).show();

//            if (position != 300) {
//                View v = workoutExercisesView.getChildAt(position);
//
////                if (v != null) {
//                    TextView exName = v.findViewById(R.id.ex_name);
//                    exName.setText(exerciseFound.getName());
////                }
//                makeEditable(position);
//            }

            // make the row editable that user was editing before searching for new exercise
//            makeEditable(position);

            // add found exercise to workout exercise
            MyWorkoutsActivity.workoutExercises.get(position).setExercise(exerciseFound);
            weAdapter.notifyDataSetChanged();

        }
        else {
            Toast.makeText(getApplicationContext(), "intent is null", Toast.LENGTH_SHORT).show();
        }

        newExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create new workout exercise object with default values
                WorkoutExercise2 newEx = new WorkoutExercise2(null, 0, 0, 0, 0);

                // add to arraylist of exercises for that workout and notify adapter
                MyWorkoutsActivity.workoutExercises.add(newEx);
                weAdapter.notifyDataSetChanged();

                // TODO: make added row in listview Editable
                // returns (correct) position of added exercise
                int position = weAdapter.getPosition(newEx) - workoutExercisesView.getFirstVisiblePosition();
                Log.d("position", Integer.toString(position));

//                makeEditable(position);

            }
        });

        saveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get muscle group and workout day
                String muscle = workoutMuscles.getText().toString();
                String day = workoutDay.getText().toString();

                // make sure user filled these in
                if (muscle.equals("")) {
                    Toast.makeText(getApplicationContext(), "please fill in muscle group", Toast.LENGTH_SHORT).show();
                }
                else if (day.equals("")) {
                    Toast.makeText(getApplicationContext(), "please fill in workout day", Toast.LENGTH_SHORT).show();
                }
                else {
                    // get timestamp
                    String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

                    // save variables to new workout (with empty comment)
                    Workout newWorkout = new Workout(MyWorkoutsActivity.workoutExercises, day, muscle, "", "added/edited on: " + date);

//                    Toast.makeText(getApplicationContext(), newWorkout.getWorkoutExercises().get(0).getSet1(), Toast.LENGTH_SHORT).show();

                    // clear workout exercises
                    MyWorkoutsActivity.workoutExercises.clear();

                    MyWorkoutsActivity.workouts.add(newWorkout);

                    // send workout as intent to CommentActivity
                    Intent intent = new Intent(NewWorkoutActivity.this, CommentActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            }
        });


    }

    // takes position of row as argument and makes that row editable
    public void makeEditable(int position) {

        // gets listview row for that workout exercise -> DOESNT WORK (returns null!)
        View row = workoutExercisesView.getChildAt(position);

        // variables to refer to switchers and button in that row
        ViewSwitcher vsName = row.findViewById(R.id.switcher_name);
        ViewSwitcher vs1 = row.findViewById(R.id.switcher_1);
        ViewSwitcher vs2 = row.findViewById(R.id.switcher_2);
        ViewSwitcher vs3 = row.findViewById(R.id.switcher_3);
        ViewSwitcher vsRest = row.findViewById(R.id.switcher_rest);
        Button addEx = row.findViewById(R.id.add);

        // switch to editable views and make add button visible
        vsName.setDisplayedChild(0);
        vs1.setDisplayedChild(0);
        vs2.setDisplayedChild(0);
        vs3.setDisplayedChild(0);
        vsRest.setDisplayedChild(0);
        addEx.setVisibility(View.VISIBLE);

    }
}
