package com.pth.ci.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

	public List<String[]> getData(String val) {

		List<String[]> data = new ArrayList<String[]>();
		int count = 0;
		for (int i = 1; i <= Integer.parseInt(val); i++) {
			count++;
			data.add(new String[] { String.valueOf(count),
					givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() });
		}
		return data;
	}

	public String givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
		int leftLimit = 97; // letter 'A'
		int rightLimit = 122; // letter 'Z'
		int targetStringLength = 100;
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}
}
