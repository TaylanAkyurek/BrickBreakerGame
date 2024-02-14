package domain;

import java.io.Serializable;

import ability.Cannon;

public class MoveCannon implements MoveBehaviour, Serializable{

	private static final long serialVersionUID = 1L;
	private Phantasm phantasm;
	
	private Cannon cannon1;
	private Cannon cannon2;

	@Override
	public void move(boolean objUp, boolean objSide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		
		cannon1.setX(phantasm.getX());
		
		
		cannon2.setX(phantasm.getX() + phantasm.getL());
		


	}

	public Cannon getCannon1() {
		return cannon1;
	}

	public void setCannon1(Cannon cannon1) {
		this.cannon1 = cannon1;
	}

	public Cannon getCannon2() {
		return cannon2;
	}

	public void setCannon2(Cannon cannon2) {
		this.cannon2 = cannon2;
	}

	public Phantasm getPhantasm() {
		return phantasm;
	}

	public void setPhantasm(Phantasm phantasm) {
		this.phantasm = phantasm;
	}

}
