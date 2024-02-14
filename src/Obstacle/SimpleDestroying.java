package Obstacle;

import java.io.Serializable; 

import domain.GameMap;
import ui.AnimationPanel;

public class SimpleDestroying implements IDestroyingBehaviour, Serializable{

	private static final long serialVersionUID = 1L;
	private boolean collision;
	@Override
	public void hit(Obstacle obstacle) {
		// TODO Auto-generated method stub
		//if (obstacle.getObstacleHealth()==1) AnimationPanel.setScore(AnimationPanel.getScore() + (300/AnimationPanel.getTimeElapsed()) );
		 obstacle.setObstacleHealth(obstacle.getObstacleHealth()-1);

		
	}
	public boolean isCollision() {
		return collision;
	}
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
	

}
