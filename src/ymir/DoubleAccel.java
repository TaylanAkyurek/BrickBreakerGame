package ymir;

import java.io.Serializable;

import domain.GameMap;
import domain.Sphere;

public class DoubleAccel extends YmirAbility implements Serializable{
	private static final long serialVersionUID = 1L;
	private long startTime = 0;
	private long currentTime;
	private int verticalSpeed;
	private int horizontalSpeed;
	Sphere sphere = GameMap.getSphere();

	@Override
	public void useAbility() {


		verticalSpeed = sphere.getVerticalSpeed();
		sphere.setVerticalSpeed(verticalSpeed/2);

		horizontalSpeed = sphere.getHorizontalSpeed();
		sphere.setHorizontalSpeed(horizontalSpeed/2);
		sphere.setSlow(true);
		System.out.println("d");

		
		
	}
	
	public void deactivate() {
		if (startTime == 0)
			startTime = System.currentTimeMillis() / 1000;
		currentTime = System.currentTimeMillis() / 1000;
		if ((currentTime - startTime) > 15) {
			verticalSpeed = sphere.getVerticalSpeed();
			sphere.setVerticalSpeed(verticalSpeed*2);
			horizontalSpeed = sphere.getHorizontalSpeed();
			sphere.setHorizontalSpeed(horizontalSpeed*2);
			sphere.setSlow(false);
					startTime = 0;
		}
	}
}


