package Obstacle;

import java.io.Serializable;

public class FrozenDestroying implements IDestroyingBehaviour, Serializable{

	private static final long serialVersionUID = 1L;
	private boolean collision;
	@Override
	public void hit(Obstacle obstacle) {
		// TODO Auto-generated method stub
		
	}
	public boolean isCollision() {
		return collision;
	}
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
	

}
