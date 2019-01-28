package com.example.mike.eattrainreap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class ExerciseAdapter extends ArrayAdapter<Exercise> implements Filterable {

    ExercisesFilter eFilter;

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

    @Override
    public Filter getFilter() {
        if (eFilter == null) {
            eFilter = new ExercisesFilter();
        }

        return eFilter;
    }

    private class ExercisesFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            // create FilterResults object
            FilterResults results = new FilterResults();

            if (constraint == null || constraint.length() == 0) {
                results.values = exercises;
                results.count = exercises.size();
            }
            else {
                ArrayList<Exercise> filteredExercises = new ArrayList<>();

                for (Exercise e : exercises) {
                    if (e.getName().toUpperCase().contains(constraint.toString().toUpperCase())) {
                        filteredExercises.add(e);
                    }
                }

                results.values = filteredExercises;
                results.count = filteredExercises.size();
            }
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            exercises = (ArrayList<Exercise>) results.values;
            addAll(exercises);
            Log.d("size", Integer.toString(exercises.size()));
            notifyDataSetChanged();
        }
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
        muscle = convertView.findViewById(R.id.workout_day);
        equipment = convertView.findViewById(R.id.equipment);

        // set textviews to relevant info
        name.setText(current.getName());
        muscle.setText(current.getMuscles());
        equipment.setText(current.getEquipment());

        return convertView;
    }
}
