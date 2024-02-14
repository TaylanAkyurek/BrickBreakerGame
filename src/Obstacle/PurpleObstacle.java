package Obstacle;

import java.io.Serializable;

public class PurpleObstacle extends Obstacle implements Serializable{
	private static final long serialVersionUID = 1L;

	private static IDestroyingBehaviour destroyingBehaviour =new SimpleDestroying();
	
	public PurpleObstacle(int obstacleHealth,int size) {
		super(obstacleHealth, size, destroyingBehaviour);
		hasHealthText = false;
		increasesScore = false;
	}

	public IDestroyingBehaviour getDestroyingBehaviour() {
		return destroyingBehaviour;
	}

	public void setDestroyingBehaviour(IDestroyingBehaviour destroyingBehaviour) {
		PurpleObstacle.destroyingBehaviour = destroyingBehaviour;
	}
	
	
}
