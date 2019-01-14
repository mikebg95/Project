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

import java.util.ArrayList;

public class Exercise implements Serializable {

    // variable for exercise item
    private String name;
    private ArrayList<Integer> muscles;
    private ArrayList<Integer> secondaryMuscles;
    private ArrayList<Integer> equipment;
    private String description;

    // constructor for this class


    public Exercise(String name, ArrayList<Integer> muscles, ArrayList<Integer> secondaryMuscles, ArrayList<Integer> equipment, String description) {
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
    public ArrayList<Integer> getMuscles() {
        return muscles;
    }
    public ArrayList<Integer> getSecondaryMuscles() {
        return secondaryMuscles;
    }
    public ArrayList<Integer> getEquipment() {
        return equipment;
    }
    public String getDescription() {
        return description;
    }

    // setters for this class
    public void setName(String name) {
        this.name = name;
    }
    public void setMuscles(ArrayList<Integer> muscles) {
        this.muscles = muscles;
    }
    public void setSecondaryMuscles(ArrayList<Integer> secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }
    public void setEquipment(ArrayList<Integer> equipment) {
        this.equipment = equipment;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
