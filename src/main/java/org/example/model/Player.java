package org.example.model;

public class Player {
    private static int countId = 0;
    private final int id;
    private String name;
    private String marker;

    public Player(String name, String marker) {
        this.id = ++countId;
        this.name = name;
        this.marker = marker;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }
}
