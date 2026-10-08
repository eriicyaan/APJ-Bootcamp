package com.datasource.repository;

import com.datasource.model.GameEntity;
import com.datasource.storage.GameStorage;
import com.domain.service.GameService;

import java.util.UUID;

public class GameRepository {

    private final GameStorage gameStorage;

    public GameRepository(GameStorage gameStorage) {
        this.gameStorage = gameStorage;
    }

    public void saveGame(GameEntity gameEntity) {
        gameStorage.save(gameEntity);
    }


    public GameEntity findById(UUID id) {
       return gameStorage.findById(id);
    }
}
