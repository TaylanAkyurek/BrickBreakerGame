package Obstacle;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import ability.Ability;
import domain.Player;

public abstract class Obstacle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int obstacleHealth;
	private int size;
	private IDestroyingBehaviour destroyingBehaviour;
	private Ability ability;
	private boolean move = false;
	private int speed = 2;
	protected boolean hasHealthText;
	private int obstacleType = 10;
	protected boolean increasesScore = true;

	
	private boolean secondClickObject = false;

	private boolean choosen = false;
	public boolean isSecondClickObject() {
		return secondClickObject;
	}

	public void setSecondClickObject(boolean secondClickObject) {
		this.secondClickObject = secondClickObject;
	}


	private boolean isExploded = false;
	
	public boolean isExploded() {
		return isExploded;
	}

	public void setExploded(boolean isExploded) {
		this.isExploded = isExploded;
	}

	public boolean isChoosen() {
		return choosen;
	}

	public void setChoosen(boolean choosen) {
		this.choosen = choosen;
	}

	private Player player = Player.player;


	static int x = 0, y = 0;

	private int specialX;
	private int specialY;
	
	
	public boolean isHasHealthText() {
		return hasHealthText;
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setHasHealthText(boolean hasHealthText) {
		this.hasHealthText = hasHealthText;
	}

	
	private static ArrayList<Point> coords = new ArrayList<>();
	
	public Obstacle(int obstacleHealth,int size, IDestroyingBehaviour destroyingBehaviour) {
		
		this.obstacleHealth = obstacleHealth;
		this.size = size;
		this.destroyingBehaviour = destroyingBehaviour;
	}
	

	public int getObstacleHealth() {
		return obstacleHealth;
	}

	public void setObstacleHealth(int obstacleHealth) {
		this.obstacleHealth = obstacleHealth;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public IDestroyingBehaviour getDestroyingBehaviour() {
		return destroyingBehaviour;
	}

	public void setDisappearingBehaviour(IDestroyingBehaviour destroyingBehaviour) {
		this.destroyingBehaviour = destroyingBehaviour;
	}
	public static void getNextCoord() {
	
		 if(getX()> 1100) {
			 setY(getY() + 70);
			 setX(0);
		 }else
			 setX(getX() + 100);

	}

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		Obstacle.x = x;
	}

	public static int getY() {
		return y;
	}

	public void setDestroyingBehaviour(IDestroyingBehaviour destroyingBehaviour) {
		this.destroyingBehaviour = destroyingBehaviour;
	}

	public static void setY(int y) {
		Obstacle.y = y;
	}
	
	public void hit() {
		if (getObstacleHealth()==1 && increasesScore) Player.player.scoreUpdater();
		destroyingBehaviour.hit(this);


		
	}

	public int getSpecialX() {
		return specialX;
	}

	public void setSpecialX(int specialX) {
		this.specialX = specialX;
	}

	public int getSpecialY() {
		return specialY;
	}

	public void setSpecialY(int specialY) {
		this.specialY = specialY;
	}
	
	public int getType() {
		return obstacleType;
	}

	public void setType(int obstacleType) {
		this.obstacleType = obstacleType;
	}
	
	public boolean isIncreasesScore() {
		return increasesScore;
	}
	
	public void explode(Player player) {
		
		player.setRemLives(player.getRemLives()-1);
		obstacleHealth--;
		if(player.remLives == 0){
			Player.playerDead = true;
		}
		
		
	}

}
