package com;

import java.util.HashSet;
import java.util.Set;

public class Vacuum implements RobotFunction {
    Set<String> cleanedParts = new HashSet<>();
    boolean on = false;

    public void cleanRoom(RobotFunction vacuum) {
        int currDirection = 0;
        backtrack(vacuum, cleanedParts, 0, 0, 0);
    }

    public void moveBack() {
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
    }

    private void backtrack(RobotFunction vacuum, Set<String> cleanedParts, int row, int col, int currDirection) {

        for (int i = 0; i < 4; i++) {
            if (vacuum.move() == true) {
                int newDirection = (currDirection + 1) % 4;
                int x = row;
                int y = col;
                switch (currDirection) {
                    case 0:
                        // go up, reduce i
                        x = row - 1;
                        break;
                    case 90:
                        y = col + 1; // go right
                        break;
                    case 180:
                        x = row + 1; // go down
                        break;
                    case 270:
                        y = col - 1; // go left
                        break;
                    default:
                        break;
                }

                String coordinates = row + "_" + col;
                if (cleanedParts.contains(coordinates)) {
                    backtrack(vacuum, cleanedParts, row, col, currDirection);
                    moveBack();
                    vacuum.turnRight();
                } else {
                    vacuum.clean();
                    cleanedParts.add(coordinates);
                }
            }
        }
    }

    @Override
    public boolean turnOn() {
        return on = true;
    }

    @Override
    public boolean turnOff() {
        return on = false;
    }

    @Override
    public void clean() {

    }

    @Override
    public boolean move() {
        return false;
    }

    @Override
    public void turnRight() {

    }

    @Override
    public void turnLeft() {

    }
}