package com.kyndryl.task.service.separator;

import org.springframework.stereotype.Service;

@Service(value = "evenrowevencolSeparatorService")
public class EvenRowEvenColSeparatorService implements SeparatorService{

	@Override
	public char getSeparator() {
		return ' ';
	}
}
