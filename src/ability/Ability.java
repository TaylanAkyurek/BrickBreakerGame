package ability;

import domain.GameMap;

public abstract class Ability {

	protected GameMap gameMap = GameMap.gameMap;
	public abstract void useAbility();
	public abstract void getAbility();
	
	public GameMap getGameMap() {
		return gameMap;
	}
	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

}
