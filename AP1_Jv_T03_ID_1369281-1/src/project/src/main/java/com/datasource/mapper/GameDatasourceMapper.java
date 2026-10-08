package com.datasource.mapper;

import com.datasource.model.GameEntity;
import com.datasource.model.GameFieldEntity;
import com.domain.model.Game;
import com.domain.model.GameField;

import java.util.UUID;

public class GameDatasourceMapper implements DatasourceMapper {

    @Override
    public GameEntity toDatasource(Game game) {
        return new GameEntity(game.getId(),
                new GameFieldEntity(game.getField().getField()));
    }

    @Override
    public Game toDomain(GameEntity gameEntity) {
        return new Game(gameEntity.getId(),
                new GameField(gameEntity.getField().getField()));
    }


    public GameEntity toDatasource(UUID id, int[][] field) {
        return new GameEntity(id,
                new GameFieldEntity(field));
    }
}
