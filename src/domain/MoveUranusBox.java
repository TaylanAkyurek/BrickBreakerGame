package domain;

import java.io.Serializable;

public class MoveUranusBox implements MoveBehaviour, Serializable {
	
	private static final long serialVersionUID = 1L;
	protected UranusBox uranusBox;

	@Override
	public void move() {
		// TODO Auto-generated method stub
		uranusBox.setY(uranusBox.getY()+uranusBox.getSpeed());
		
	}
	public UranusBox getUranusBox() {
		return uranusBox;
	}
	public void setUranusBox(UranusBox uranusBox) {
		this.uranusBox = uranusBox;
	}
	@Override
	public void move(boolean objUp, boolean objSide) {
		// TODO Auto-generated method stub
		
	}

}
