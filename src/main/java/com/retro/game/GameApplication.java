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
					.developer("Capcom")
					.coverPath("https://www.mobygames.com/images/covers/l/2919-resident-evil-windows-front-cover.jpg").build());
			gameRepo.save(Game.builder()
					.name("Crash Bandicoot")
					.releaseDate(1996)
					.genre("Platformer")
					.developer("Naughty Dog")
					.coverPath("https://upload.wikimedia.org/wikipedia/en/4/44/Crash_Bandicoot_Cover.png").build());
			gameRepo.save(Game.builder()
					.name("Final Fantasy VII")
					.releaseDate(1997)
					.genre("Role-playing")
					.developer("Square")
					.coverPath("https://m.media-amazon.com/images/I/51tkmb93AiL.jpg").build());
			gameRepo.save(Game.builder()
					.name("Alien Trilogy")
					.releaseDate(1996)
					.genre("First-person shooter")
					.developer("Probe Entertainment")
					.coverPath("https://upload.wikimedia.org/wikipedia/en/b/b2/Alien_Trilogy.jpg").build());
		};
	}

}
