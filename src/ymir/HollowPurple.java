package ymir;

import java.awt.Point;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Obstacle.Obstacle;
import Obstacle.ObstacleFactory;
import Obstacle.PurpleObstacle;

public class HollowPurple extends YmirAbility implements Serializable{
	private static final long serialVersionUID = 1L;

	ObstacleFactory factory = ObstacleFactory.getInstance();

	@Override
	public void useAbility() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("h");

		ArrayList<Obstacle> allObstacles = getGameMap().getAllObstacles();
		ArrayList<Obstacle> freeObstacles = new ArrayList<Obstacle>();
		
		for (int i = 0; i< allObstacles.size(); i++){
			if (allObstacles.get(i).getObstacleHealth() == 0) {
				freeObstacles.add((PurpleObstacle) factory.getObstacleType(4)); 
				freeObstacles.get(freeObstacles.size() - 1).setSpecialX(allObstacles.get(i).getSpecialX());
				freeObstacles.get(freeObstacles.size() - 1).setSpecialY(allObstacles.get(i).getSpecialY());
			}
		}
		
		for (int i = 0; i< 10; i++){
			freeObstacles.add((PurpleObstacle) factory.getObstacleType(4)); 
			freeObstacles.get(freeObstacles.size() - 1).setSpecialX(Obstacle.getX());
			freeObstacles.get(freeObstacles.size() - 1).setSpecialY(Obstacle.getY());
			Obstacle.getNextCoord();
			}
		
		Collections.shuffle(freeObstacles);

		for (int i = 0; i < 8; i++){
			allObstacles.add(freeObstacles.get(i));
			HashMap<Obstacle, Point> allObsWithCoords = getGameMap().getAllObsWithCoords();
			allObsWithCoords.put(allObstacles.get(i),new Point(Obstacle.getX(),Obstacle.getY()));
			getGameMap().setAllObsWithCoords(allObsWithCoords);
		}
	}
}
