package Obstacle;

import java.io.Serializable;

public class FrozenObstacle extends Obstacle implements Serializable{
	private static final long serialVersionUID = 1L;
	public FrozenObstacle(int obstacleHealth, int size, IDestroyingBehaviour destroyingBehaviour) {
		super(obstacleHealth, size, destroyingBehaviour);
		// TODO Auto-generated constructor stub
		hasHealthText = false;
		increasesScore = false;
	}

}
