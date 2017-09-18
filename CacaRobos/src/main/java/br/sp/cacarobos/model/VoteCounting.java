package br.sp.cacarobos.model;

public class VoteCounting {
	private int isARobot;
	private int isNotARobot;
	
	public int getIsARobot() {
		return isARobot;
	}
	public void setIsARobot(int isARobot) {
		this.isARobot = isARobot;
	}
	public int getIsNotARobot() {
		return isNotARobot;
	}
	public void setIsNotARobot(int isNotARobot) {
		this.isNotARobot = isNotARobot;
	}
	public void addIsARobotVote(){
		this.isARobot++;
	}
	public void addIsNotARobotVote(){
		this.isNotARobot++;
	}
	@Override
	public String toString() {
		return "VoteCounting [isARobot=" + isARobot + ", isNotARobot=" + isNotARobot + "]";
	}
	
}
