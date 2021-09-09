package com.kyndryl.task.service.play;

import com.kyndryl.task.dto.PlayDto;

public interface PlayService {
	public void startGame();
	public void nextMove();
	public void markMove(PlayDto playDto);	
	public void endGame(String reason);
}
