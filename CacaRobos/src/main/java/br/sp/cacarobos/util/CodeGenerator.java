package br.sp.cacarobos.util;

import java.util.Random;

public class CodeGenerator {
	private Random generator;
	private int firstGroup;
	private int secondGroup;

	public CodeGenerator() {
		generator = new Random();
	}

	public String generateCode() {
		boolean condition=true;
		while(condition){
			firstGroup=generator.nextInt();
			secondGroup=generator.nextInt();
			if((firstGroup!=secondGroup)&&(firstGroup>=0)&&(secondGroup>=0)
					&&(firstGroup>=1000000000)&&(secondGroup>=1000000000)){
				condition=false;
			}
		}
		return buildCode(firstGroup, secondGroup);
	}

	private String buildCode(int firstGroup, int secondGroup) {
		StringBuilder builder = new StringBuilder();
		builder.append(firstGroup);
		builder.append(secondGroup);
		return builder.toString();
	}
}