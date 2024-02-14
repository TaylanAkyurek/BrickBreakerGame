package domain;

import java.io.Serializable;

import ui.AnimationPanel;

public class MoveSphere implements MoveBehaviour, Serializable{

	private static final long serialVersionUID = 1L;
	Sphere sphere;
	
	
	public MoveSphere(Sphere sphere) {
		super();
		this.sphere = sphere;
	}




	@Override
	public void move(boolean objUp, boolean objSide) {
	
		// Modifies: this method modifies the coordinates of the sphere
		// More specificially, if there is no wall or object in sides of 
		// sphere, this method updates sphere's coordinates by exact amount
		// of its speed, if there is wall or object, sphere's vertical or
		// horizontal speed will become negative accordingly.
		
		
		if(sphere.getX()>1200 || objSide) {
			sphere.horizontalSpeed = -sphere.horizontalSpeed;
		}
		if(10>sphere.getX()) {
			sphere.horizontalSpeed = -sphere.horizontalSpeed;
		}
		if(sphere.getY()>700) {
			Player.playerDead = true;
			sphere.	verticalSpeed = -sphere.verticalSpeed;

		}
		if(objUp) {

			sphere.	verticalSpeed = -sphere.verticalSpeed;

		}
		if(10>sphere.getY()) {


			sphere.verticalSpeed = -sphere.verticalSpeed;
			//game over


		}
		
		if(objUp == false && objSide == false) {
		sphere.setX(sphere.getX() + sphere.horizontalSpeed);
		sphere.setY(sphere.getY() + sphere.verticalSpeed);
		}
		
		if(sphere == null) {
			
			throw new NullPointerException();
		}

	}




	public Sphere getSphere() {
		return sphere;
	}




	public void setSphere(Sphere sphere) {
		this.sphere = sphere;
	}




	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}
