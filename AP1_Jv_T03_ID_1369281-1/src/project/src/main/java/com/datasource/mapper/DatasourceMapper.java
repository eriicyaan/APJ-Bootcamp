package com.datasource.mapper;

import com.datasource.model.GameEntity;
import com.domain.model.Game;

public interface DatasourceMapper {
    GameEntity toDatasource(Game game);
    Game toDomain(GameEntity gameEntity);
}
