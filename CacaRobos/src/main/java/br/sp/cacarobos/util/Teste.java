package br.sp.cacarobos.util;

public class Teste {
	public static void main(String[] args) {
		CodeGenerator code;
		int i=0;
		while(i<=10){
			code=new CodeGenerator();
			System.out.println(code.generateCode());
			i++;
		}
	}
}
