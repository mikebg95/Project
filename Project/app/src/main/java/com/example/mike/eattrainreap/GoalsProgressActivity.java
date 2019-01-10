package com.example.mike.eattrainreap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GoalsProgressActivity extends AppCompatActivity {

    TextView age;
    TextView height;
    TextView weight;
    TextView goalWeight;

    ImageView graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_progress);

        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        graph = findViewById(R.id.graph);

    }
}
