package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditInfoActivity extends AppCompatActivity {

    // variables for this activity
    private String age, height, weight, goalWeight;
    private EditText editAge, editWeight, editHeight, editGoalWeight;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        // get needed info from intent
        intent = getIntent();
        age = intent.getStringExtra("age");
        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");
        goalWeight = intent.getStringExtra("goalWeight");

        // set variables to correct views and button
        editAge = findViewById(R.id.age);
        editWeight = findViewById(R.id.weight);
        editHeight = findViewById(R.id.height);
        editGoalWeight = findViewById(R.id.goalWeight);
        Button submit = findViewById(R.id.edit);

        // set correct info to views
        editAge.setText(age);
        editWeight.setText(weight);
        editHeight.setText(height);
        editGoalWeight.setText(goalWeight);

        // when clicked on "submit"
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get info that user filled in
                age = editAge.getText().toString();
                height = editHeight.getText().toString();
                weight = editWeight.getText().toString();
                goalWeight = editGoalWeight.getText().toString();

                // send info to GoalsProgressActivity via intent
                intent = new Intent(getApplicationContext(), GoalsProgressActivity.class);
                intent.putExtra("age", age);
                intent.putExtra("height", height);
                intent.putExtra("weight", weight);
                intent.putExtra("goalWeight", goalWeight);
                startActivity(intent);
            }
        });
    }
}
