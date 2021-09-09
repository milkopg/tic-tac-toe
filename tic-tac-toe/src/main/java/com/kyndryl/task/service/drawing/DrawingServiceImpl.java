package com.kyndryl.task.service.drawing;

import static com.kyndryl.task.util.Constants.MESSAGE_BOARD_CREATED;
import static com.kyndryl.task.util.Constants.MESSAGE_GAME_START;
import static com.kyndryl.task.util.Constants.MESSAGE_PLAYER_START;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyndryl.task.factory.Factory;
import com.kyndryl.task.service.separator.SeparatorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DrawingServiceImpl implements DrawingService {

	private final Factory factory;
	
	private SeparatorService separatorService;
	
	@Autowired
	public DrawingServiceImpl(final Factory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public char[][] drawBoard() {
		final int numRows = 3;
		final int numCols = 3;
		
		log.info(MESSAGE_GAME_START);
		System.out.println(MESSAGE_GAME_START);
		final int totalRows = numRows + 2;
		final int totalCols = numCols + 2;
		final char [][] board = new char[totalRows][totalCols];
		
		
		for (int row=0; row < totalRows; row++) {
			for (int col=0; col < totalCols; col++) {
				final String serviceName = getSeparator(row, col);
				separatorService = (SeparatorService) factory.getBean(SeparatorService.class, serviceName);
				final char separator = separatorService.getSeparator();
				board[row][col] = separator;
				System.out.print(board[row][col]);
			}
			System.out.println();
		}
		
		log.info(MESSAGE_BOARD_CREATED);
		log.info(MESSAGE_PLAYER_START);
		
		System.out.println(MESSAGE_BOARD_CREATED);
		System.out.println(MESSAGE_PLAYER_START);
		
		return board;
	}
	
	@Override
	public void printBoard(final char[][] board) {
		System.out.println("\nPrintBoard\n");
		
		for (int row=0; row < board.length; row++) {
			for (int col=0; col < board[0].length; col++) {
				System.out.print(board[row][col]);
			}
			System.out.println();
		}
		
	}
	
	@Override
	public String getSeparator(final int rowNum, final int colNum) {
		final StringBuilder builder = new StringBuilder();
		builder.append(evenOrOdd(rowNum))
		.append(BOARD_ROW)
		.append(evenOrOdd(colNum))
		.append(BOARD_COL);
		return builder.toString();
	}

	@Override
	public boolean isEven(final int number) {
		return number % 2 == 0;
	}
	
	@Override
	public String evenOrOdd(final int number) {
		return isEven(number) ? NUMBER_EVEN : NUMBER_ODD;
	}

}
