package ui;

import javax.swing.JButton;
import javax.swing.JPanel;

import domain.GameMap;
import domain.Player;
import saveLoad.DatabaseAdapter;
import saveLoad.LoadSaveHandler;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryPanel extends JPanel{

	private JButton buildButton;
	private JButton loadButton;
	private LoadSaveHandler lshandler = new LoadSaveHandler();
	private static DatabaseAdapter databaseAdapter = new DatabaseAdapter();
	
	public EntryPanel() {
		
		buildButton = new JButton("Build");
		loadButton = new JButton("Load");
		setLayout(null);
		buildButton.setBounds(200, 200, 70, 25);
		loadButton.setBounds(200, 300, 70, 25);
		add(buildButton);
		add(loadButton);
		loadButton.setFocusable(false);
		
		
		loadButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	setVisible(false);
					lshandler.load();
					AnimationPanel animPanel = new AnimationPanel(GameMap.gameMap, Player.player);
					AnimatorMain.f.add(animPanel);
					animPanel.setVisible(true);
					animPanel.requestFocus();
				}
		    	
		});
		buildButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	setVisible(false);
		    	BuildingPanel buildPanel = new BuildingPanel();
				AnimatorMain.f.add(buildPanel);
				buildPanel.setVisible(true);
		    }
		});
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(1000,1500);
	}



}
