package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseResume implements ActionListener {

	private Object lock = new Object();
	public volatile boolean paused = true;

	public PauseResume() {
		counter.start();
	}

	private Thread counter = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true) {
				work();
			}
		}
	});

	private void work() {
		done();
	}

	private void done() {
			AnimationPanel.getStartButton().setText("Start");
		paused = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AnimationPanel.getTimer().start();
		AnimationPanel.getTimer2().start();
		AnimationPanel.getTimer3().start();
		AnimationPanel.getTimer4().start();
		AnimationPanel.getTimer5().start();
		AnimationPanel.getTimer6().start();
		AnimationPanel.getTimer7().start();
		AnimationPanel.getTimer8().start();
		AnimationPanel.getTimer9().start();

		paused = !paused;
		AnimationPanel.getStartButton().setText(paused ? "Resume" : "Pause");
		if (paused) {
			AnimationPanel.getTimer().stop();
			AnimationPanel.getTimer2().stop();
			AnimationPanel.getTimer3().stop();
			AnimationPanel.getTimer4().stop();
			AnimationPanel.getTimer5().stop();
			AnimationPanel.getTimer6().stop();
			AnimationPanel.getTimer7().stop();
			AnimationPanel.getTimer8().stop();
			AnimationPanel.getTimer9().stop();
			
		}
		synchronized (lock) {
			lock.notifyAll();
		}
	}
}