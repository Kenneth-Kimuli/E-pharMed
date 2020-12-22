package com.example.e_pharmed;

/**
 * Created by Kenneth on 19/03/2018.
 */

public class UserProfile {
    private String name;
    private String email;
    private String phoneNumber;


    public UserProfile() {
    }

    public UserProfile(String name, String email, String phoneNumber, String iDNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}