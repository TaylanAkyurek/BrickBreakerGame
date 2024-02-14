package domain;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Obstacle.ExplosiveObstacle;
import Obstacle.FirmObstacle;
import Obstacle.GiftObstacle;
import Obstacle.Obstacle;
import Obstacle.ObstacleFactory;
import Obstacle.SimpleObstacle;
import ability.Ability;
import ability.AbilityFactory;
import ability.Cannon;
import ability.MagicalHex;
import ability.PhantasmExpansion;
import ability.UnstoppableSphere;
import ymir.DoubleAccel;
import ymir.InfiniteVoid;

public class GameMap implements Serializable {
	//OVERVIEW: This class maintains all the information about game data,
	//for example location of the ball or objects
	//Typical GameMap is the abstraction of the playground of game when you run it
	//AF(c)= {(c.allObsWithCoords[i](i represents a obstacle, point pair) | 0<= i < c.allObsWithCoords.size),(Sphere),(Phantasm)}
	//The rep invariant is:
	//c.simpleObstacles.size()>=75
	//c.firmObstacle.size()>=10
	//c.explosiveObstacles.size()>=5
	//c.giftObstacles.size()>=10
	//c.giftObstacles.abilitySet should cover all 4 abilities

	//if c.sphere.isUnstoppable() = false; this.uranusBox = null
	//else, this.uranusBox = UranusBox(obstacle.getSpecialX(),obstacle.getSpecialY(),20,5)

	//c.sphere.y <=500


	//1 = obstacle number = 0,0,0
	//2 = obstacle number = 75,10,5
	//3 = obstacle number = 80,20,10
	//4 = if c.sphere.getY() > 510, c.sphere.getVerticalSpeed() *= -1
	//5 = if c.sphere.getY() = 400, c.sphere != Null




	private static final long serialVersionUID = 1L;


	public static GameMap gameMap;

	private ArrayList<SimpleObstacle> simpleObstacles;
	private ArrayList<FirmObstacle> firmObstacles;
	private ArrayList<ExplosiveObstacle> explosiveObstacles;
	private ArrayList<GiftObstacle> giftObstacles;
	private ArrayList<Integer> indexFrozen;
	private boolean hasFrozen = false;
	private ArrayList<Obstacle> oldObstacles;

	private ArrayList<Obstacle> simpleAndFirm= new ArrayList<>();
	private ArrayList<Obstacle> allObstacles;
	private AbilityFactory abilityFactory;

	private Ability ability;
	private static Sphere sphere = new Sphere(13,13,80,630,20);
	private static Phantasm phantasm = new Phantasm(0,50,700,100,20);
	//private static Sphere sphere = new Sphere(5,5,515,600,20);
	//private static Phantasm phantasm = new Phantasm(0,485,630,100,20);
	private UranusBox uranusBox;
	private MoveCannon moveCannon;
	private MoveHex moveHex;
	private MoveSimpleAndFirmObstacles moveSimpleAndFirm ;
	private MoveExplosive moveExplosive;
	private List<BuildListener> buildListener = new ArrayList<BuildListener>();

	private HashMap<Obstacle , Point> allObsWithCoords;
	private Point nextCoord;


	private Cannon cannon1;
	private Cannon cannon2;
	
	
	private DoubleAccel doubleAccel = new DoubleAccel();
	private InfiniteVoid infiniteVoid = new InfiniteVoid();

	private PhantasmExpansion phantasmExpansion;
	private MagicalHex magicalHex;
	private UnstoppableSphere unstoppableSphere;

	private int expansionCount;
	private int hexCount;
	private int unstoppableCount;

	public GameMap(int simpleNum, int firmNum, int explosiveNum, int giftNum) throws Exception {


		phantasmExpansion = new PhantasmExpansion();
		magicalHex = new MagicalHex();
		unstoppableSphere = new UnstoppableSphere();
		this.uranusBox = null;
		indexFrozen = infiniteVoid.getIndexFrozen();

		System.out.println(giftNum);
		nextCoord = new Point(10,10);
		allObsWithCoords = new HashMap<>();
		ObstacleFactory factory = ObstacleFactory.getInstance();
		simpleObstacles = new ArrayList<SimpleObstacle>();

		for(int i = 0; i <simpleNum; i++) {
			if(simpleNum >=75) {
				simpleObstacles.add((SimpleObstacle) factory.getObstacleType(0)); 
			}
			else {
				throw new Exception();
			}
		}

		firmObstacles = new ArrayList<FirmObstacle>();
		for(int i = 0; i <firmNum; i++) {
			if(firmNum >=10) {
				firmObstacles.add((FirmObstacle) factory.getObstacleType(1)); 
			}
			else {
				throw new Exception();
			}
		}

		explosiveObstacles = new ArrayList<ExplosiveObstacle>();
		for(int i = 0; i <explosiveNum; i++) {
			if(explosiveNum >=5) {
				explosiveObstacles.add((ExplosiveObstacle) factory.getObstacleType(2)); 
			}
			else {
				throw new Exception();
			}
		}
		giftObstacles = new ArrayList<GiftObstacle>();
		for(int i = 0; i <giftNum; i++) {
			//		if(explosiveNum >=5) {
			giftObstacles.add((GiftObstacle) factory.getObstacleType(3)); 
			//	}
			//else {
			//	throw new Exception();
			//	}
		}
		allObstacles = new ArrayList<Obstacle>();

		allObstacles.addAll(simpleObstacles);
		allObstacles.addAll(firmObstacles);
		allObstacles.addAll(explosiveObstacles);
		allObstacles.addAll(giftObstacles);

		simpleAndFirm.addAll(simpleObstacles);
		simpleAndFirm.addAll(firmObstacles);

		Collections.shuffle(allObstacles);

		for (int i = 0; i< allObstacles.size(); i++){

			nextCoord.x = Obstacle.getX();
			nextCoord.y = Obstacle.getY();

			allObstacles.get(i).setSpecialX(Obstacle.getX());
			allObstacles.get(i).setSpecialY(Obstacle.getY());

			allObsWithCoords.put(allObstacles.get(i),new Point(Obstacle.getX(),Obstacle.getY()));

			Obstacle.getNextCoord();

		}

		moveSimpleAndFirmInit();

		moveExplosiveInit();
		
		expansionCount = phantasmExpansion.getAbilityCount();
		hexCount = magicalHex.getAbilityCount();
		unstoppableCount = unstoppableSphere.getAbilityCount();
	}



	public Cannon getCannon1() {
		return cannon1;
	}



	public void setCannon1(Cannon cannon1) {
		this.cannon1 = cannon1;
	}


	public Cannon getCannon2() {
		return cannon2;
	}



	public void setCannon2(Cannon cannon2) {
		this.cannon2 = cannon2;
	}


	public ArrayList<SimpleObstacle> getSimpleObstacles() throws Exception {

		if(simpleObstacles.size() >=75) {
			return simpleObstacles;
		}
		else {
			throw new Exception();
		}
	}



	public UranusBox getUranusBox() {
		return uranusBox;
	}



	public void setUranusBox(UranusBox uranusBox) {
		this.uranusBox = uranusBox;
	}



	public ArrayList<FirmObstacle> getFirmObstacles() throws Exception {

		if(firmObstacles.size() >=10) {
			return firmObstacles;
		}
		else {
			throw new Exception();
		}
	}



	public ArrayList<ExplosiveObstacle> getExplosiveObstacles() throws Exception {

		if(explosiveObstacles.size() >=5) {
			return explosiveObstacles;
		}
		else {
			throw new Exception();
		}

	}

	public ArrayList<GiftObstacle> getGiftObstacles() throws Exception {
		if(giftObstacles.size() >=10) {
			return giftObstacles;
		}
		else {
			throw new Exception();
		}
	}



	public void setGiftObstacles(ArrayList<GiftObstacle> giftObstacles) {
		this.giftObstacles = giftObstacles;
	}


	public ArrayList<Obstacle> getAllObstacles() {
		return allObstacles;
	}




	public static Phantasm getPhantasm() {
		return phantasm;
	}

	public static void setPhantasm(Phantasm phantasm) {
		GameMap.phantasm = phantasm;
	}



	public static Sphere getSphere() {
		if (sphere.getY() > 1000) {
			sphere = null;
		}
		return sphere;
	}

	public static void setSphere(Sphere sphere) {
		GameMap.sphere = sphere;
	}

	public List<BuildListener> getBuildListener() {
		return buildListener;
	}


	public void addBuildListener(BuildListener bl) {
		buildListener.add(bl);
	}

	public void publishBuildEvent() {
		for(BuildListener l : buildListener) {
			l.build(this);
		}
	}



	public HashMap<Obstacle, Point> getAllObsWithCoords() {
		return allObsWithCoords;
	}



	public void setAllObsWithCoords(HashMap<Obstacle, Point> allObsWithCoords) {
		this.allObsWithCoords = allObsWithCoords;
	}

	public boolean repOk() {
		// EFFECTS: Returns true if the rep invariant holds
		// for this; otherwise returns false. 

		if(simpleObstacles.size()<75) {
			return false;
		}
		if(firmObstacles.size()<10) {
			return false;
		}
		if(explosiveObstacles.size()<5) {
			return false;
		}

		return true;

	}

	public boolean checkCoord() {


		for (Map.Entry<Obstacle, Point> obs : allObsWithCoords.entrySet()) {

			if(obs.getKey().getSpecialX() != obs.getValue().x) {
				return false;
			}

			if(obs.getKey().getSpecialY() != obs.getValue().y) {
				return false;
			}

		}

		return true;
	}

	//	public void getAndUseAbility() {
	//		
	//		ability.setGameMap(this);
	//		
	//	    ability.useAbility();
	//	}

	public void moveCannon() {

		moveCannon = new MoveCannon();

		moveCannon.setCannon1(cannon1);

		moveCannon.setCannon2(cannon2);

		moveCannon.setPhantasm(phantasm);


		moveCannon.move();

	}


	public void moveHex() {

		moveHex = new MoveHex();

		moveHex.setCannon1(cannon1);
		moveHex.setCannon2(cannon2);

		moveHex.move();


	}
	public void moveSimpleAndFirmInit() {

		moveSimpleAndFirm = new MoveSimpleAndFirmObstacles();

		moveSimpleAndFirm.setSimpleAndFirmObstacles(new ArrayList<Obstacle>());

		moveSimpleAndFirm.getSimpleAndFirmObstacles().addAll(simpleObstacles);

		moveSimpleAndFirm.getSimpleAndFirmObstacles().addAll(firmObstacles);


	}



	public void moveSimpleAndFirm() {


		moveSimpleAndFirm.move();


	}
	public void moveExplosiveInit() {

		moveExplosive = new MoveExplosive();

		moveExplosive.setExplosiveObstacles(new ArrayList<ExplosiveObstacle>());
		moveExplosive.getExplosiveObstacles().addAll(explosiveObstacles);
		moveExplosive.setAngle(10);
		moveExplosive.setR(3);

	}



	public void moveExplosive() {


		moveExplosive.move();


	}

	public PhantasmExpansion getPhantasmExpansion() {
		return phantasmExpansion;
	}



	public UnstoppableSphere getUnstoppableSphere() {
		return unstoppableSphere;
	}



	public MagicalHex getMagicalHex() {
		return magicalHex;
	}
	
	public InfiniteVoid getInfiniteVoid() {
		return infiniteVoid;
	}



	public int getPhantasmExpansionCount() {
		return expansionCount;
	}



	public int getUnstoppableSphereCount() {
		return unstoppableCount;
	}



	public int getMagicalHexCount() {
		return hexCount;
	}
	
	public void setExpansionCount(int expansionCount) {
		this.expansionCount = expansionCount;
	}


	public void setHexCount(int hexCount) {
		this.hexCount = hexCount;
	}



	public void setUnstoppableCount(int unstoppableCount) {
		this.unstoppableCount = unstoppableCount;
	}



	public Ability createAbility() {
		ability = getUranusBox().getAbility();
		return ability;
	}

	public Ability getGameMapAbility() {
		return ability;
	}

	public ArrayList<Obstacle> getSimpleAndFirm(){



		return simpleAndFirm;


	}

	public void obstacleCollision(int j){

		//if(getAllObstacles().get(j) instanceof ExplosiveObstacle) {


		//((ExplosiveObstacle)getAllObstacles().get(j)).setClockWise(!((ExplosiveObstacle)getAllObstacles().get(j)).isClockWise());;

		//}
		//else {
		getAllObstacles().get(j).setSpeed(getAllObstacles().get(j).getSpeed()*-1);

		getAllObstacles().get(j).setSpecialX(getAllObstacles().get(j).getSpecialX() + getAllObstacles().get(j).getSpeed());
		//}
	}

	public void slowObstacles(int i) {

		getAllObstacles().get(i).setSpeed(getAllObstacles().get(i).getSpeed()*-1);
	}


	public void collideHex1(int i) {
		getCannon1().getSpheres().get(i).setVerticalSpeed(getCannon1().getSpheres().get(i).getVerticalSpeed()*-1);
	}
	public void collideHex2(int i) {
		getCannon2().getSpheres().get(i).setVerticalSpeed(getCannon2().getSpheres().get(i).getVerticalSpeed()*-1);
	}
	
	public DoubleAccel getDoubleAccel() {
		return doubleAccel;
	}



	public void setDoubleAccel(DoubleAccel doubleAccel) {
		this.doubleAccel = doubleAccel;
	}
	
	public ArrayList<Integer> getIndexFrozen() {
		return indexFrozen;
	}



	public void setIndexFrozen(ArrayList<Integer> indexFrozen) {
		this.indexFrozen = indexFrozen;
	}



	public boolean isHasFrozen() {
		return hasFrozen;
	}



	public void setHasFrozen(boolean hasFrozen) {
		this.hasFrozen = hasFrozen;
	}



	public ArrayList<Obstacle> getOldObstacles() {
		return oldObstacles;
	}



	public void setOldObstacles(ArrayList<Obstacle> oldObstacles) {
		this.oldObstacles = oldObstacles;
	}

}







