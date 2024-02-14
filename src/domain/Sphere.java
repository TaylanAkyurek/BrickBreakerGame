package domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

import javax.swing.JFrame;

import ability.Ability;

public class Sphere implements Serializable{
	
	private static final long serialVersionUID = 1L;

	MoveBehaviour moveBehaviour = new MoveSphere(this);
	
	int horizontalSpeed;
	int verticalSpeed;
	private int x;
	private int y;
	private int r;
	private Color ballColor;
	private boolean unstoppable = false;
	private boolean slow = false;
	
	
	public boolean isUnstoppable() {
		return unstoppable;
	}

	public void setUnstoppable(boolean unstoppable) {
		this.unstoppable = unstoppable;
	}

	private boolean visibility = true;
	
	public Sphere(int horizontalSpeed, int verticalSpeed,int x, int y, int r) {
		super();
		this.horizontalSpeed = horizontalSpeed;
		this.verticalSpeed = -verticalSpeed;
		this.setX(x);
		this.setY(y);
		this.setR(r);

	}
	
	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public int getHorizontalSpeed() {
		return horizontalSpeed;
	}

	public void setHorizontalSpeed(int horizontalSpeed) {
		this.horizontalSpeed = horizontalSpeed;
	}

	public int getVerticalSpeed() {
		return verticalSpeed;
	}

	public void setVerticalSpeed(int verticalSpeed) {
		this.verticalSpeed = verticalSpeed;
	}

	public Color getBallColor() {
		return ballColor;
	}

	public int getX() {
		
		
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		
		if(y > 490) {
			 visibility = false;
			}
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	

	public void setBallColor(Color ballColor) {
		this.ballColor = ballColor;
	}

	
	public void performMove(boolean objUp, boolean objSide) {
		moveBehaviour.move(objUp,objSide);
	}

	public MoveBehaviour getMoveBehaviour() {
		return moveBehaviour;
	}

	public void setMoveBehaviour(MoveBehaviour moveBehaviour) {
		this.moveBehaviour = moveBehaviour;
	}
	
	public boolean isSlow() {
		return slow;
	}

	public void setSlow(boolean slow) {
		this.slow = slow;
	}
	
}
