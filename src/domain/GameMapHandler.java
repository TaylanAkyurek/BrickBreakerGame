package domain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Obstacle.ExplosiveObstacle;
import Obstacle.FirmObstacle;
import Obstacle.GiftObstacle;
import Obstacle.Obstacle;
import Obstacle.SimpleObstacle;
import ability.Ability;
import ability.Cannon;
import ability.MagicalHex;
import ability.PhantasmExpansion;
import ability.UnstoppableSphere;
import ymir.DoubleAccel;
import ymir.InfiniteVoid;

public class GameMapHandler {

	
	
	private static GameMap gameMap = GameMap.gameMap;

	public GameMapHandler(GameMap gameMap) {
		super();
		
		GameMap.gameMap = gameMap;
	}

	public Cannon getCannon1() {

		return gameMap.getCannon1();
	}



	public void setCannon1(Cannon cannon1) {
		
		
		gameMap.setCannon1(cannon1);
	}

	
	public Cannon getCannon2() {
		
		return gameMap.getCannon2();

	}



	public void setCannon2(Cannon cannon2) {
		
		gameMap.setCannon2(cannon2);

	}


	public ArrayList<SimpleObstacle> getSimpleObstacles() throws Exception {
		return gameMap.getSimpleObstacles();
	}



	public UranusBox getUranusBox() {
		
		return gameMap.getUranusBox();
	}



	public void setUranusBox(UranusBox uranusBox) {
		
		gameMap.setUranusBox(uranusBox);
	}



	public ArrayList<FirmObstacle> getFirmObstacles() throws Exception {

		
		return gameMap.getFirmObstacles();
	}



	public ArrayList<ExplosiveObstacle> getExplosiveObstacles() throws Exception {
		
		return gameMap.getExplosiveObstacles();
		
	}

	public ArrayList<GiftObstacle> getGiftObstacles() throws Exception {
		
		return gameMap.getGiftObstacles();
	}



	public void setGiftObstacles(ArrayList<GiftObstacle> giftObstacles) {
		
		gameMap.setGiftObstacles(giftObstacles);
	}


	public ArrayList<Obstacle> getAllObstacles() {
		
		return gameMap.getAllObstacles();
	}
	
	


	public static Phantasm getPhantasm() {
		
		return gameMap.getPhantasm();
	}
	
	public static void setPhantasm(Phantasm phantasm) {
	}



	public static Sphere getSphere() {
		return gameMap.getSphere();
	}
	
	public static void setSphere(Sphere sphere) {
	}

	public List<BuildListener> getBuildListener() {
		
		return gameMap.getBuildListener();
	}

	
	public void addBuildListener(BuildListener bl) {
		gameMap.addBuildListener(bl);
	}
	
	public void publishBuildEvent() {
		
		gameMap.publishBuildEvent();
	}



	public HashMap<Obstacle, Point> getAllObsWithCoords() {
		
		return gameMap.getAllObsWithCoords();
	}



	public void setAllObsWithCoords(HashMap<Obstacle, Point> allObsWithCoords) {
	}
	
	
	public boolean checkCoord() {
		return gameMap.checkCoord();
		
	}
	
//	public void getAndUseAbility() {
//		
//		ability.setGameMap(this);
//		
//	    ability.useAbility();
//	}
	
	public void moveCannon() {
		gameMap.moveCannon();
		
	}
	
	public void moveHex() {
		gameMap.moveHex();
		
	}
	public void moveSimpleAndFirmInit() {
		gameMap.moveSimpleAndFirmInit();
		
	}

	
	
	public void moveSimpleAndFirm() {
		
		gameMap.moveSimpleAndFirm();

		
	}
	public void moveExplosiveInit() {
		
		gameMap.moveExplosiveInit();

	}

	
	
	public void moveExplosive() {
		
		
		gameMap.moveExplosive();
		
	}

	public PhantasmExpansion getPhantasmExpansion() {
		
		return gameMap.getPhantasmExpansion();
	}



	public UnstoppableSphere getUnstoppableSphere() {
		
		return gameMap.getUnstoppableSphere();
	}



	public MagicalHex getMagicalHex() {
		
		return gameMap.getMagicalHex();
	}
	
public DoubleAccel getDoubleAccel() {
		
		return gameMap.getDoubleAccel();
	}
	
	public Ability createAbility() {
		
		return gameMap.createAbility();
	}
	
	public Ability getGameMapAbility() {
		return gameMap.getGameMapAbility();
	}
	
	public  ArrayList<Integer> getIndexFrozen() {
		return gameMap.getIndexFrozen();
	}
	
	public  InfiniteVoid getInfiniteVoid() {
		return gameMap.getInfiniteVoid();
	}
	
	public ArrayList<Obstacle> getSimpleAndFirm(){
		
		return gameMap.getSimpleAndFirm();
		

		
	}
	
	public boolean isHasFrozen() {
		return gameMap.isHasFrozen();
	}
	
	public void obstacleCollision(int j){
		gameMap.obstacleCollision(j);
	}
	
	public void slowObstacles(int i){
		gameMap.slowObstacles(i);
	}
	
	public void collideHex1(int i) {
		gameMap.collideHex1(i);
	}
	public void collideHex2(int i) {
		gameMap.collideHex2(i);
	}

}	
	
