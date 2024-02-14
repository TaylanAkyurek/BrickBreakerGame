package saveLoad;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import domain.GameMap;
import domain.Player;


public class DatabaseAdapter implements IDatabaseAdapter {

	
	@Override
	public void save() throws IOException {
		ArrayList<Object> saveList = new ArrayList<Object>();
		saveList.add(GameMap.gameMap);
		saveList.add(Player.player);
		try(ObjectOutputStream oos = new ObjectOutputStream(
	            new FileOutputStream(new File("gameData.txt")))) {
	        oos.writeObject(saveList);
	        }
	}

	@Override
	public Object load() throws Exception {
		try(ObjectInputStream ois = new ObjectInputStream
				(Files.newInputStream(Paths.get("gameData.txt")))) {
			//System.out.println(GameMap.getPhantasm());
	        return ois.readObject();
	        }
	}
	

	



}
