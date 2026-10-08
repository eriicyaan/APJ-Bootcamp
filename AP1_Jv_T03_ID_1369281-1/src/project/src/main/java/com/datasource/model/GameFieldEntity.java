package com.datasource.model;

public class GameFieldEntity {
    private int[][] field;

    public GameFieldEntity(int[][] field) {
        this.field = field;
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }
}
