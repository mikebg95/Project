package com.example.mike.eattrainreap;

import java.io.Serializable;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FindExerciseActivity extends AppCompatActivity implements ExercisesRequest.Callback, Serializable {

    // variable for views
    EditText search;
    ListView exercisesView;

    // variables for context and activity callback
    Context context;
    ExercisesRequest.Callback activity;

    Intent intent;

    // to know which exercise what clicked by user
    int positionClicked;

    // to know if user wants to add to favorites or to workout
    private boolean forWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_exercise);

        // set context and activity
        context = getApplicationContext();
        activity = this;

        // by default
//        forWorkout = false;

        // when searching to add to workout
        intent = getIntent();
        forWorkout = intent.getBooleanExtra("forWorkout", false);
        positionClicked = intent.getIntExtra("position", 300);

        // link variables to views
        exercisesView = findViewById(R.id.exercises_info);
        search = findViewById(R.id.search);

        // request exercises through api
        ExercisesRequest exercisesRequest = new ExercisesRequest(context, activity);
        exercisesRequest.getExercises();

        // when clicked on exercise in listview
        exercisesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // get clicked exercise object
                Exercise currentExercise = (Exercise) parent.getItemAtPosition(position);

                // add exercise to and start intent for pop-up screen
                intent = new Intent(getApplicationContext(), PopUpActivity.class);
                intent.putExtra("exercise", currentExercise);

                // make clear if for favorites or for workout
                intent.putExtra("isFavorite", false);
                intent.putExtra("forWorkout", forWorkout);
                intent.putExtra("position", positionClicked);
                startActivity(intent);
            }
        });
    }

    // when api request succeeded
    @Override
    public void gotExercises(ArrayList<Exercise> exercises) {

        // link exercises to listview via adapter
        final ExerciseAdapter adapter = new ExerciseAdapter(this, R.layout.exercise_row, exercises);
        exercisesView.setAdapter(adapter);

        // add search function to activity
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    // when api request not succeeded
    @Override
    public void gotExercisesError(String message) {
        // print error message to screen
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
