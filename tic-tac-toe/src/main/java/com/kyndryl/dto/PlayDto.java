package com.kyndryl.dto;

import com.kyndryl.task.enums.PlayerEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayDto {
	private final int row;
	private final int column;
	private final PlayerEnum player;
}
