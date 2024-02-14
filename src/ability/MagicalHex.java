package ability;

import java.io.Serializable; 
import java.util.ArrayList;

import domain.GameMap;
import domain.Phantasm;
import domain.Sphere;

public class MagicalHex extends Ability implements DeactivatingBehaviour, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Cannon cannon1;
	private Cannon cannon2;
	private int abilityCount;
	private long startTime = 0;
	private long currentTime;
	
	public MagicalHex() {
		this.abilityCount = 0;
	}
	
	
	@Override
	public void useAbility() {
		Phantasm phantasm = getGameMap().getPhantasm();
		cannon1 = new Cannon(phantasm.getX(), phantasm.getY()- 30, 40, 10);
		cannon2 = new Cannon(phantasm.getX()+ phantasm.getL(), phantasm.getY()-30, 40, 10);
		GameMap.gameMap.setCannon1(cannon1);
		GameMap.gameMap.setCannon2(cannon2);
		
		GameMap.gameMap.setUranusBox(null);
		abilityCount --;
		GameMap.gameMap.setHexCount(abilityCount);

	}

	@Override
	public void deactivate() {
		if (startTime == 0)
			startTime = System.currentTimeMillis() / 1000;
		currentTime = System.currentTimeMillis() / 1000;
		if ((currentTime - startTime) > 30) {
			GameMap.gameMap.setCannon1(null);
			GameMap.gameMap.setCannon2(null);
					startTime = 0;
		}
	}


	public int getAbilityCount() {
		return abilityCount;
	}

	@Override
	public void getAbility() {
		abilityCount ++;
		GameMap.gameMap.setHexCount(abilityCount);
		
	}
		
	}
	

