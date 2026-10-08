package com.domain.service;

import com.domain.model.Game;

import java.util.UUID;

public interface GameService {
    Game makeNextMove(Game game);

    boolean validGame(Game game);
    boolean isGameOver(Game game);
    int[][] create(UUID id);
}
