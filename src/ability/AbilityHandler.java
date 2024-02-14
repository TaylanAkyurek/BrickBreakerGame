package ability;

import java.awt.event.ActionEvent;   
import java.awt.event.ActionListener;

import domain.GameMap;

public class AbilityHandler{

	private static Ability ability;
	public AbilityHandler(Ability ability) {
		super();

		this.ability = ability;
	}


	public void activateExpansion(){
		if (GameMap.gameMap.getPhantasmExpansionCount() > 0) {
			GameMap.gameMap.getPhantasmExpansion().useAbility();
		}
	}
	public void activateHex(){
		if (GameMap.gameMap.getMagicalHexCount() > 0) {
			GameMap.gameMap.getMagicalHex().useAbility();
		}
	}
	public void activateUnstoppable(){
		if (GameMap.gameMap.getUnstoppableSphereCount() > 0) {
			GameMap.gameMap.getUnstoppableSphere().useAbility();
		}
	}

}
