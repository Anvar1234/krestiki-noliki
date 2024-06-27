package org.example.model;

public class Move {
    private Player player;
    private boolean madeMove;

    public Move(Player player) {
        this.player = player;
        this.madeMove = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isMadeMove() {
        return madeMove;
    }

    public void setMadeMove(boolean madeMove) {
        this.madeMove = madeMove;
    }
}
