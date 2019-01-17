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

    EditText search;
    ListView exercisesView;
    Context context;
    ExercisesRequest.Callback activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_exercise);

        // set context and activity
        context = getApplicationContext();
        activity = this;

        // link variables to views
        exercisesView = findViewById(R.id.exercises);
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

                // get needed values from exercise object
//                String name = currentExercise.getName();
//                String description = currentExercise.getDescription();
//                String muscles = currentExercise.getMuscles();
//                String secondaryMuscles = currentExercise.getSecondaryMuscles();
//                String equipment = currentExercise.getEquipment();

                // add exercise to and start intent for pop-up screen
                Intent intent = new Intent(FindExerciseActivity.this, PopUpActivity.class);
                intent.putExtra("exercise", currentExercise);
//
//                intent.putExtra("name", name);
//                intent.putExtra("description", description);
//                intent.putExtra("muscles", muscles);
//                intent.putExtra("secondaryMuscles", secondaryMuscles);
//                intent.putExtra("equipment", equipment);

                startActivity(intent);
            }
        });
    }

    // when api request succeeded
    @Override
    public void gotExercises(ArrayList<Exercise> exercises) {
//        for (int i = 0; i < exercises.size(); i++) {
////            Log.d("exercise muscles", exercises.get(i).getMuscles().toString());
//
//        }

        // create adapter and link exercises to listview
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
