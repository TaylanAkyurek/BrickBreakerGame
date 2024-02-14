package saveLoad;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import domain.GameMap;
import domain.Player;
import ui.AnimationPanel;
import ui.AnimatorMain;
import ui.EntryPanel;


public class LoadSaveHandler{
	
	private static DatabaseAdapter databaseAdapter = new DatabaseAdapter();

	public void save() {
		try {
			databaseAdapter.save();
			System.out.println(Player.player.remLives);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		
	}
	public void load() {
		try {
			ArrayList<Object> loadList = (ArrayList<Object>) databaseAdapter.load();
			GameMap.gameMap = (GameMap) loadList.get(0);
			Player.player = (Player) loadList.get(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
