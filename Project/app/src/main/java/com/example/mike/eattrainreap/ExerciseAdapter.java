package com.example.mike.eattrainreap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {

    // create variables for views
    private TextView name;
    private TextView muscle;
    private TextView equipment;
//    private RatingBar favorite;

    // create empty array to store exercises
    private ArrayList<Exercise> exercises;

    // constructor for this adapter
    public ExerciseAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Exercise> exercises) {
        super(context, resource, exercises);
        this.exercises = exercises;
    }

    // link exercise information to row in list view
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_row, parent, false);
        }

        // get exercise for that position in lsitview
        Exercise current = exercises.get(position);

        // link variables to views
        name = convertView.findViewById(R.id.name);
        muscle = convertView.findViewById(R.id.muscle_group);
        equipment = convertView.findViewById(R.id.equipment);
//        favorite = convertView.findViewById(R.id.favorite);

        // set textviews to relevant info
        name.setText(current.getName());
        muscle.setText(current.getMuscles());
        equipment.setText(current.getEquipment());

        return convertView;
    }
}
