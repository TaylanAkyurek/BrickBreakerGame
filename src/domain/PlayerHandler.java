package domain;

public class PlayerHandler {


	public Player getPlayer() {
		return Player.player;
	}
	public String getScore() {
		return String.valueOf(Player.player.scoreHelper());
	}
	public int getTimeElapsed() {
		return Player.player.TimeElapsed;
	}
	public void setTimeElapsed(int time) {
		Player.player.TimeElapsed = time;
	}
	public boolean getPlayerDead() {
		return Player.player.playerDead;
	}
	public int getRemLives() {
		return Player.player.remLives;
	}
	public void decreaseRemLives() {
		Player.player.remLives--;
	}
	public void setPlayerDead(boolean dead) {
		Player.player.playerDead = dead;
	}

}
