package Obstacle;

public class FirmObstacle extends Obstacle{

	private static IDestroyingBehaviour destroyingBehaviour =new SimpleDestroying();
	
	public FirmObstacle(int obstacleHealth,int size) {
		super(obstacleHealth,size, destroyingBehaviour);
		hasHealthText = true;
		increasesScore = true;
	}

	
}
