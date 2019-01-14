package com.example.mike.eattrainreap;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ExercisesRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Context context;
    private Callback activity;

    // send callback to one of these
    public interface Callback {
        void gotExercises(ArrayList<Exercise> exercises);
        void gotExercisesError(String message);
    }

    // constructor for this class
    public ExerciseseRequest(Context context) {
        this.context = context;
    }

    void getExercises(Callback activity) {
        // initialize queue, request jsonObject and add request to queue
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequesst("https://api.myjson.com/bins/6htpk", null, this, this);
        queue.add(jsonObjectRequest);

        // save activity to local variable
        this.activity = activity;
    }

    // when api request failed
    @Override
    public void onErrorResponse(VolleyError error) {
        activity.gotExercisesError(error.getMessage());

    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            ArrayList<Exercise> exercises = new ArrayList<>();

            ArrayList<Integer> musclesArray = new ArrayList<>();
            ArrayList<Integer> secondaryMusclesArray = new ArrayList<>();
            ArrayList<Integer> equipmentArray = new ArrayList<>();

            for (int i = 0; i < response.length; i++) {
                JSONObject exercise = response.getJSONObject(i);

                // get all needed variables from exercise item
                String name = exercise.getString("name");
                String description = exercise.getString("description");
                ArrayList<Integer> muscles = exercise.getJSONArray("muscles");
                ArrayList<Integer> secondaryMuscles = exercise.getJSONArray("muscles_secondary");
                ArrayList<Integer> equipment = exercise.getJSONArray("equipment");

                for (int j = 0; j < muscles.length(); j++) {
                    musclesArray.add(muscles.get(j).toString());
                }

                for (int k = 0; k < secondaryMuscles.length(); k++) {
                    secondaryMusclesArray.add(secondaryMuscles.get(j).toString());
                }

                for (int l = 0; l < equipment.length(); l++) {
                    equipmentArray.add(equipment.get(l).toString());
                }

                // create exercise object and add to arraylist of exercises
                Exercise objectExercise = new Exercise(name, muscles, secondaryMuscles, equipment, description);
                exercises.add(objectExercise);
            }

            activity.gotExercises(exercises);
        }
        catch (JSONException e) {
            activity.gotExercisesError(e.getMessage());
        }
    }
}
