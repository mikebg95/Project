package com.example.mike.eattrainreap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

// TODO: make sure row is Uneditable by default!

public class WorkoutExerciseAdapter extends ArrayAdapter<WorkoutExercise2> {

    // create variables for views
    private TextView exerciseName;
//    private EditText set1, set2, set3;
    private TextView set1_text, set2_text, set3_text, rest_text;


    ViewSwitcher vs_name, vs1, vs2, vs3, vs_rest;
    Button addExercise;
    Button findExercise;
    Button add;

    // create arraylist to store workout exercises
    private ArrayList<WorkoutExercise2> workoutExercises;

    // constructor for this adapter
    public WorkoutExerciseAdapter(Context context, int resource, ArrayList<WorkoutExercise2> workoutExercises) {
        super(context, resource, workoutExercises);
        this.workoutExercises = workoutExercises;
    }

    // link workout exercise information to row in list view
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.workout_exercise_row_editable, parent, false);
        }

//        final WorkoutExercise2 itemLongClicked = MyWorkoutsActivity.workoutExercises.get(position);

        // get workout exercise for that position in list view
        final WorkoutExercise2 current = workoutExercises.get(position);

        // link variables to views
        exerciseName = convertView.findViewById(R.id.ex_name);
        set1_text = convertView.findViewById(R.id.set_1_text);
        set2_text = convertView.findViewById(R.id.set_2_text);
        set3_text = convertView.findViewById(R.id.set_3_text);
        rest_text = convertView.findViewById(R.id.rest_text);

        final EditText set1_edit = convertView.findViewById(R.id.set_1_edit);
        final EditText set2_edit = convertView.findViewById(R.id.set_2_edit);
        final EditText set3_edit = convertView.findViewById(R.id.set_3_edit);
        final EditText rest_edit = convertView.findViewById(R.id.rest_edit);

        if (current.getExercise() != null) {
            exerciseName.setText(current.getExercise().getName());
        }
//        else {
//            exerciseName.setText("choose an exercise");
//        }

        set1_text.setText(String.valueOf(current.getSet1()));
        set2_text.setText(String.valueOf(current.getSet2()));
        set3_text.setText(String.valueOf(current.getSet3()));
        rest_text.setText(String.valueOf(current.getRest()));

        set1_edit.setText(String.valueOf(current.getSet1()), TextView.BufferType.EDITABLE);
        set2_edit.setText(String.valueOf(current.getSet2()), TextView.BufferType.EDITABLE);
        set3_edit.setText(String.valueOf(current.getSet3()), TextView.BufferType.EDITABLE);
        rest_edit.setText(String.valueOf(current.getRest()), TextView.BufferType.EDITABLE);

        vs_name = convertView.findViewById(R.id.switcher_name);
        vs1 = convertView.findViewById(R.id.switcher_1);
        vs2 = convertView.findViewById(R.id.switcher_2);
        vs3 = convertView.findViewById(R.id.switcher_3);
        vs_rest = convertView.findViewById(R.id.switcher_rest);

        add = convertView.findViewById(R.id.add);
        findExercise = convertView.findViewById(R.id.find_ex);

        vs_name.setDisplayedChild(1);
        vs1.setDisplayedChild(1);
        vs2.setDisplayedChild(1);
        vs3.setDisplayedChild(1);
        vs_rest.setDisplayedChild(1);

        add.setVisibility(View.INVISIBLE);

        findExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // make sure the edited fields are saved
                current.setSet1(Integer.parseInt(set1_edit.getText().toString()));
                current.setSet2(Integer.parseInt(set2_edit.getText().toString()));
                current.setSet3(Integer.parseInt(set3_edit.getText().toString()));
                current.setRest(Integer.parseInt(rest_edit.getText().toString()));
                notifyDataSetChanged();

                Intent intent = new Intent(getContext(), FindExerciseActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("forWorkout", true);
//                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("add clicked", "add clicked");
//                String name = current.getExercise().getName();

                int set1 = Integer.parseInt(set1_edit.getText().toString());
                int set2 = Integer.parseInt(set2_edit.getText().toString());
                int set3 = Integer.parseInt(set3_edit.getText().toString());
                int rest = Integer.parseInt(rest_edit.getText().toString());

                current.setSet1(set1);
                current.setSet2(set2);
                current.setSet3(set3);
                current.setRest(rest);

                notifyDataSetChanged();
            }
        });


        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getContext(), "Clicked row was " + position, Toast.LENGTH_SHORT).show();

                // construct pop-up menu with title
                final String[] options = {"Edit", "Delete", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Select");


                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which) {

                            // if user chooses "Edit", make row editable
                            case 0:
                                vs_name.setDisplayedChild(0);
                                vs1.setDisplayedChild(0);
                                vs2.setDisplayedChild(0);
                                vs3.setDisplayedChild(0);
                                vs_rest.setDisplayedChild(0);

                                add.setVisibility(View.VISIBLE);

                                Toast.makeText(getContext(), "'edit' clicked", Toast.LENGTH_SHORT).show();

                                break;
                            case 1:
                                MyWorkoutsActivity.workoutExercises.remove(current);
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
