package com.kyndryl.task.dto;

import com.kyndryl.task.enums.PlayerEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class PlayDto {
	private final int row;
	private final int column;
	private final PlayerEnum player;
}
