package com.kyndryl.task.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kyndryl.task.service.drawing.DrawingService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DrawingServiceTest {

	@Autowired
	private DrawingService drawingService;
	
	//@Autowired
	//private PlayService playService;

	@Test
	public void testDrawBoardSize() {
		final char [][] board = drawingService.drawBoard();
		assertEquals(board.length, 5);
		assertEquals(board[0].length, 5);
		
		int countPipes = 0;
		int countPlus = 0;
		int countMinus = 0;

		for (int i=0; i < board.length; i++) {
			for (int j=0; j < board[0].length; j++) {
				if (board[i][j]  == '|') {
					countPipes++;
				} else if (board[i][j]  == '+') {
					countPlus++;
				} else if (board[i][j]  == '-') {
					countMinus++;
				}
			}
		}
		
		assertEquals(countPipes, 6);
		assertEquals(countPlus, 4);
		assertEquals(countMinus, 6);
		
	}
	
	//@Test
//	public void testStartGame() {
//		playService.startGame();
//	}
//	
	@Test
	public void getSeparatorTest() {
		drawingService.drawBoard();
		assertEquals("evenrowevencol", drawingService.getSeparator(0, 0));
		assertEquals("evenrowoddcol", drawingService.getSeparator(0, 1));
		assertEquals("oddrowevencol", drawingService.getSeparator(1, 0));
		assertEquals("oddrowoddcol", drawingService.getSeparator(1, 1));
	}
	
	@Test
	public void isEvenTestTrue() {
		assertEquals(true, drawingService.isEven(0)); 
	}
	
	@Test
	public void isEvenTestFalse() {
		assertEquals(false, drawingService.isEven(1)); 
	}
	
	@Test 
	public void isEvenTest() {
		assertEquals("even", drawingService.evenOrOdd(0));
	}
	
	@Test 
	public void isOddTest() {
		assertEquals("odd", drawingService.evenOrOdd(1));
	}
}
