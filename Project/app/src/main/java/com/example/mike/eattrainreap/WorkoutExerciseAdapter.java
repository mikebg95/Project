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

    // create variables for textviews and edittexts
    private TextView exerciseName;
    private TextView set1_text, set2_text, set3_text, set4_text, set5_text, rest_text;
    private EditText set1_edit, set2_edit, set3_edit, set4_edit, set5_edit, rest_edit;

    private TextView kg1_text, kg2_text, kg3_text, kg4_text, kg5_text;
    private EditText kg1_edit, kg2_edit, kg3_edit, kg4_edit, kg5_edit;

    // create variables for ViewSwitchers and buttons
    private ViewSwitcher vs_name, vs1, vs2, vs3, vs4, vs5, vs_rest;
    private ViewSwitcher vs_kg1, vs_kg2, vs_kg3, vs_kg4, vs_kg5;
    Button findExercise, add;

    private WorkoutExercise2 current;

    // create arraylist to store workout exercises
    private ArrayList<WorkoutExercise2> workoutExercises;

    // constructor for this adapter
    public WorkoutExerciseAdapter(Context context, int resource, ArrayList<WorkoutExercise2> workoutExercises) {
        super(context, resource, workoutExercises);
        this.workoutExercises = workoutExercises;
    }

    // binds info to views in row(s)
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.workout_exercise_row_editable, parent, false);
        }

        // get workout exercise for that position in list view
        current = workoutExercises.get(position);

        // link variables to textviews
        exerciseName = convertView.findViewById(R.id.ex_name);
        set1_text = convertView.findViewById(R.id.set_1_text);
        set2_text = convertView.findViewById(R.id.set_2_text);
        set3_text = convertView.findViewById(R.id.set_3_text);
        set4_text = convertView.findViewById(R.id.set_4_text);
        set5_text = convertView.findViewById(R.id.set_5_text);
        rest_text = convertView.findViewById(R.id.rest_text);

        kg1_text = convertView.findViewById(R.id.kg1_text);
        kg2_text = convertView.findViewById(R.id.kg2_text);
        kg3_text = convertView.findViewById(R.id.kg3_text);
        kg4_text = convertView.findViewById(R.id.kg4_text);
        kg5_text = convertView.findViewById(R.id.kg5_text);

        // link variables to edittexts
        set1_edit = convertView.findViewById(R.id.set_1_edit);
        set2_edit = convertView.findViewById(R.id.set_2_edit);
        set3_edit = convertView.findViewById(R.id.set_3_edit);
        set4_edit = convertView.findViewById(R.id.set_4_edit);
        set5_edit = convertView.findViewById(R.id.set_5_edit);
        rest_edit = convertView.findViewById(R.id.rest_edit);

        kg1_edit = convertView.findViewById(R.id.kg1_edit);
        kg2_edit = convertView.findViewById(R.id.kg2_edit);
        kg3_edit = convertView.findViewById(R.id.kg3_edit);
        kg4_edit = convertView.findViewById(R.id.kg4_edit);
        kg5_edit = convertView.findViewById(R.id.kg5_edit);

        // if exercise is selected, show exercise name
        if (current.getExercise() != null) {
            exerciseName.setText(current.getExercise().getName());
        }
        else {
            exerciseName.setText("No exercise selected");
        }

        // set textviews and edittexts to current information
        set1_text.setText(String.valueOf(current.getSet1()));
        set2_text.setText(String.valueOf(current.getSet2()));
        set3_text.setText(String.valueOf(current.getSet3()));
        set4_text.setText(String.valueOf(current.getSet4()));
        set5_text.setText(String.valueOf(current.getSet5()));
        rest_text.setText(String.valueOf(current.getRest()));

        kg1_text.setText(String.valueOf(current.getKg1()));
        kg2_text.setText(String.valueOf(current.getKg2()));
        kg3_text.setText(String.valueOf(current.getKg3()));
        kg4_text.setText(String.valueOf(current.getKg4()));
        kg5_text.setText(String.valueOf(current.getKg5()));

        set1_edit.setText(String.valueOf(current.getSet1()));
        set2_edit.setText(String.valueOf(current.getSet2()));
        set3_edit.setText(String.valueOf(current.getSet3()));
        set4_edit.setText(String.valueOf(current.getSet4()));
        set5_edit.setText(String.valueOf(current.getSet5()));
        rest_edit.setText(String.valueOf(current.getRest()));

        kg1_edit.setText(String.valueOf(current.getKg1()));
        kg2_edit.setText(String.valueOf(current.getKg2()));
        kg3_edit.setText(String.valueOf(current.getKg3()));
        kg4_edit.setText(String.valueOf(current.getKg4()));
        kg5_edit.setText(String.valueOf(current.getKg5()));

        // link variables to viewswitchers
        vs_name = convertView.findViewById(R.id.switcher_name);
        vs1 = convertView.findViewById(R.id.switcher_1);
        vs2 = convertView.findViewById(R.id.switcher_2);
        vs3 = convertView.findViewById(R.id.switcher_3);
        vs4 = convertView.findViewById(R.id.switcher_4);
        vs5 = convertView.findViewById(R.id.switcher_5);
        vs_rest = convertView.findViewById(R.id.switcher_rest);

        vs_kg1 = convertView.findViewById(R.id.switcher_kg1);
        vs_kg2 = convertView.findViewById(R.id.switcher_kg2);
        vs_kg3 = convertView.findViewById(R.id.switcher_kg3);
        vs_kg4 = convertView.findViewById(R.id.switcher_kg4);
        vs_kg5 = convertView.findViewById(R.id.switcher_kg5);

        // link variables to buttons
        add = convertView.findViewById(R.id.add);
        findExercise = convertView.findViewById(R.id.find_ex);

        // make rows uneditable by default
        vs_name.setDisplayedChild(1);
        vs1.setDisplayedChild(1);
        vs2.setDisplayedChild(1);
        vs3.setDisplayedChild(1);
        vs4.setDisplayedChild(1);
        vs5.setDisplayedChild(1);

        vs_kg1.setDisplayedChild(1);
        vs_kg2.setDisplayedChild(1);
        vs_kg3.setDisplayedChild(1);
        vs_kg4.setDisplayedChild(1);
        vs_kg5.setDisplayedChild(1);

        vs_rest.setDisplayedChild(1);
        add.setVisibility(View.INVISIBLE);

        // when clicked on "Find exercise"
        findExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // make sure the edited fields are saved
                current.setSet1(Integer.parseInt(set1_edit.getText().toString()));
                current.setSet2(Integer.parseInt(set2_edit.getText().toString()));
                current.setSet3(Integer.parseInt(set3_edit.getText().toString()));
                current.setSet4(Integer.parseInt(set4_edit.getText().toString()));
                current.setSet5(Integer.parseInt(set5_edit.getText().toString()));
                current.setRest(Integer.parseInt(rest_edit.getText().toString()));

                current.setKg1(Integer.parseInt(kg1_edit.getText().toString()));
                current.setKg2(Integer.parseInt(kg2_edit.getText().toString()));
                current.setKg3(Integer.parseInt(kg3_edit.getText().toString()));
                current.setKg4(Integer.parseInt(kg4_edit.getText().toString()));
                current.setKg5(Integer.parseInt(kg5_edit.getText().toString()));

                notifyDataSetChanged();

                // go to findExerciseActivity; remember position of workout exercise
                Intent intent = new Intent(getContext(), FindExerciseActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("forWorkout", true);
                v.getContext().startActivity(intent);
            }
        });

        // when long-clicked on a row
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {


                // construct pop-up menu with title
                final String[] options = {"Edit", "Delete", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Select");

                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which) {
                            case 0:

                                // if user chooses "edit", make row editable
                                vs_name = v.findViewById(R.id.switcher_name);
                                vs1 = v.findViewById(R.id.switcher_1);
                                vs2 = v.findViewById(R.id.switcher_2);
                                vs3 = v.findViewById(R.id.switcher_3);
                                vs4 = v.findViewById(R.id.switcher_4);
                                vs5 = v.findViewById(R.id.switcher_5);
                                vs_rest = v.findViewById(R.id.switcher_rest);

                                vs_kg1 = v.findViewById(R.id.switcher_kg1);
                                vs_kg2 = v.findViewById(R.id.switcher_kg2);
                                vs_kg3 = v.findViewById(R.id.switcher_kg3);
                                vs_kg4 = v.findViewById(R.id.switcher_kg4);
                                vs_kg5 = v.findViewById(R.id.switcher_kg5);

                                add = v.findViewById(R.id.add);

                                set1_edit = v.findViewById(R.id.set_1_edit);
                                set2_edit = v.findViewById(R.id.set_2_edit);
                                set3_edit = v.findViewById(R.id.set_3_edit);
                                set4_edit = v.findViewById(R.id.set_4_edit);
                                set5_edit = v.findViewById(R.id.set_5_edit);
                                rest_edit = v.findViewById(R.id.rest_edit);

                                kg1_edit = v.findViewById(R.id.kg1_edit);
                                kg2_edit = v.findViewById(R.id.kg2_edit);
                                kg3_edit = v.findViewById(R.id.kg3_edit);
                                kg4_edit = v.findViewById(R.id.kg4_edit);
                                kg5_edit = v.findViewById(R.id.kg5_edit);

                                vs_name.setDisplayedChild(0);
                                vs1.setDisplayedChild(0);
                                vs2.setDisplayedChild(0);
                                vs3.setDisplayedChild(0);
                                vs4.setDisplayedChild(0);
                                vs5.setDisplayedChild(0);
                                vs_rest.setDisplayedChild(0);

                                vs_kg1.setDisplayedChild(0);
                                vs_kg2.setDisplayedChild(0);
                                vs_kg3.setDisplayedChild(0);
                                vs_kg4.setDisplayedChild(0);
                                vs_kg5.setDisplayedChild(0);

                                add.setVisibility(View.VISIBLE);

                                add.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        Toast.makeText(getContext(), "add button clicked", Toast.LENGTH_SHORT).show();

                                        // get info typed in by user
                                        int set1 = Integer.parseInt(set1_edit.getText().toString());
                                        int set2 = Integer.parseInt(set2_edit.getText().toString());
                                        int set3 = Integer.parseInt(set3_edit.getText().toString());
                                        int set4 = Integer.parseInt(set4_edit.getText().toString());
                                        int set5 = Integer.parseInt(set5_edit.getText().toString());
                                        int rest = Integer.parseInt(rest_edit.getText().toString());

                                        int kg1 = Integer.parseInt(kg1_edit.getText().toString());
                                        int kg2 = Integer.parseInt(kg2_edit.getText().toString());
                                        int kg3 = Integer.parseInt(kg3_edit.getText().toString());
                                        int kg4 = Integer.parseInt(kg4_edit.getText().toString());
                                        int kg5 = Integer.parseInt(kg5_edit.getText().toString());

                                        // set workout exercise info
                                        workoutExercises.get(position).setSet1(set1);
                                        workoutExercises.get(position).setSet2(set2);
                                        workoutExercises.get(position).setSet3(set3);
                                        workoutExercises.get(position).setSet4(set4);
                                        workoutExercises.get(position).setSet5(set5);
                                        workoutExercises.get(position).setRest(rest);

                                        workoutExercises.get(position).setKg1(kg1);
                                        workoutExercises.get(position).setKg2(kg2);
                                        workoutExercises.get(position).setKg3(kg3);
                                        workoutExercises.get(position).setKg4(kg4);
                                        workoutExercises.get(position).setKg5(kg5);

                                        // notify adapter
                                        notifyDataSetChanged();
                                    }
                                });

                                break;
                            case 1:

                                // if user clicks "Delete", remove workout exercise and notify adapter
                                workoutExercises.remove(current);

                                notifyDataSetChanged();
                                Toast.makeText(getContext(), "exercise deleted", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:

                                // when clicked on "Cancel"
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
