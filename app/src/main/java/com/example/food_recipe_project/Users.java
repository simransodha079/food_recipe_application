package com.example.food_recipe_project;

public class Users {
    String name;
    String email;
    String address;
    String password;
    String uid;
    String socityname;
    int usertype;

    public Users() {
    }

    public Users(String name, String email, String address, String password, String uid, String socityname, int usertype) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.uid = uid;
        this.socityname = socityname;
        this.usertype = usertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSocityname() {
        return socityname;
    }

    public void setSocityname(String socityname) {
        this.socityname = socityname;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }
}
