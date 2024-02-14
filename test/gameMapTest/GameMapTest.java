package gameMapTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Obstacle.GiftDestroying;
import Obstacle.GiftObstacle;
import domain.GameMap;
import domain.Sphere;

class GameMapTest {

	@BeforeEach
	void setUp() {
		try {
			GameMap gameMap = new GameMap(75, 10, 5, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Simple obstacle must be greater than 75. In this test, we try 0 less than 75. 
	//Firm obstacle must be greater than 10. In this test, we try 0 less than 10. 
	//Explosive obstacle must be greater than 5. In this test, we try 0 less than 5. 
	//Gift obstacle must be greater than 10. In this test, we try 0 less than 10. 
	//That's why it will throw an error. With the assertThrows function, our test will pass if they fails.
	
	@Test
	void obstacleNumTest1() throws Exception {
		GameMap gameMap = new GameMap(0, 0, 0, 0);
		assertThrows(Exception.class, ()->{
			gameMap.getSimpleObstacles();
		});
		assertThrows(Exception.class, ()->{
			gameMap.getFirmObstacles();
		});
		assertThrows(Exception.class, ()->{
			gameMap.getExplosiveObstacles();
		});
		assertThrows(Exception.class, ()->{
			gameMap.getGiftObstacles();
		});

	}
	
	//Simple obstacle must be greater than 75. In this test, we try 75 equals to 75. 
	//Firm obstacle must be greater than 10. In this test, we try 10 equals to 10. 
	//Explosive obstacle must be greater than 5. In this test, we try 5 equals to 5. 
	//Gift obstacle must be greater than 10. In this test, we try 10 equals to 10. 
	//That's why it will be true. With the assertTrue function, our test will pass if they are true.
	
	@Test
	void obstacleNumTest2() throws Exception {
		GameMap gameMap = new GameMap(75, 10, 5, 10);
		assertTrue(gameMap.getSimpleObstacles().size() >=75);
		assertTrue(gameMap.getFirmObstacles().size() >=10);
		assertTrue(gameMap.getExplosiveObstacles().size() >=5);
		assertTrue(gameMap.getGiftObstacles().size() >=10);
	}
	
	//Simple obstacle must be greater than 75. In this test, we try 80 bigger than 75. 
	//Firm obstacle must be greater than 10. In this test, we try 20 bigger than 10. 
	//Explosive obstacle must be greater than 5. In this test, we try 10 bigger than 5. 
	//Gift obstacle must be greater than 10. In this test, we try 20 bigger than 10. 
	//That's why it will be true. With the assertTrue function, our test will pass if they are true.
	@Test
	void obstacleNumTest3() throws Exception {
		GameMap gameMap = new GameMap(80, 20, 10, 20);
		assertTrue(gameMap.getSimpleObstacles().size() >=75);
		assertTrue(gameMap.getFirmObstacles().size() >=10);
		assertTrue(gameMap.getExplosiveObstacles().size() >=5);
		assertTrue(gameMap.getGiftObstacles().size() >=10);
	}
	
	//Sphere's y-coordinate must be less than 500. If it exceeds 500, we return the Sphere to null. 
	//In this test, we gave the y-coordinate 511. 
	//Therefore, if the ball is null, it means that the Y coordinate has passed 500. 
	//With the assertNull function, our test will pass if our ball is null.
	@Test
	void ballCoordTest1() throws Exception {
		GameMap gameMap = new GameMap(75, 10, 5, 10);
		gameMap.setSphere(new Sphere(5,5,80,511,20));
		assertNull(gameMap.getSphere());
	}
	
	//Sphere's y-coordinate must be less than 500. If it exceeds 500, we return the Sphere to null. 
	//In this test, we gave the y-coordinate 400. 
	//Therefore, if the ball is not null, it means that the Y coordinate has not passed 500. 
	//With the assertNotNull function, our test will pass if our ball is not null.
	@Test
	void ballCoordTest2() throws Exception {
		GameMap gameMap = new GameMap(75, 10, 5, 10);
		gameMap.setSphere(new Sphere(5,5,80,400,20));
		assertNotNull(gameMap.getSphere());
	}
	
	//This test checks the checkCoord function.
	//If the obstacs are placed in the game map at the correct coordinate,
	//the assertTrue function will return the correct result and our test will pass.
	@Test
	void checkCoordTest() throws Exception {
		
		GameMap gameMap = new GameMap(75, 10, 5, 10);

		assertTrue(gameMap.checkCoord());
	
	}
	
}