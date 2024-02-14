package domain;


public class SphereHandler {

		
	private Sphere sphere;
	
	public SphereHandler(Sphere sphere) {
		
		this.sphere = sphere;
	}
	
	public void move() {
		
		sphere.performMove(false, false);
	}
	

	public void moveObjUp() {
		
		sphere.performMove(true, false);
	}
	public void moveObjSide() {
		
		sphere.performMove(false, true);
	}

}
