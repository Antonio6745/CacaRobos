package br.sp.cacarobos.model;
public enum Status {
	PROCESSING("Processamento"),FINISHED("Finalizada");
	public String status;
	
	Status(String status){
		this.status=status;
	}
	@Override
	public String toString(){
		return this.status;
	}
}