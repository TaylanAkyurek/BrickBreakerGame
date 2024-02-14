package domain;

import Obstacle.ExplosiveObstacle; 
import Obstacle.FirmObstacle;
import Obstacle.SimpleObstacle;

public class BuildHandler {
	
	private int simpleObsNum;
	private int firmObsNum;
	private int explosiveObsNum;
	private int giftNum;
	

	private GameMap gameMap;
	private Player player;
	
	public BuildHandler(int simpleObsNum, int firmObsNum, int explosiveObsNum,int giftNum) throws Exception {
		
		this.simpleObsNum = simpleObsNum;
		this.firmObsNum = firmObsNum;
		this.explosiveObsNum = explosiveObsNum;
		this.giftNum = giftNum;

		gameMap = new GameMap(simpleObsNum, firmObsNum,explosiveObsNum, giftNum);
		player = new Player();
	}
	
	public GameMap getGameMap() {
		return gameMap;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	
//	public void addListener(BuildListener bl) {
//		gameMap.addBuildListener(bl);
//		gameMap.publishBuildEvent();
//	}
}
