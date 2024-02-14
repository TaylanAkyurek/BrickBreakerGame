package ymir;

import java.io.IOException;

import domain.GameMap;

public abstract class YmirAbility {


	protected GameMap gameMap = GameMap.gameMap;
	public abstract void useAbility() throws IOException;

	public GameMap getGameMap() {
		return gameMap;
	}
	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}
	
}
