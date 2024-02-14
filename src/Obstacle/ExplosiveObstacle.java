package Obstacle;

public class ExplosiveObstacle extends Obstacle {
	
	private static IDestroyingBehaviour destroyingBehaviour =new ExplosiveDestroying();

	private int angle = 0;
	
	private boolean clockwise;
	
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	public void setClockWise(boolean clockWise) {
		this.clockwise = clockWise;
	}
	public boolean isClockWise() {
		return clockwise;
	}

	
	
	public ExplosiveObstacle(int obstacleHealth,int size) {
		super(obstacleHealth, size, destroyingBehaviour);
		hasHealthText = false;
	}
	
	public void arrangeAngle() {
		
		//if(clockwise) {
			angle+=20;
	//	}
		//else {
		//	angle-=20;
	//	}
	}
	
	

}
