package com.example.mike.eattrainreap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WorkoutAdapter extends ArrayAdapter<Workout> {

    // views for adapter
    private TextView muscleGroup;
    TextView timestamp;
    private TextView workoutDay;

    private Workout currentWorkout;

    // arraylist to store workouts
    private ArrayList<Workout> workouts;

    public WorkoutAdapter(Context context, int resource, ArrayList<Workout> workouts) {
        super(context, resource, workouts);
        this.workouts = workouts;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.workout_row, parent, false);
        }

        // bind views to correct information
        muscleGroup = convertView.findViewById(R.id.muscle_group);
        timestamp = convertView.findViewById(R.id.timestamp);
        workoutDay = convertView.findViewById(R.id.workout_day);

        currentWorkout = workouts.get(position);

        muscleGroup.setText(workouts.get(position).getMuscleGroups());
//        muscleGroup.setText(currentWorkout.getMuscleGroups());

        timestamp.setText(currentWorkout.getTimestamp());
        workoutDay.setText(currentWorkout.getWorkoutDay());

        // when workout is long clicked, show options
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {

                Toast.makeText(getContext(), "clicked row was " + position, Toast.LENGTH_SHORT).show();

                final String[] options = {"Edit", "Delete", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Select");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which) {
                            case 0:
                                // go to EditWorkoutActivity, send clicked workout as intent
                                Intent intent = new Intent(getContext(), EditWorkoutActivity.class);
                                intent.putExtra("workoutClicked", currentWorkout);
                                intent.putExtra("position", position);
                                v.getContext().startActivity(intent);

                                Toast.makeText(getContext(), "'edit' clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                MyWorkoutsActivity.workouts.remove(currentWorkout);
                                notifyDataSetChanged();
                                Toast.makeText(getContext(), "workout deleted", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                dialog.dismiss();
                                Toast.makeText(getContext(), "cancelled", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

                builder.show();

                return true;
            }


        });

        // when item is short clicked, show info
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WorkoutInfoActivity.class);
                intent.putExtra("workoutClicked", currentWorkout);
                v.getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
