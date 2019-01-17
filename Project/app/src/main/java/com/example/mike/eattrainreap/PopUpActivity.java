package com.example.mike.eattrainreap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class PopUpActivity extends Activity implements Serializable {

   public static ArrayList<Exercise> favoriteExercises;

   // variables for views
    TextView exName;
    TextView exMuscles;
    TextView exSecMuscles;
    TextView exEquipment;
    TextView exDescription;
    Button favorite;

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
        exMuscles = findViewById(R.id.muscle);
        exSecMuscles = findViewById(R.id.secondary_muscles);
        exEquipment = findViewById(R.id.equipment);
        exDescription = findViewById(R.id.description);
        favorite = findViewById(R.id.button);

        // get relevant exercise from intent
        Intent intent = getIntent();
        final Exercise exercise = (Exercise) intent.getSerializableExtra("exercise");

//        String name = intent.getStringExtra("name");
//        String description = intent.getStringExtra("description");
//        String equipment = intent.getStringExtra("equipment");
//        String muscles = intent.getStringExtra("muscles");
//        String secondaryMuscles = intent.getStringExtra("secondaryMuscles");

        // set layout views to relevant information
        exName.setText(exercise.getName());
        exDescription.setText(exercise.getDescription());
        exEquipment.setText(exercise.getEquipment());
        exMuscles.setText(exercise.getMuscles());
        exSecMuscles.setText(exercise.getSecondaryMuscles());

        // when button clicked, add exercise to arraylist of favorite exercises
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // only add if not in arralist
                if (!favoriteExercises.contains(exercise)) {
                    favoriteExercises.add(exercise);
                }
                else {
                    Toast.makeText(getApplicationContext(), "exercise already added to favorites!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
