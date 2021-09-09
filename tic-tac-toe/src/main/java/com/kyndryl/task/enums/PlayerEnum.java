package com.kyndryl.task.enums;

public enum PlayerEnum {
	X, O;

	private static PlayerEnum currentPlayer = O;

	public static PlayerEnum nextPlayer() {
		if (currentPlayer == O) {
			currentPlayer = X;
		} else {
			currentPlayer = O;
		}
		return currentPlayer;
	}
}
