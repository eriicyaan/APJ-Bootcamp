package com.di;

import com.datasource.mapper.GameDatasourceMapper;
import com.datasource.repository.GameRepository;
import com.datasource.storage.GameStorage;
import com.domain.handler.ControllerExceptionHandler;
import com.domain.service.impl.GameServiceImpl;
import com.web.controller.GameController;
import com.web.mapper.GameWebMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public GameDatasourceMapper datasourceMapper() {
        return new GameDatasourceMapper();
    }

    @Bean
    public GameRepository gameRepository(GameStorage gameStorage) {
        return new GameRepository(gameStorage);
    }

    @Bean
    public GameStorage gameStorage() {
        return new GameStorage();
    }

    @Bean
    public ControllerExceptionHandler controllerExceptionHandler() {
        return new ControllerExceptionHandler();
    }

    @Bean
    public GameServiceImpl gameService(GameRepository gameRepository, GameDatasourceMapper datasourceMapper) {
        return new GameServiceImpl(gameRepository, datasourceMapper);
    }



    @Bean
    public GameController gameController(GameServiceImpl gameService, GameWebMapper webMapper) {
        return new GameController(gameService, webMapper);
    }

    @Bean
    public GameWebMapper webMapper() {
        return new GameWebMapper();
    }


}
