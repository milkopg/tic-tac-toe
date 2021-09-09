package com.kyndryl.task.service.separator;

import org.springframework.stereotype.Service;

@Service(value = "oddrowevencolSeparatorService")
public class OddRowEvenColSeparatorService implements SeparatorService{

	@Override
	public char getSeparator() {
		return '-';
	}
}
