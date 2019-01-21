package com.example.mike.eattrainreap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class NewWorkoutActivity extends AppCompatActivity {

    Button newWorkout;
    ListView workoutExercisesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        newWorkout = findViewById(R.id.new_exercise);
        workoutExercisesView = findViewById(R.id.workout_exercises);

        final WorkoutExerciseAdapter weAdapter = new WorkoutExerciseAdapter(this, R.layout.workout_exercise_row_editable, MyWorkoutsActivity.workoutExercises, false);
        workoutExercisesView.setAdapter(weAdapter);

        registerForContextMenu(workoutExercisesView);

//        workoutExercisesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                ViewSwitcher vs1 = view.findViewById(R.id.switcher_1);
////                vs1.showNext();
//                Toast.makeText(getApplicationContext(), "item clicked", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        newWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkoutExercise2 newEx = new WorkoutExercise2(null, 0, 0, 0, 0);
                MyWorkoutsActivity.workoutExercises.add(newEx);
                weAdapter.notifyDataSetChanged();
                // TODO: make last row in listview Editable
//                ViewSwitcher vs1 = v.findViewById(R.id.switcher_1);
//                makeEditable();
            }
        });
    }



//    public void makeEditable() {
//        ViewSwitcher vs1 = findViewById(R.id.switcher_1);
//        ViewSwitcher vs2 = findViewById(R.id.switcher_2);
//        ViewSwitcher vs3 = findViewById(R.id.switcher_3);
//        ViewSwitcher vsRest = findViewById(R.id.switcher_rest);
//
//        if (vs1 != null) {
//            vs1.showNext();
//        }
//        vs2.showNext();
//        vs3.showNext();
//        vsRest.showNext();
//    }

}
