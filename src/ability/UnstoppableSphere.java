package ability;

import java.io.Serializable;

import Obstacle.Obstacle;
import domain.GameMap;
import domain.Sphere;

public class UnstoppableSphere extends Ability implements DeactivatingBehaviour, Serializable{

	private static final long serialVersionUID = 1L;
	private long startTime = 0;
	private long currentTime;
	private int abilityCount;

	public UnstoppableSphere() {
		this.abilityCount = 0;
	}

	@Override
	public void useAbility() {
		GameMap.getSphere().setUnstoppable(true);
		GameMap.gameMap.setUranusBox(null);
		abilityCount --;
		GameMap.gameMap.setUnstoppableCount(abilityCount);

	}

	@Override
	public void deactivate() {
		if (startTime == 0)
			startTime = System.currentTimeMillis() / 1000;
		currentTime = System.currentTimeMillis() / 1000;
		if ((currentTime - startTime) > 30) {
			GameMap.getSphere().setUnstoppable(false);
			startTime = 0;
		}
	}

	public int getAbilityCount() {
		return abilityCount;
	}

	@Override
	public void getAbility() {
		abilityCount ++;
		GameMap.gameMap.setUnstoppableCount(abilityCount);
	}


}


