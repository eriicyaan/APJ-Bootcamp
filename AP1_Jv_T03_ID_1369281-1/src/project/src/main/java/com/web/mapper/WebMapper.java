package com.web.mapper;

import com.domain.model.Game;
import com.web.model.GameRequest;
import com.web.model.GameResponse;

import java.util.UUID;

public interface WebMapper {
    Game toDomain(UUID id, GameRequest request);
    GameResponse toResponse(Game game);
    GameResponse toResponse(UUID id, int[][] field);
}
