package Obstacle;

import java.io.Serializable;

import domain.GameMap;
import ui.AnimationPanel;

public class ExplosiveDestroying implements IDestroyingBehaviour, Serializable{
	
	
	protected boolean IsCollison = false;

	public boolean isIsCollison() {
		return IsCollison;
	}

	public void setIsCollison(boolean isCollison) {
		IsCollison = isCollison;
	}


	private static final long serialVersionUID = 1L;
	
	@Override
	public void hit(Obstacle obstacle) {
		// TODO Auto-generated method stub
		IsCollison = true;
		//if (obstacle.getObstacleHealth()==1) AnimationPanel.setScore(AnimationPanel.getScore() + (300/AnimationPanel.getTimeElapsed()) );
		obstacle.setExploded(true);
		 
		
		
	}

	

}
