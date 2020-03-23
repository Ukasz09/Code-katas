package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ShipSpec {

    @Test
    public static class LocationTest {
        private Location location;
        private Ship ship;
        private Planet planet;

        @BeforeMethod
        public void initializeShipAndLocation() {
            location = new Location(new Point(2, 3), Direction.EAST);
            planet = new Planet(new Point(50, 50));
            ship = new Ship(location, planet);
        }

        public void whenInstantiatedThenLocationIsSet() {
            assertEquals(ship.getLocation(), location);
        }

        public void whenMoveForwardThenForward() {
            Location expected = this.location.copy();
            expected.forward();
            ship.moveForward();
            assertEquals(ship.getLocation(), expected);
        }

        public void whenMoveBackwardThenBackward() {
            Location expected = this.location.copy();
            expected.backward();
            ship.moveBackward();
            assertEquals(ship.getLocation(), expected);
        }

        public void whenMoveLeftThenLeft() {
            Location expected = this.location.copy();
            expected.turnLeft();
            ship.moveLeft();
            assertEquals(ship.getLocation(), expected);
        }

        public void whenMoveRightThenRight() {
            Location expected = this.location.copy();
            expected.turnRight();
            ship.moveRight();
            assertEquals(ship.getLocation(), expected);
        }

        public void whenSingleForwardCommandThenForward() {
            Location expected = this.location.copy();
            expected.forward();
            ship.move(Character.toString(Ship.FORWARD_MOVE_COMMAND));
            assertEquals(ship.getLocation(), expected);
        }

        public void whenSingleBackwardCommandThenForward() {
            Location expected = this.location.copy();
            expected.backward();
            ship.move(Character.toString(Ship.BACKWARD_MOVE_COMMAND));
            assertEquals(ship.getLocation(), expected);
        }

        public void whenSingleLeftCommandThenForward() {
            Location expected = this.location.copy();
            expected.turnLeft();
            ship.move(Character.toString(Ship.LEFT_MOVE_COMMAND));
            assertEquals(ship.getLocation(), expected);
        }

        public void whenSingleRightCommandThenForward() {
            Location expected = this.location.copy();
            expected.turnRight();
            ship.move(Character.toString(Ship.RIGHT_MOVE_COMMAND));
            assertEquals(ship.getLocation(), expected);
        }

        public void whenMultipleForwardCommandsThenForward() {
            char[] commandsChar = {
                    Ship.FORWARD_MOVE_COMMAND,
                    Ship.FORWARD_MOVE_COMMAND,
                    Ship.FORWARD_MOVE_COMMAND
            };
            String commands = new String(commandsChar);
            Location expected = this.location.copy();
            for (int i = 0; i < commands.length(); i++)
                expected.forward();
            ship.move(commands);
            assertEquals(ship.getLocation().getX(), expected.getX());
            assertEquals(ship.getLocation().getY(), expected.getY());
        }

        public void whenMultipleMoveCommandsThenCorrectPosition() {
            char[] commandsChar = {
                    Ship.RIGHT_MOVE_COMMAND,
                    Ship.FORWARD_MOVE_COMMAND,
                    Ship.LEFT_MOVE_COMMAND,
                    Ship.BACKWARD_MOVE_COMMAND
            };
            String commands = new String(commandsChar);
            Location expected = this.location.copy();
            expected.turnRight();
            expected.forward();
            expected.turnLeft();
            expected.backward();
            ship.move(commands);
            assertEquals(ship.getLocation().getX(), expected.getX());
            assertEquals(ship.getLocation().getY(), expected.getY());
        }
    }

    @Test
    public static class WrappingTest {
        private Location location;
        private Ship ship;
        private Planet planet;

        @BeforeMethod
        public void initializeShipAndLocation() {
            location = new Location(new Point(2, 3), Direction.EAST);
            planet = new Planet(new Point(50, 50));
            ship = new Ship(location, planet);
        }

        public void whenInstantiatedThenPlanetIsStored() {
            assertEquals(ship.getPlanet(), planet);
        }

        public void whenOverPassingEastBoundaryThenPositionIsReset() {
            location.setDirection(Direction.EAST);
            location.getPoint().setX(planet.getMax().getX());
            ship.move("f");
            assertEquals(location.getX(), 1);
        }

        public void whenOverPassingWestBoundaryThenPositionIsReset() {
            location.setDirection(Direction.WEST);
            location.getPoint().setX(1);
            ship.move("f");
            assertEquals(location.getX(), planet.getMax().getX());
        }

        public void whenOverPassingNorthBoundaryThenPositionIsReset() {
            location.setDirection(Direction.NORTH);
            location.getPoint().setY(1);
            ship.move("f");
            assertEquals(location.getY(), planet.getMax().getY());
        }

        public void whenOverPassingSouthBoundaryThenPositionIsReset() {
            location.setDirection(Direction.SOUTH);
            location.getPoint().setY(planet.getMax().getY());
            ship.move("f");
            assertEquals(location.getY(), 1);
        }
    }

    @Test
    public static class ObstaclesTest {
        private Location location;
        private Ship ship;
        private Planet planet;
        private List<Point> obstacles;

        @BeforeMethod
        public void initializeShipAndLocation() {
            location = new Location(new Point(2, 3), Direction.EAST);
            obstacles = Arrays.asList(
                    new Point(10, 10),
                    new Point(11, 10),
                    new Point(12, 10),
                    new Point(38, 40),
                    new Point(38, 37)
            );
            planet = new Planet(new Point(50, 50), obstacles);
            ship = new Ship(location, planet);
        }

        public void whenSingleMoveCommandAndObstacleThenNoMove() {
            location.setDirection(Direction.SOUTH);
            location.getPoint().setX(10);
            location.getPoint().setY(9);
            Location expected = this.location.copy();
            ship.move("f");
            assertEquals(location.getY(), expected.getY());
            assertEquals(location.getX(), expected.getX());
        }

        public void whenSingleMoveCommandAndObstacleThenCorrectTextResult() {
            location.setDirection(Direction.SOUTH);
            location.getPoint().setX(10);
            location.getPoint().setY(9);
            String result = ship.move("f");
            assertEquals(result, String.valueOf(Ship.ROVER_CAN_NOT_DO_ACTION_SIGN));
        }

        public void whenMultipleMoveCommandsAndObstacleThenCorrectMoves() {
            location.setDirection(Direction.SOUTH);
            location.getPoint().setX(10);
            location.getPoint().setY(9);
            ship.move("flflbrf");
            assertEquals(location.getY(), 9);
            assertEquals(location.getX(), 12);
        }

        public void whenMultipleMoveCommandsAndObstacleThenCorrectTextResult() {
            location.setDirection(Direction.SOUTH);
            location.getPoint().setX(10);
            location.getPoint().setY(9);
            String result = ship.move("flflbrf");
            char[] expectedSign = {
                    Ship.ROVER_CAN_NOT_DO_ACTION_SIGN,
                    Ship.ROVER_CAN_DO_ACTION_SIGN,
                    Ship.ROVER_CAN_DO_ACTION_SIGN,
                    Ship.ROVER_CAN_DO_ACTION_SIGN,
                    Ship.ROVER_CAN_NOT_DO_ACTION_SIGN,
                    Ship.ROVER_CAN_DO_ACTION_SIGN,
                    Ship.ROVER_CAN_DO_ACTION_SIGN
            };
            assertEquals(result, new String(expectedSign));
        }

    }

}