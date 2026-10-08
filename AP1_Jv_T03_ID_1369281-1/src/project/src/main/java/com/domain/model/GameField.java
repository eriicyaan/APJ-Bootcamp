package com.domain.model;

public class GameField {
    private int[][] field;

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }

    public GameField(int[][] field) {
        this.field = field;
    }
}
