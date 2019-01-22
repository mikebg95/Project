package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CommentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        // get width and height of screen
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        // set width and height op pop-up screen to 80 percent of full screen
        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.8));

        Intent intent = getIntent();
        final int position = intent.getIntExtra("position", 300);
        Toast.makeText(getApplicationContext(), "position is " + position, Toast.LENGTH_SHORT).show();
//        final Workout workout = MyWorkoutsActivity.workouts.get(position);



        final EditText comment = findViewById(R.id.comment_info);
        Button addComment = findViewById(R.id.add_button);

        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentString = comment.getText().toString();
                if (!commentString.equals("")) {
                    MyWorkoutsActivity.workouts.get(position).setComment(commentString);
                }

//                MyWorkoutsActivity.workouts.add(workout);


                Intent intent2 = new Intent(CommentActivity.this, WorkoutScheduleActivity.class);
                startActivity(intent2);
            }
        });
    }
}
