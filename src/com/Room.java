package com;

import java.util.HashSet;

public class Room {

    private int initPosition;
    private int initRow;
    private int initCol;
    private int row;
    private int col;
    private HashSet<String> cleanedParts = new HashSet();
    private int[][] roomLayout;

    public Room(int initPosition, int initRow, int initCol, int[][] roomLayout) {
        this.initPosition = initPosition;
        this.initRow = initRow;
        this.initCol = initCol;
        this.row = initRow;
        this.col = initCol;
        this.roomLayout = roomLayout;
    }

    public int[][] getRoomLayout() {
        return roomLayout;
    }

    public void setRoomLayout(int[][] roomLayout) {
        this.roomLayout = roomLayout;
    }

    public int getinitPosition() {
        return initPosition;
    }

    public int getInitRow() {
        return initRow;
    }

    public void setInitRow(int initRow) {
        this.initRow = initRow;
        this.row = initRow;
    }

    public int getInitCol() {
        return initCol;
    }

    public void setInitCol(int initCol) {
        this.initCol = initCol;
        this.col = initCol;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public HashSet<String> getCleanedParts() {
        return cleanedParts;
    }
}
