package com.example.food_recipe_project;

public class Ordermodel {
    String Recipename,Name;

    public Ordermodel() {
    }

    public Ordermodel(String recipename, String name) {
        Recipename = recipename;
        Name = name;
    }

    public String getRecipename() {
        return Recipename;
    }

    public void setRecipename(String recipename) {
        Recipename = recipename;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
