package org.code.spring.beans.board;

import org.code.spring.beans.water.IWaterSport;

public class Wakeboard implements IWaterSport {

    private IBoard board;
    private String location;

    public Wakeboard(IBoard board) {
        this.board = board;
    }

    @Override
    public String ride() {
        return "kicker!!!";
    }

    @Override
    public boolean isBanana() {
        return board.isBananaBoard();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getType() {
        return "wakeboard";
    }
}
