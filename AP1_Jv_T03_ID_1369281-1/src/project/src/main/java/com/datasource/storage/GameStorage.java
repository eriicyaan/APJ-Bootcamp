package com.datasource.storage;

import com.datasource.model.GameEntity;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GameStorage {
    private final ConcurrentHashMap<UUID, GameEntity> storage = new ConcurrentHashMap<>();


    public void save(GameEntity game) {
        storage.put(game.getId(), game);
    }

    public GameEntity findById(UUID id) {
        return storage.get(id);
    }
}
