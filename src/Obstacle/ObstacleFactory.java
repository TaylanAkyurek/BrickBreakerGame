package Obstacle;

import java.io.File; 
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import javax.imageio.ImageIO;

public class ObstacleFactory implements Serializable{
	private static final long serialVersionUID = 1L;
	private static ObstacleFactory instance;

	private ObstacleFactory() {}
		
	public static ObstacleFactory getInstance() {
		if (instance == null) {
			instance = new ObstacleFactory();
		}
		return instance;
	}

	public Obstacle getObstacleType(int num) throws IOException  {
		Random random = new Random();
		int x;
		Obstacle obstacle = null;
		if (num == 0) {
			
			x = random.nextInt(5);

			obstacle= new  SimpleObstacle(1, 50);
			obstacle.setDestroyingBehaviour(new SimpleDestroying());
			obstacle.setType(0);
			
			if(x == 1 ) {
				
				obstacle.setMove(true);
				obstacle.setSpeed(1);
				
			}
		}
		else if(num == 1) {
			x = random.nextInt(5);

			obstacle= new FirmObstacle(3,50);
			obstacle.setDestroyingBehaviour(new FirmDestroying());
			obstacle.setType(1);
			
			if(x == 1 ) {
				
				obstacle.setMove(true);
				obstacle.setSpeed(1);
				
			}

	}
		else if (num == 2) {
			
			obstacle = new ExplosiveObstacle(1, 50);
			obstacle.setDestroyingBehaviour(new ExplosiveDestroying());
			obstacle.setType(2);
			
		}else if (num == 3) {
			
			obstacle = new GiftObstacle(1, 50, new GiftDestroying());
			obstacle.setType(3);
			
		}else if (num == 4) {
			obstacle= new PurpleObstacle(1, 50);
			obstacle.setDestroyingBehaviour(new SimpleDestroying());
			obstacle.setType(4);
			
		}else if (num == 5) {
			obstacle= new FrozenObstacle(1, 50, new FrozenDestroying());
			obstacle.setType(5);
		}
		
		return obstacle;
	}
	

}
