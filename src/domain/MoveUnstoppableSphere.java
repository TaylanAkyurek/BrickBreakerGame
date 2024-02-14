package domain;

import java.io.Serializable;

public class MoveUnstoppableSphere implements MoveBehaviour, Serializable {
	
	private static final long serialVersionUID = 1L;
	Sphere sphere;

	public MoveUnstoppableSphere(Sphere sphere) {
		super();
		this.sphere = sphere;
	}

	@Override
	public void move(boolean objUp, boolean objSide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		if(sphere.getX()>490) {
			sphere.horizontalSpeed = -sphere.horizontalSpeed;
		}
		if(10>sphere.getX()) {
			sphere.horizontalSpeed = -sphere.horizontalSpeed;
		}
		if(sphere.getY()>490) {
			sphere.	verticalSpeed = -sphere.verticalSpeed;
		}
		if(10>sphere.getY()) {
			sphere.verticalSpeed = -sphere.verticalSpeed;
		}
		
		sphere.setX(sphere.getX() + sphere.horizontalSpeed);
		sphere.setY(sphere.getY() + sphere.verticalSpeed);
		
		if(sphere == null) {
			
			throw new NullPointerException();
		}
	}

}
