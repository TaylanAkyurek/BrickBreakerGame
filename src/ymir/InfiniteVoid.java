package ymir;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import Obstacle.FrozenObstacle;
import Obstacle.Obstacle;
import Obstacle.ObstacleFactory;
import Obstacle.PurpleObstacle;
import domain.GameMap;

public class InfiniteVoid extends YmirAbility implements Serializable{
	private static final long serialVersionUID = 1L;
	ObstacleFactory factory = ObstacleFactory.getInstance();
	FrozenObstacle frozenObs;
	private long startTime = 0;
	private long currentTime;
	ArrayList<Integer> indexFrozen;
	static ArrayList<Obstacle> oldObstacles = new ArrayList<Obstacle>();
	ArrayList<Obstacle> allObstacles;
	
	@Override
	public void useAbility() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("i");
		indexFrozen = new ArrayList<Integer>();
		allObstacles = getGameMap().getAllObstacles();
		oldObstacles = new ArrayList<Obstacle>();
		//ArrayList<Obstacle> frozenObstacles = new ArrayList<Obstacle>();
		

		for (int i = 0; i < allObstacles.size(); i++) {
			oldObstacles.add(allObstacles.get(i));
			if (allObstacles.get(i).getObstacleHealth() != 0) {
				indexFrozen.add(i);
			//	canAddedObstacles.add(allObstacles.get(i));
			}

		}
		if (indexFrozen.size() <= 8) {
			for (int i = 0; i < indexFrozen.size(); i++) {
			//	frozenObstacles.add(canAddedObstacles.get(i));
				frozenObs = (FrozenObstacle) factory.getObstacleType(5);
				frozenObs.setSpecialX(allObstacles.get(indexFrozen.get(i)).getSpecialX());
				frozenObs.setSpecialY(allObstacles.get(indexFrozen.get(i)).getSpecialY());
				//oldObstacles.add(allObstacles.get(i));
				allObstacles.set(indexFrozen.get(i), frozenObs);
		
			}
			
		} else {
			Collections.shuffle(indexFrozen);
			for (int i = 0; i < 8; i++) {
				frozenObs = (FrozenObstacle) factory.getObstacleType(5);
				frozenObs.setSpecialX(allObstacles.get(indexFrozen.get(i)).getSpecialX());
				frozenObs.setSpecialY(allObstacles.get(indexFrozen.get(i)).getSpecialY());
				//oldObstacles.add(allObstacles.get(i));
				allObstacles.set(indexFrozen.get(i), frozenObs);
				
			}
		}
		GameMap.gameMap.setHasFrozen(true);
		GameMap.gameMap.setOldObstacles(oldObstacles);


	}
	
	public void deactivate() {
		if (startTime == 0)
			startTime = System.currentTimeMillis() / 1000;
		currentTime = System.currentTimeMillis() / 1000;
		if ((currentTime - startTime) > 15) {
			for (int i = 0; i < GameMap.gameMap.getOldObstacles().size(); i++) {
				if (GameMap.gameMap.getAllObstacles().get(i).getType() == 5) {
					GameMap.gameMap.getAllObstacles().set(i, GameMap.gameMap.getOldObstacles().get(i));
					
				//	canAddedObstacles.add(allObstacles.get(i));
				}
				

			}
			GameMap.gameMap.setHasFrozen(false);
			startTime = 0;
					
		}
	}

	public ArrayList<Integer> getIndexFrozen() {
		return indexFrozen;
	}

	public void setIndexFrozen(ArrayList<Integer> indexFrozen) {
		this.indexFrozen = indexFrozen;
	}

}
