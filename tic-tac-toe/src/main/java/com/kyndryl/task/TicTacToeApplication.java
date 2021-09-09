package com.kyndryl.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kyndryl.task.service.play.PlayService;

@SpringBootApplication(scanBasePackages = "com.kyndryl" )
public class TicTacToeApplication implements CommandLineRunner{
	
	private final PlayService playService;
	
	public TicTacToeApplication(final PlayService playService) {
		this.playService = playService;
	}

	public static void main(final String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		playService.startGame();
	}

}
