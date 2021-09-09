package com.kyndryl.task.service.separator;

import org.springframework.stereotype.Service;

@Service(value = "evenrowoddcolSeparatorService")
public class EvenRowOddColSeparatorService implements SeparatorService{

	@Override
	public char getSeparator() {
		return '|';
	}
}
