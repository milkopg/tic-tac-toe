package com.kyndryl.task.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.kyndryl.task.service.play.PlayService;

@Service
public class PlayerWonEventListener implements ApplicationListener<PlayerWonEvent>{

	private final PlayService playService;
	
	@Autowired
	public PlayerWonEventListener(final PlayService playService) {
		this.playService = playService;
	}
	
	@Override
	public void onApplicationEvent(final PlayerWonEvent event) {
		System.out.println("Received PlayerWonEvent: " + event.getMessage());
		playService.endGame(event.getMessage());
		
	}

}
