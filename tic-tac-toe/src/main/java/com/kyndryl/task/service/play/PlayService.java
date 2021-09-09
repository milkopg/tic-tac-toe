package com.kyndryl.task.service.play;

import com.kyndryl.dto.PlayDto;

public interface PlayService {
	public void startGame();
	public PlayDto nextMove();
	public void markMove(PlayDto playDto);	
	public void endGame(String reason);
}
