package ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AnimatorMain {

	
	public static JFrame f ;
	public static EntryPanel entryPanel = new EntryPanel();
	
	public static void main(String args[]) {
    	
	       
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
     
        
//        TimerTask timerTask = new UpdateSphereTask();     
//        //running timer task as daemon thread
//        Timer timer = new Timer(true);
//        timer.scheduleAtFixedRate(timerTask, 0, 100);
//        System.out.println(Thread.currentThread().getName()+" TimerTask started");
//        
//        if(buildPanel.getGameMap() != null) {
//        	timerTask = new UpdateSphereTask(buildPanel.getGameMap().getSphere()); 
//        }
//        //cancel after sometime
//        try {
//        	Thread.sleep(100);
//        } catch (InterruptedException e) {
//        	e.printStackTrace();
//        }
       
	}
        
        
        private static void createAndShowGUI() {
        	
        	System.out.println(Thread.currentThread().getName() +" Created GUI "+
        	        SwingUtilities.isEventDispatchThread());
        	
        	f = new JFrame("Swing Animation Demo");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(entryPanel);
        	f.pack();
        	f.setVisible(true);
        	f.setFocusable(true);




		}
}

