package com.example.mike.eattrainreap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class PopUpActivity extends Activity implements Serializable {

   // variables for views
    TextView exName;
    TextView exMuscles;
    TextView exSecMuscles;
    TextView exEquipment;
    TextView exDescription;
    Button favorite;

    int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        // get width and height of screen
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        // set width and height op pop-up screen to 80 percent of full screen
        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.8));

        // link variables to views
        exName = findViewById(R.id.name);
        exMuscles = findViewById(R.id.muscle_info);
        exSecMuscles = findViewById(R.id.secondary_muscles);
        exEquipment = findViewById(R.id.equipment);
        exDescription = findViewById(R.id.description);
        favorite = findViewById(R.id.button);

        // get relevant exercise from intent
        Intent intent = getIntent();
        final Exercise exercise = (Exercise) intent.getSerializableExtra("exercise");
        final Boolean isFavorite = intent.getBooleanExtra("isFavorite", false);
        final Boolean forWorkout = intent.getBooleanExtra("forWorkout", false);

        // set correct text to "add" button
        if (forWorkout) {
            favorite.setText("Add to workout");
            position = intent.getIntExtra("position", 300);
        }
        else {
            if (!isFavorite) {
                favorite.setText("Add to favorites");
            } else {
                favorite.setText("Delete from favorites");
            }
        }

        // set layout views to relevant information
        exName.setText(exercise.getName());
        exDescription.setText(exercise.getDescription());
        exEquipment.setText(exercise.getEquipment());
        exMuscles.setText(exercise.getMuscles());
        exSecMuscles.setText(exercise.getSecondaryMuscles());

        // when button clicked, add/delete exercise to/from either favorites or add to workout exercise
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // if coming from newWorkoutActivity
                if (forWorkout) {

                    // add exercise to correct workout exercisse
                    MyWorkoutsActivity.workoutExercises.get(position).setExercise(exercise);

                    // go back to NewWorkoutActivity and return position as intent
                    Intent intent2 = new Intent(PopUpActivity.this, NewWorkoutActivity.class);
                    if (position != 300) {
                        intent2.putExtra("position", position);
                    }

                    Toast.makeText(getApplicationContext(), "exercise added to workout!", Toast.LENGTH_SHORT).show();
                    startActivity(intent2);
                }
                else {

                    // if user is not coming from favorites
                    if (!isFavorite) {

                        // only add if not in favorites
                        if (!HomeActivity.favoriteExercises.contains(exercise)) {
                            HomeActivity.favoriteExercises.add(exercise);
                            Toast.makeText(getApplicationContext(), "exercise added to favorites!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "exercise already added to favorites!", Toast.LENGTH_SHORT).show();
                        }
                    } else {

                        // check if exercise is in list of favorites
                        Boolean inList = false;
                        for (int i = 0; i < HomeActivity.favoriteExercises.size(); i++) {
                            if (HomeActivity.favoriteExercises.get(i).getName().equals(exercise.getName())) {
                                inList = true;
                            }
                        }

                        // if exercise in favorites, remove exercise and notify adapter
                        if (inList) {
                            for (int i = 0; i < HomeActivity.favoriteExercises.size(); i++) {
                                if (HomeActivity.favoriteExercises.get(i).getName().equals(exercise.getName())) {
                                    HomeActivity.favoriteExercises.remove(i);
                                }
                            }

                            Toast.makeText(getApplicationContext(), "exercise removed from favorites!", Toast.LENGTH_SHORT).show();
                            SavedExercisesActivity.adapter.notifyDataSetChanged();
                        }

                        // if exercise not in favorites
                        else {
                            Toast.makeText(getApplicationContext(), "exercise already removed from favorites!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}
