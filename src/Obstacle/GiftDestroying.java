package Obstacle;

import java.io.Serializable;

import ability.Ability;
import domain.GameMap;
import domain.UranusBox;

public class GiftDestroying implements IDestroyingBehaviour, Serializable{
	private static final long serialVersionUID = 1L;

	@Override
	public void hit(Obstacle obstacle) {
		// TODO Auto-generated method stub
		GameMap gameMap = GameMap.gameMap;
		obstacle.setObstacleHealth(obstacle.getObstacleHealth()-1);
		gameMap.setUranusBox(new UranusBox(obstacle.getSpecialX(),obstacle.getSpecialY(),20,5));

	}

	
	
	

}
