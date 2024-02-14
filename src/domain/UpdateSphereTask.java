package domain;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class UpdateSphereTask extends TimerTask {
    
	private Sphere sphere;
    
    public UpdateSphereTask(Sphere sphere) {
    	 this.sphere= sphere;
    }
    
	@Override
    public void run() {
        // update ball position
    	sphere.performMove(false,false);
    }

}
 