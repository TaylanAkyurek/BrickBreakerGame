package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import Obstacle.Obstacle;

public class MoveSimpleAndFirmObstacles implements MoveBehaviour, Serializable {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Obstacle> simpleAndFirmObstacles;
	
	public ArrayList<Obstacle> getSimpleAndFirmObstacles() {
		return simpleAndFirmObstacles;
	}

	public void setSimpleAndFirmObstacles(ArrayList<Obstacle> simpleAndFirmObstacles) {
		this.simpleAndFirmObstacles = simpleAndFirmObstacles;
	}

	@Override
	public void move(boolean objUp, boolean objSide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

		
		for(int i = 0; i < simpleAndFirmObstacles.size(); i++) {
			
			if(simpleAndFirmObstacles.get(i).isMove()) {
				
					
				simpleAndFirmObstacles.get(i).setSpecialX(simpleAndFirmObstacles.get(i).getSpecialX()+ simpleAndFirmObstacles.get(i).getSpeed());

			}
		
		}
		
	}
	
	
	
	
}