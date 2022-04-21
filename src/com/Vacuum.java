package com;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;


public class Vacuum implements RobotFunction {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> cleanedParts = new HashSet();
    boolean on = false;
    int battery = 100;
    RobotFunction robot;

    public void moveBack() {
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
    }

    public void backtrack(int row, int col, int direction) {
        cleanedParts.add(new Pair(row, col));
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newDirection = (direction + i) % 4;
            int newRow = row + directions[newDirection][0];
            int newCol = col + directions[newDirection][1];

            if (!cleanedParts.contains(new Pair(newRow, newCol)) && robot.move()) {
                backtrack(newRow, newCol, newDirection);
                moveBack();
            }
            robot.turnRight();
        }
    }

    public void cleanRoom(RobotFunction robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }


    @Override
    public boolean turnOn() {
        return on = true;
    }

    @Override
    public boolean turnOff() {
        if (battery < 1) {
            return on = false;
        }
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