package com.example.mike.eattrainreap;

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

import java.io.Serializable;
import java.util.ArrayList;

public class Exercise implements Serializable {

    // variable for exercise item
    private String name;
    private String muscles;
    private String secondaryMuscles;
    private String equipment;
    private String description;

    // constructor for this class
    public Exercise(String name, String muscles, String secondaryMuscles, String equipment, String description) {
        this.name = name;
        this.muscles = muscles;
        this.secondaryMuscles = secondaryMuscles;
        this.equipment = equipment;
        this.description = description;
    }

    // getters for this class
    public String getName() {
        return name;
    }
    public String getMuscles() {
        return muscles;
    }
    public String getSecondaryMuscles() {
        return secondaryMuscles;
    }
    public String getEquipment() {
        return equipment;
    }
    public String getDescription() {
        return description;
    }
}
