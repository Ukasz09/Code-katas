package com.packtpublishing.tddjava.ch04ship;

public class Ship {
    private Location location;

    //----------------------------------------------------------------------------------------------------------------//
    public Ship(Location location) {
        this.location = location;
    }

    //----------------------------------------------------------------------------------------------------------------//
    public boolean moveForward() {
        return location.forward();
    }

    public boolean moveBackward() {
        return location.backward();
    }

    //----------------------------------------------------------------------------------------------------------------//
    public Location getLocation() {
        return location;
    }
}
