//package com.kyndryl.task.service;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.kyndryl.task.service.play.PlayService;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class PlayingServiceTest {
//	
//	private final PlayService playService;
//	
//	@Autowired
//	public PlayingServiceTest(final PlayService playService) {
//		this.playService = playService;
//	}
//	
//	@Test
//	public void gameEndedTest() {
//		final int numberOfRun=9;
//		for (int i=0; i < numberOfRun; i++) {
//			playService.run();
//		}
//		
//		
//	}
//}
