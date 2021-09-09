package com.kyndryl.task.service.separator;

import org.springframework.stereotype.Service;

@Service(value = "oddrowoddcolSeparatorService")
public class OddRowOddColSeparatorService implements SeparatorService{

	@Override
	public char getSeparator() {
		return '+';
	}
}
