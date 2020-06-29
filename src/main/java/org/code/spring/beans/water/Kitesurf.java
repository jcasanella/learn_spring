package org.code.spring.beans.water;

import org.code.spring.beans.board.IBoard;

public class Kitesurf implements IWaterSport {

    private IBoard board;

    private String location;

    public Kitesurf(IBoard board) {
        this.board = board;
    }

    @Override
    public String ride() {
        return null;
    }

    public boolean isBanana() {
        return this.board.isBananaBoard();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getType() {
        return "kitesurf";
    }
}
