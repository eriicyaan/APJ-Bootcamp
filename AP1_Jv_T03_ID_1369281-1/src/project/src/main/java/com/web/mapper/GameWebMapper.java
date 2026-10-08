package com.web.mapper;

import com.domain.model.Game;
import com.domain.model.GameField;
import com.web.model.GameRequest;
import com.web.model.GameResponse;

import java.util.UUID;

public class GameWebMapper implements WebMapper {

    @Override
    public Game toDomain(UUID id, GameRequest request) {
        return new Game(id,
                new GameField(request.getField()));
    }

    @Override
    public GameResponse toResponse(Game game) {
        return new GameResponse(game.getId(), game.getField().getField());
    }

    @Override
    public GameResponse toResponse(UUID id, int[][] field) {
        return new GameResponse(id, field);
    }
}
