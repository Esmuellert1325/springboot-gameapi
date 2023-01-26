package com.retro.game;

import com.retro.game.model.Game;
import com.retro.game.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(GameRepository gameRepo) {
		return args -> {
			gameRepo.save(Game.builder()
					.name("Resident Evil")
					.releaseDate(1996)
					.genre("Survival Horror")
					.developer("Capcom").build());
		};
	}

}
