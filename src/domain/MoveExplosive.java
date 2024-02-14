package domain;

import java.io.Serializable;
import java.util.ArrayList;

import Obstacle.ExplosiveDestroying;
import Obstacle.ExplosiveObstacle;
import Obstacle.Obstacle;

public class MoveExplosive implements MoveBehaviour, Serializable{

	private static final long serialVersionUID = 1L;
	private int angle;
	private ArrayList<ExplosiveObstacle> explosiveObstacles;
	private boolean isClockwise;
	private int r;
	
	
	
	public MoveExplosive() {
		super();
	}

	public ArrayList<ExplosiveObstacle> getExplosiveObstacles() {
		return explosiveObstacles;
	}

	public void setExplosiveObstacles(ArrayList<ExplosiveObstacle> explosiveObstacles) {
		this.explosiveObstacles = explosiveObstacles;
	}

	@Override
	public void move(boolean objUp, boolean objSide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		int x, y;
		double rads = 0;
		
		int newX = 0,newY = 0;
		
		
		for (int i = 0; i<explosiveObstacles.size(); i++) {
			
			x = explosiveObstacles.get(i).getSpecialX();
			y = explosiveObstacles.get(i).getSpecialY();
			
			if(explosiveObstacles.get(i).isExploded() == false) {
				rads = Math.toRadians(explosiveObstacles.get(i).getAngle());
			
				newX= Math.round((float)(x+Math.cos(rads)*r));
		 	
				newY=Math.round((float)(y+Math.sin(rads)*r));
			
				explosiveObstacles.get(i).setSpecialX(newX);
			
				explosiveObstacles.get(i).setSpecialY(newY);
			
				explosiveObstacles.get(i).arrangeAngle();
			
			}
			else {
				
				explosiveObstacles.get(i).setSpecialY(y+10);

			}
		}
		
		
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

}
