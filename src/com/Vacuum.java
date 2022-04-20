package com;

public class Vacuum extends Room implements Function{

    public Vacuum(int initPosition, int initRow, int initCol, int[][] roomLayout) {
        super(initPosition, initRow, initCol, roomLayout);
    }

    @Override
    public void clean() {
        String cleanedPart = "(" + getRow() + "," + getCol() + ")";
        System.out.println("Cleaning " + cleanedPart);
        getCleanedParts().add(cleanedPart);
    }

    @Override
    public boolean move() {
        switch(getinitPosition()) {
            case 0:

            case 90:

            case 180:

            case 270:
        }
    }

    @Override
    public void turnRight() {
        setPosition((getPosition() + 90) % 360);
    }

    @Override
    public void turnLeft() {
        if(getPosition() == 0) {
            setPosition(270);
        }
        setPosition((getPosition() - 90) % 360);
    }

    public void moveBack() {
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
    }
}
