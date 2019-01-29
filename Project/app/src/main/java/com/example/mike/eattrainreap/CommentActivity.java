package com.example.mike.eattrainreap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CommentActivity extends AppCompatActivity {

    private String commentString;

    private EditText comment;

    private Workout newWorkout;

    Intent intent;


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

        // variables linked to edittext and "add" button
        comment = findViewById(R.id.comment_info);
        Button addComment = findViewById(R.id.add_button);

        // get new workout via intent
        intent = getIntent();
        newWorkout = (Workout) intent.getSerializableExtra("newWorkout");

        // when clicked on "add"
        addComment.setOnClickListener(new AddCommentClicked());
    }

    public class AddCommentClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // only set comment if user typed something
            commentString = comment.getText().toString();
            if (!commentString.equals("")) {
                newWorkout.setComment(commentString);
            }

            MyWorkoutsActivity.workouts.add(newWorkout);

            // go to workout schedule
            Intent intent2 = new Intent(CommentActivity.this, WorkoutScheduleActivity.class);
            startActivity(intent2);
        }
    }
}
