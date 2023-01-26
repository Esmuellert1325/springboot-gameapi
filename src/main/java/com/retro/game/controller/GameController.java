package com.retro.game.controller;

import com.retro.game.model.Game;
import com.retro.game.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gameapi/v1/")
@CrossOrigin
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/getAll")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PostMapping("/add")
    public void addGame(@RequestBody Game game) {
        gameService.addGame(game);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGameById(@PathVariable Long id) {
        gameService.deleteGameById(id);
    }

}
