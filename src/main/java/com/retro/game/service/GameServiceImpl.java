package com.retro.game.service;

import com.retro.game.model.Game;
import com.retro.game.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepo;

    public GameServiceImpl(GameRepository gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Override
    public void addGame(Game game) {
        gameRepo.save(game);
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }

    @Override
    public void deleteGameById(Long id) {
        try {
            gameRepo.deleteById(id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
