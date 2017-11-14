package br.sp.cacarobos.model;
public enum Status {
	PROCESSING("Processamento"),IN_DISCUSSION("Em Discussão"),FINISHED("Finalizada");
	public String status;
	
	Status(String status){
		this.status=status;
	}
	@Override
	public String toString(){
		return this.status;
	}
}