package com.retro.game.service;

import com.retro.game.model.Game;

import java.util.List;

public interface GameService {

    void addGame(Game game);

    List<Game> getAllGames();

    void deleteGameById(Long id);
}
