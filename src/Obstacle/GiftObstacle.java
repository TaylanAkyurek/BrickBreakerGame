package Obstacle;

import java.util.ArrayList;
import java.util.Random;

import ability.Ability;
import ability.ChanceGiving;
import ability.MagicalHex;
import ability.PhantasmExpansion;
import ability.UnstoppableSphere;

public class GiftObstacle extends Obstacle{
	
	private static ArrayList<Integer> abilities = new ArrayList<Integer>();
	
	public GiftObstacle(int obstacleHealth, int size, IDestroyingBehaviour destroyingBehaviour) {
		super(obstacleHealth, size, destroyingBehaviour);
		increasesScore = true;
	}	

}
