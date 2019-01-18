package com.example.mike.eattrainreap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

        final WorkoutExerciseAdapter weAdapter = new WorkoutExerciseAdapter(this, R.layout.workout_exercise_row_editable, MyWorkoutsActivity.workoutExercises);
        workoutExercisesView.setAdapter(weAdapter);

        newWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkoutExercise2 newEx = new WorkoutExercise2(null, 0, 0, 0, 0);
                MyWorkoutsActivity.workoutExercises.add(newEx);
                weAdapter.notifyDataSetChanged();
                Log.d("clicked", "new workout clicked!");
            }
        });


    }

    public void makeEditable() {
        ViewSwitcher vs1 = findViewById(R.id.switcher_1);
        ViewSwitcher vs2 = findViewById(R.id.switcher_2);
        ViewSwitcher vs3 = findViewById(R.id.switcher_3);
        ViewSwitcher vsRest = findViewById(R.id.switcher_rest);

        vs1.showNext();
        vs2.showNext();
        vs3.showNext();
        vsRest.showNext();
    }

}
