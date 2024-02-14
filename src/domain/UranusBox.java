package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import ability.Ability;
import ability.AbilityFactory;
import ability.ChanceGiving;
import ability.MagicalHex;
import ability.PhantasmExpansion;
import ability.UnstoppableSphere;

public class UranusBox implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int size;
	private int x;
	private int y;
	private Ability ability;
	private MoveUranusBox moveUranusBox = new MoveUranusBox(); 
	private static ArrayList<Integer> abilities = new ArrayList<Integer>();
	
	public UranusBox(int x, int y, int size, int speed) {
		super();
		this.size = size;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	private int speed;
	private MoveBehaviour moveBehaviour;
	
	public MoveBehaviour getMoveBehaviour() {
		return moveBehaviour;
	}

	public void setMoveBehaviour(MoveBehaviour moveBehaviour) {
		this.moveBehaviour = moveBehaviour;
	}

	public int getSize() {
		if (size > 0) {
			return size;
		}
		return -1;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	public int getSpeed() {
		if (speed > 0) {
			return speed;
		}
		return -1;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Ability getAbility() {
		return AbilityFactory.getAbility();
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}
	
	public void performMove() {
		moveUranusBox.setUranusBox(this);
		moveUranusBox.move();
	}
	
	
	
	
}
