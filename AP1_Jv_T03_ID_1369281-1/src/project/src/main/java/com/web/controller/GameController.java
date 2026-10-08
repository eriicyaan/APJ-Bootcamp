package com.web.controller;


import com.domain.model.Game;
import com.domain.service.GameService;
import com.web.mapper.WebMapper;
import com.web.model.GameRequest;
import com.web.model.GameResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


// POST localhost:8080/game/{id}
@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final WebMapper webMapper;

    public GameController(GameService gameService, WebMapper webMapper) {
        this.gameService = gameService;
        this.webMapper = webMapper;
    }

    @PostMapping("/{id}")
    public GameResponse post(@PathVariable UUID id,
                             @RequestBody GameRequest gameRequest) {

        Game toDomainGame = webMapper.toDomain(id, gameRequest);

        Game toResponseGame = gameService.makeNextMove(toDomainGame);

        return webMapper.toResponse(toResponseGame);
    }


    @PostMapping
    public GameResponse create() {
        UUID uuid = UUID.randomUUID();

        int[][] field = gameService.create(uuid);
        return webMapper.toResponse(uuid, field);
    }
}

/*
id: 1234
field: {
        "[0, 0, 0]",
        "[0, 0, 0]",
        "[0, 0, 0]"
        }

id: 1234
field: {
        "[1, 0, 0]",
        "[0, 2, 0]",
        "[0, 0, 0]"
        }


id: 1234
field: {
        "[1, 0, 0]",
        "[1, 2, 0]",
        "[0, 0, 0]"
        }

id: 1234
field: {
        "[1, 0, 0]",
        "[1, 2, 0]",
        "[2, 0, 0]"
        }
 */
