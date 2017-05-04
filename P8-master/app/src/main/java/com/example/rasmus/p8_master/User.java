package com.example.rasmus.p8_master;

/**
 * Created by Rasmus on 02-05-2017.
 */

public class User {

    String CPR;
    String firstName;
    String lastName;

    public User(){}

    public User(String CPR, String firstName, String lastName) {
        this.CPR = CPR;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCPR() {
        return CPR;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
