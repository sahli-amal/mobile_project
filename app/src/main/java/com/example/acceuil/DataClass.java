package com.example.acceuil;

public class DataClass {
    private String fullname;
    private String description;
    private String localisation;
    private String email;
    private String service;

    public DataClass(String fullname, String description, String localisation, String email, String service) {
        this.fullname = fullname;
        this.description = description;
        this.localisation = localisation;
        this.email = email;
        this.service = service;
    }

    public String getFullname() {
        return fullname;
    }

    public String getDescription() {
        return description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getEmail() {
        return email;
    }

    public String getService() {
        return service;
    }
}

