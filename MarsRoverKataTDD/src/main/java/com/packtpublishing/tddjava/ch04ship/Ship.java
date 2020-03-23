package com.packtpublishing.tddjava.ch04ship;

public class Ship {
    public static final char FORWARD_MOVE_COMMAND = 'f';
    public static final char BACKWARD_MOVE_COMMAND = 'b';
    public static final char LEFT_MOVE_COMMAND = 'l';
    public static final char RIGHT_MOVE_COMMAND = 'r';
    public static final char ROVER_CAN_NOT_DO_ACTION_SIGN = 'x';
    public static final char ROVER_CAN_DO_ACTION_SIGN = 'o';
    private Location location;
    private Planet planet;

    //----------------------------------------------------------------------------------------------------------------//
    public Ship(Location location, Planet planet) {
        this.location = location;
        this.planet = planet;
    }

    //----------------------------------------------------------------------------------------------------------------//
    public boolean moveForward() {
        return location.forward(planet.getMax(), planet.getObstacles());
    }

    public boolean moveBackward() {
        return location.backward(planet.getMax(), planet.getObstacles());
    }

    //----------------------------------------------------------------------------------------------------------------//
    public Location getLocation() {
        return location;
    }

    public void moveRight() {
        location.turnRight();
    }

    public void moveLeft() {
        location.turnLeft();
    }

    public String move(String commands) {
        StringBuilder result = new StringBuilder("");
        for (char command : commands.toCharArray()) {
            switch (command) {
                case Ship.FORWARD_MOVE_COMMAND: {
                    char stepResult = !moveForward() ? ROVER_CAN_NOT_DO_ACTION_SIGN : ROVER_CAN_DO_ACTION_SIGN;
                    result.append(stepResult);
                }
                break;
                case Ship.BACKWARD_MOVE_COMMAND: {
                    char stepResult = !moveBackward() ? ROVER_CAN_NOT_DO_ACTION_SIGN : ROVER_CAN_DO_ACTION_SIGN;
                    result.append(stepResult);

                }
                break;
                case Ship.LEFT_MOVE_COMMAND: {
                    moveLeft();
                    result.append(ROVER_CAN_DO_ACTION_SIGN);
                }
                break;
                case Ship.RIGHT_MOVE_COMMAND: {
                    moveRight();
                    result.append(ROVER_CAN_DO_ACTION_SIGN);
                }
                break;
            }
        }
        return result.toString();
    }

    public Planet getPlanet() {
        return planet;
    }
}
