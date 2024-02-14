package domain;

import java.io.Serializable;
import java.util.ArrayList;

import ability.Cannon;

public class MoveHex implements MoveBehaviour, Serializable{

	private Cannon cannon1;
	private Cannon cannon2;
	private static final long serialVersionUID = 1L;

	@Override
	public void move(boolean objUp, boolean objSide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		
		ArrayList<Sphere> spheres1 = cannon1.getSpheres();
		
		ArrayList<Sphere> spheres2 = cannon2.getSpheres();
		
		for(int i = 0; i < spheres1.size(); i++) {
			
			spheres1.get(i).setY(spheres1.get(i).getY()-spheres1.get(i).getVerticalSpeed());
		}
		for(int i = 0; i < spheres2.size(); i++) {
			
			spheres2.get(i).setY(spheres2.get(i).getY()-spheres1.get(i).getVerticalSpeed());
		}


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

	
}
