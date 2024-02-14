package ability;


import java.io.Serializable; 
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import domain.GameMap;

public class PhantasmExpansion extends Ability implements DeactivatingBehaviour, Serializable{

	private static final long serialVersionUID = 1L;
	private static Boolean active = false;
	private long startTime = 0;
	private long currentTime;
	private int abilityCount;
	
	public PhantasmExpansion() {
		this.abilityCount = 0;
	}

	@Override
	public void useAbility() {
		int l = GameMap.getPhantasm().getL();
		GameMap.getPhantasm().setL(2 * l);
		GameMap.getPhantasm().setExpanded(true);
		abilityCount --;
		GameMap.gameMap.setExpansionCount(abilityCount);

}

	public static Boolean isActive() {
		return active;
	}

	public static void setActive(Boolean active) {
		PhantasmExpansion.active = active;
	}

	public void deactivate() {
		if (startTime == 0)
			startTime = System.currentTimeMillis() / 1000;
		currentTime = System.currentTimeMillis() / 1000;
		if ((currentTime - startTime) > 30) {
					int l = GameMap.getPhantasm().getL();
					GameMap.getPhantasm().setL(l / 2);
					GameMap.getPhantasm().setExpanded(false);
					startTime = 0;
		}
	}

	public int getAbilityCount() {
		return abilityCount;
	}

	@Override
	public void getAbility() {
		abilityCount ++;
		GameMap.gameMap.setExpansionCount(abilityCount);
	}

	
	}


