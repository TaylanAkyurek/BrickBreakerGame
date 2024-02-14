package ability;

import java.io.Serializable;
import java.util.ArrayList;

import domain.GameMap;
import domain.MoveHex;
import domain.Sphere;

public class Cannon implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private MoveHex moveHex;
	
	private ArrayList<Sphere> spheres = new ArrayList<>();
	
	public Cannon(int x, int y, int width, int height) {
		super();

		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}


	public int getX() {
		return x;
	}



	public ArrayList<Sphere> getSpheres() {
		return spheres;
	}


	public void setSpheres(ArrayList<Sphere> spheres) {
		this.spheres = spheres;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
	public void fire() {
		
		spheres.add(new Sphere(0, -10,x, y, 20));
		

	}
	
}
