package com.kyndryl.task.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kyndryl.task.dto.PlayDto;
import com.kyndryl.task.event.NextMoveEvent;
import com.kyndryl.task.service.drawing.DrawingService;
import com.kyndryl.task.service.play.PlayService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@RecordApplicationEvents
public class PlayingServiceTest {
	
	private final PlayService playService;
	
	@Autowired
	private ApplicationEvents applicationEvents;
	
	private final DrawingService drawingService;
	
	@Autowired
	public PlayingServiceTest(final PlayService playService,
			final DrawingService drawingService) {
		this.playService = playService;
		this.drawingService = drawingService;
	}
	
	@Test
	public void shouldPublishNextMoveEvent() {
		drawingService.drawBoard();
		playService.nextMove();
		
		assertEquals(1, applicationEvents
			      .stream(NextMoveEvent.class)
			      .filter(event -> event.getSource() instanceof PlayDto)
			      .count());
	}
}
