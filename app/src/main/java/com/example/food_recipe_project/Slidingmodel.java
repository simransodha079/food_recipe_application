package com.example.food_recipe_project;

public class Slidingmodel {

   String uri;
    String Recipename,Name;

    public Slidingmodel() {
    }

    public Slidingmodel(String uri, String recipename, String name) {
        this.uri = uri;
        Recipename = recipename;
        Name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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
