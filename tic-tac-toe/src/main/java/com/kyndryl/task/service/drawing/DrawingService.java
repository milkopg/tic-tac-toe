package com.kyndryl.task.service.drawing;

public interface DrawingService {

	public static final String SEPARATOR_PIPE = "|";
	public static final String SEPARATOR_PLUS = "+";
	public static final String SEPARATOR_MINUS = "-";
	
	public static final String NUMBER_ODD = "odd";
	public static final String NUMBER_EVEN = "even";
	
	public static final String BOARD_ROW = "row";
	public static final String BOARD_COL = "col";
	
	

	public char[][] drawBoard();
	
	public void printBoard(char [][] board);

	public String getSeparator(int rowNum, int colNum);

	public boolean isEven(int number);

	public String evenOrOdd(int number);
	
}
