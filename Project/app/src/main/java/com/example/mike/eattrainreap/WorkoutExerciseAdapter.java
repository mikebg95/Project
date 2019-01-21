package com.example.mike.eattrainreap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

// TODO: make sure row is Uneditable by default!

public class WorkoutExerciseAdapter extends ArrayAdapter<WorkoutExercise2> {

    // create variables for views
    private TextView exerciseName;
    private boolean isEditable;
//    private EditText set1, set2, set3;
//    private EditText rest;

    ViewSwitcher vs_name, vs1, vs2, vs3, vs_rest;
    Button addExercise;

    // create arraylist to store workout exercises
    private ArrayList<WorkoutExercise2> workoutExercises;

    // constructor for this adapter
    public WorkoutExerciseAdapter(Context context, int resource, ArrayList<WorkoutExercise2> workoutExercises, boolean isEditable) {
        super(context, resource, workoutExercises);
        this.workoutExercises = workoutExercises;
        this.isEditable = isEditable;
    }

    // link workout exercise information to row in list view
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.workout_exercise_row_editable, parent, false);
        }

        final WorkoutExercise2 itemLongClicked = MyWorkoutsActivity.workoutExercises.get(position);

        // get workout exercise for that position in list view
        WorkoutExercise2 current = workoutExercises.get(position);

        // link variables to views
        exerciseName = convertView.findViewById(R.id.ex_name);
        TextView set1_text = convertView.findViewById(R.id.set_1_text);
        TextView set2_text = convertView.findViewById(R.id.set_2_text);
        TextView set3_text = convertView.findViewById(R.id.set_3_text);
        TextView rest_text = convertView.findViewById(R.id.rest_text);

        EditText set1_edit = convertView.findViewById(R.id.set_1_edit);
        EditText set2_edit = convertView.findViewById(R.id.set_2_edit);
        EditText set3_edit = convertView.findViewById(R.id.set_3_edit);

        if (current.getExercise() != null) {
            exerciseName.setText(current.getExercise().getName());
        }
        else {
            exerciseName.setText("choose an exercise");
        }

        set1_text.setText(String.valueOf(current.getSet1()));
        set2_text.setText(String.valueOf(current.getSet2()));
        set3_text.setText(String.valueOf(current.getSet3()));
        rest_text.setText(String.valueOf(current.getRest()));

        set1_edit.setText(String.valueOf(current.getSet1()), TextView.BufferType.EDITABLE);
        set2_edit.setText(String.valueOf(current.getSet2()), TextView.BufferType.EDITABLE);
        set3_edit.setText(String.valueOf(current.getSet3()), TextView.BufferType.EDITABLE);
//        rest_edit.setText(String.valueOf(current.getRest()), TextView.BufferType.EDITABLE);

        vs_name = convertView.findViewById(R.id.switcher_name);
        vs1 = convertView.findViewById(R.id.switcher_1);
        vs2 = convertView.findViewById(R.id.switcher_2);
        vs3 = convertView.findViewById(R.id.switcher_3);
        vs_rest = convertView.findViewById(R.id.switcher_rest);

        addExercise = convertView.findViewById(R.id.add);

        // show only uneditable views
        vs_name.reset();
        vs_name.showNext();
        vs1.reset();
        vs1.showNext();
        vs2.reset();
        vs2.showNext();
        vs3.reset();
        vs3.showNext();
        vs_rest.reset();
        vs_rest.showNext();
        addExercise.setVisibility(View.GONE);


        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getContext(), "long clicked", Toast.LENGTH_SHORT).show();

                final String[] options = {"Edit", "Delete", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Select");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which) {
                            case 0:
                                // TODO: make row Editable!
//                                vs_name.reset();
//                                vs1.reset();
//                                vs2.reset();
//                                vs3.reset();
//                                vs_rest.reset();
//
//                                vs_name.showPrevious();
//                                vs1.showPrevious();
//                                vs2.showPrevious();
//                                vs3.showPrevious();
//                                vs_rest.showPrevious();
//                                addExercise.setVisibility(View.VISIBLE);

                                Toast.makeText(getContext(), "'edit' clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                MyWorkoutsActivity.workoutExercises.remove(itemLongClicked);
                                notifyDataSetChanged();
                                Toast.makeText(getContext(), "exercise deleted", Toast.LENGTH_SHORT).show();
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

        return convertView;
    }
}
