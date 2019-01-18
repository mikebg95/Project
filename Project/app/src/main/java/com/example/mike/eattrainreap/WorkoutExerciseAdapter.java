package com.example.mike.eattrainreap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutExerciseAdapter extends ArrayAdapter<WorkoutExercise2> {

    // create variables for views
    private TextView exerciseName;
//    private EditText set1, set2, set3;
//    private EditText rest;

    // create arraylist to store workout exercises
    private ArrayList<WorkoutExercise2> workoutExercises = new ArrayList<WorkoutExercise2>();

    // constructor for this adapter
    public WorkoutExerciseAdapter(Context context, int resource, ArrayList<WorkoutExercise2> workoutExercises) {
        super(context, resource, workoutExercises);
        this.workoutExercises = workoutExercises;
    }

    // link workout exercise information to row in list view
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.workout_exercise_row_editable, parent, false);
        }

        // get workout exercise for that position in list view
        WorkoutExercise2 current = workoutExercises.get(position);

        // link variables to views
        exerciseName = convertView.findViewById(R.id.ex_name);
        TextView set1 = convertView.findViewById(R.id.set_1_text);
        TextView set2 = convertView.findViewById(R.id.set_2_text);
        TextView set3 = convertView.findViewById(R.id.set_3_text);
        TextView rest = convertView.findViewById(R.id.rest_text);

        if (current.getExercise() != null) {
            exerciseName.setText(current.getExercise().getName());
        }
        else {
            exerciseName.setText("choose an exercise");
        }

        set1.setText(String.valueOf(current.getSet1()));
        set2.setText(String.valueOf(current.getSet2()));
        set3.setText(String.valueOf(current.getSet3()));
        rest.setText(String.valueOf(current.getRest()));

//        set1.setText(String.valueOf(current.getSet1()), TextView.BufferType.EDITABLE);
//        set2.setText(String.valueOf(current.getSet2()), TextView.BufferType.EDITABLE);
//        set3.setText(String.valueOf(current.getSet3()), TextView.BufferType.EDITABLE);
//        rest.setText(String.valueOf(current.getRest()), TextView.BufferType.EDITABLE);

        return convertView;
    }
}
