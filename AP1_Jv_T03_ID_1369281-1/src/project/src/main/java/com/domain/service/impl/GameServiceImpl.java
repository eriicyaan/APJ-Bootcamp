package com.domain.service.impl;

import com.datasource.mapper.GameDatasourceMapper;
import com.datasource.repository.GameRepository;
import com.domain.exception.GameAlreadyFinishedException;
import com.domain.exception.NotValidFieldException;
import com.domain.model.Game;

import com.domain.service.GameService;

import java.util.UUID;

public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameDatasourceMapper datasourceMapper;

    public GameServiceImpl(GameRepository gameRepository,
                           GameDatasourceMapper datasourceMapper) {
        this.gameRepository = gameRepository;
        this.datasourceMapper = datasourceMapper;
    }

    public int[][] generateField() {
        return new int[][]
                {{0,0,0},
                {0,0,0},
                {0,0,0}};
    }


    public int[][] create(UUID id) {
        int[][] field = generateField();

        gameRepository.saveGame(datasourceMapper.toDatasource(id, field));

        return field;
    }


    @Override
    public Game makeNextMove(Game game) {
        if(!validGame(game)) {
            throw new NotValidFieldException("field is not valid");
        }

        int[][] field = game.getField().getField();

        if(computerWon(field)) {
            throw new GameAlreadyFinishedException("game is already finished");
        }

        if (playerWon(field)) {
            gameRepository.saveGame(datasourceMapper.toDatasource(game));
            return game;
        }

        if (draw(field)) {
            gameRepository.saveGame(datasourceMapper.toDatasource(game));
            return game;
        }

        if(isGameOver(game)) {
            throw new GameAlreadyFinishedException("game is already finished");
        }

        makeBestMove(field);

        gameRepository.saveGame(datasourceMapper.toDatasource(game));
        return game;
    }


    private void makeBestMove(int[][] field) {
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;


        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[i].length; j++) {
                if(field[i][j] != 0) continue;

                field[i][j] = 2;
                int score = minmax(field, false);
                field[i][j] = 0;

                if(score > bestScore) {
                    bestScore = score;
                    bestRow = i;
                    bestCol = j;
                }
            }
        }
        field[bestRow][bestCol] = 2;
    }


    private int minmax(int[][] field, boolean maximizing) {
        if(computerWon(field)) {
            return 10;
        }
        if(playerWon(field)) {
            return -10;
        }
        if (draw(field)) {
            return 0;
        }

        if(maximizing) {
            int bestScore = Integer.MIN_VALUE;


            for(int i = 0; i < field.length; i++) {
                for(int j = 0; j < field[i].length; j++) {
                    if(field[i][j] != 0) continue;

                    field[i][j] = 2;
                    int score = minmax(field, false);
                    field[i][j] = 0;

                    bestScore = Math.max(bestScore, score);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;


            for(int i = 0; i < field.length; i++) {
                for(int j = 0; j < field[i].length; j++) {
                    if(field[i][j] != 0) continue;

                    field[i][j] = 1;
                    int score = minmax(field, true);
                    field[i][j] = 0;

                    bestScore = Math.min(bestScore, score);
                }
            }
            return bestScore;
        }
    }

    private boolean playerWon(int[][] field) {
        return hasWin(field, 1);
    }

    private boolean computerWon(int[][] field) {
        return hasWin(field, 2);
    }

    private boolean draw(int[][] field) {
        int emptyCount = 0;

        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[i].length; j++) {
                if(field[i][j] == 0) {
                    emptyCount++;
                }
            }
        }

        return emptyCount == 0
                && !computerWon(field)
                && !playerWon(field);
    }

    private boolean hasWin(int[][] field, int ceil) {
        for(int i = 0; i < field.length; i++) {

            if(hasWinningLine(field[i][0], field[i][1], field[i][2]) && field[i][0] == ceil) {
                return true;
            }

            if(hasWinningLine(field[0][i], field[1][i], field[2][i]) && field[0][i] == ceil) {
                return true;
            }
        }

        if(hasWinningLine(field[0][0], field[1][1], field[2][2]) && field[0][0] == ceil) {
            return true;
        }

        if(hasWinningLine(field[0][2], field[1][1], field[2][0]) && field[0][2] == ceil) {
            return true;
        }

        return false;
    }


    @Override
    public boolean validGame(Game game) {
        int[][] newField = game.getField().getField();
        int[][] oldField = gameRepository.findById(game.getId()).getField().getField();

        int movesCount = 0;
        for(int i = 0; i < oldField.length; i++) {
            for(int j = 0; j < oldField[i].length; j++) {
                if(newField[i][j] != 0
                        && newField[i][j] != 1
                        && newField[i][j] != 2) {
                    return false;
                }

                if(oldField[i][j] != 0 && oldField[i][j] != newField[i][j]) {
                    return false;
                }

                if(oldField[i][j] == 0 && newField[i][j] == 2) {
                    return false;
                }

                if(oldField[i][j] == 0 && newField[i][j] != 0) {
                    movesCount++;
                }
            }
        }

        return movesCount == 1;
    }

    @Override
    public boolean isGameOver(Game game) {
        int[][] field = game.getField().getField();

        for(int i = 0; i < field.length; i++) {
            if(hasWinningLine(field[i][0], field[i][1], field[i][2])
                    || hasWinningLine(field[0][i], field[1][i], field[2][i])) {
                return true;
            }
        }

        return hasWinningLine(field[0][0], field[1][1], field[2][2])
                || hasWinningLine(field[0][2], field[1][1], field[2][0]);
    }


    private boolean hasWinningLine(int a, int b, int c) {
        return a != 0 && a == b && b == c;
    }
}
