package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GoalsProgressActivity extends AppCompatActivity {

    TextView age;
    TextView height;
    TextView weight;
    TextView goalWeight;
    Button edit;

    ImageView graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_progress);

        Intent intent = getIntent();
//        intent.getStringExtra("age");

        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
//        graph = findViewById(R.id.graph);
        goalWeight = findViewById(R.id.goalWeight);
        edit = findViewById(R.id.edit);

        age.setText(intent.getStringExtra("age"));
        height.setText(intent.getStringExtra("height"));
        weight.setText(intent.getStringExtra("weight"));
        goalWeight.setText(intent.getStringExtra("goalWeight"));

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditInfoActivity.class);
                intent.putExtra("age", age.getText());
                intent.putExtra("height", height.getText());
                intent.putExtra("weight", weight.getText());
                intent.putExtra("goalWeight", goalWeight.getText());
                startActivity(intent);
            }
        });
    }
}
