package Obstacle;

public class SimpleObstacle extends Obstacle{

	private static IDestroyingBehaviour destroyingBehaviour =new SimpleDestroying();
	
	public SimpleObstacle(int obstacleHealth,int size) {
		super(obstacleHealth, size, destroyingBehaviour);
		hasHealthText = false;
		increasesScore = true;
	}

	public IDestroyingBehaviour getDestroyingBehaviour() {
		return destroyingBehaviour;
	}

	public void setDestroyingBehaviour(IDestroyingBehaviour destroyingBehaviour) {
		SimpleObstacle.destroyingBehaviour = destroyingBehaviour;
	}
	
	
	
}
