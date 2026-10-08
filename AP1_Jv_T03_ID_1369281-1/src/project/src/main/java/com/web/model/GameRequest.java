package com.web.model;

public class GameRequest {
    private int[][] field;

    public GameRequest(int[][] field) {
        this.field = field;
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }
}
