package com.example.facesnatch.Model;

public class User {
    private String id;
    private String name;
    private String position;
    private String created_at;

    public User(){

    }

    public User(String id, String name, String position, String created_at) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.created_at = created_at;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}
