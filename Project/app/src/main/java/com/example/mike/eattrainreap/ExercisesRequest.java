package com.example.mike.eattrainreap;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ExercisesRequest {

    private Context context;
    private Callback activity;

    // send callback to one of these
    public interface Callback {
        void gotExercises(ArrayList<Exercise> exercises);
        void gotExercisesError(String message);
    }

    // constructor
    public ExercisesRequest(Context context, Callback activity) {
        this.context = context;
        this.activity = activity;
    }

    void getExercises() {
//        activity = this.activity;

        // initialize queue, request jsonObject and add request to queue
        RequestQueue queue = Volley.newRequestQueue(this.context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://api.myjson.com/bins/6htpk", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    // create arrays to store json data in
                    ArrayList<Exercise> exercises = new ArrayList<>();
                    ArrayList<Integer> musclesArray = new ArrayList<>();
                    ArrayList<Integer> secondaryMusclesArray = new ArrayList<>();
                    ArrayList<Integer> equipmentArray = new ArrayList<>();

                    // iterate through json data
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject exercise = response.getJSONObject(i).getJSONObject("fields");

                        // as long as exercise has name and is in english
                        if (exercise.has("name")) {
                            if (exercise.get("language").toString().equals("2")) {

                                // get all needed variables from exercise item
                                String name = exercise.getString("name");
                                String description = exercise.getString("description");
                                JSONArray muscles = exercise.getJSONArray("muscles");
                                JSONArray secondaryMuscles = exercise.getJSONArray("muscles_secondary");
                                JSONArray equipment = exercise.getJSONArray("equipment");

                                // convert data to arraylists with integers
                                for (int j = 0; j < muscles.length(); j++) {
                                    musclesArray.add(Integer.parseInt(muscles.get(j).toString()));
                                }

                                for (int k = 0; k < secondaryMuscles.length(); k++) {
                                    secondaryMusclesArray.add(Integer.parseInt(secondaryMuscles.get(k).toString()));
                                }

                                for (int l = 0; l < equipment.length(); l++) {
                                    equipmentArray.add(Integer.parseInt(equipment.get(l).toString()));
                                }

                                // set (secondary) muscles and equipment to printable strings
                                String musclesString = getMuscles(musclesArray);
                                String secondaryMusclesString = getMuscles(secondaryMusclesArray);
                                String equipmentString = getEquipment(equipmentArray);

                                // create exercise object and add to arraylist of exercises
                                Exercise objectExercise = new Exercise(name, musclesString, secondaryMusclesString, equipmentString, description);
                                exercises.add(objectExercise);

                                // clear arraylists
                                musclesArray.clear();
                                secondaryMusclesArray.clear();
                                equipmentArray.clear();
                            }

                        }
                    }

                    for (int i = 0; i < exercises.size(); i++) {
                        Log.d("name " + i, exercises.get(i).getName());
                        Log.d("muscle " + i, exercises.get(i).getMuscles());
                        Log.d("equipment " + i, exercises.get(i).getEquipment());
                    }

                    activity.gotExercises(exercises);
                }
                catch (JSONException e) {
                    activity.gotExercisesError(e.getMessage());
                }
            }
        },
        // when api request failed
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                activity.gotExercisesError(error.getMessage());
            }
        });
        // add json request to volley queue
        queue.add(jsonArrayRequest);
    }

    // takes arraylist of integers as argument and returns string with muscles trained
    private String getMuscles(ArrayList<Integer> muscles) {
        String musclesString = "";
        for (int i = 0; i < muscles.size(); i++) {
            switch (muscles.get(i)) {
                case 1:
                    musclesString += "Biceps, ";
                    break;
                case 2:
                    musclesString += "Shoulders, ";
                    break;
                case 3:
                    musclesString += "Ribs, ";
                    break;
                case 4:
                    musclesString += "Chest, ";
                    break;
                case 5:
                    musclesString += "Triceps, ";
                    break;
                case 6:
                    musclesString += "Abs, ";
                    break;
                case 7:
                    musclesString += "Calves (upper), ";
                    break;
                case 8:
                    musclesString += "Glutes, ";
                    break;
                case 9:
                    musclesString += "Traps, ";
                    break;
                case 10:
                    musclesString += "Quads, ";
                    break;
                case 11:
                    musclesString += "Hamstrings, ";
                    break;
                case 12:
                    musclesString += "Lats, ";
                    break;
                case 13:
                    musclesString += "Forearms, ";
                    break;
                case 14:
                    musclesString += "Obliques, ";
                    break;
                case 15:
                    musclesString += "Calves (lower), ";
                    break;
                case 16:
                    musclesString += "Back, ";
                    break;
            }
        }
//        return musclesString.substring(0, musclesString.length() - 2);
        return musclesString;
    }

    // takes arraylist of integers as argument and returns string with equipment needed
    private String getEquipment(ArrayList<Integer> equipment) {
        String equipmentString = "";
        for (int i = 0; i < equipment.size(); i++) {
            switch (equipment.get(i)) {
                case 1:
                    equipmentString += "Barbell, ";
                    break;
                case 2:
                    equipmentString += "SZ-Bar, ";
                    break;
                case 3:
                    equipmentString += "Dumbbells, ";
                    break;
                case 4:
                    equipmentString += "Gym Mat, ";
                    break;
                case 5:
                    equipmentString += "Swiss Ball, ";
                    break;
                case 6:
                    equipmentString += "Pull-up bar, ";
                    break;
                case 7:
                    equipmentString += "None (bodyweight), ";
                    break;
                case 8:
                    equipmentString += "Bench, ";
                    break;
                case 9:
                    equipmentString += "Incline bench, ";
                    break;
                case 10:
                    equipmentString += "Kettlebell, ";
                    break;
            }
        }
//        return equipmentString.substring(0, equipmentString.length() - 2);
        return equipmentString;
    }

}
