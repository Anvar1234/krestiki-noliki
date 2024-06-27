package org.example.model;

public class Player {
    private static int countId = 0;
    private final int id;
    private final String name;
    private final String marker;

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

    public String getMarker() {
        return marker;
    }
}
