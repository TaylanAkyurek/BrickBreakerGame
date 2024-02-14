package ui;


import java.awt.Color; 

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent; 


import java.util.Random;


import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Obstacle.GiftObstacle;
import Obstacle.Obstacle;

import ability.Ability;
import ability.AbilityHandler;
import ability.UnstoppableSphere;
import ability.MagicalHex;
import ability.PhantasmExpansion;
import ability.ChanceGiving;
import domain.*;
import saveLoad.LoadSaveHandler;

import ymir.YmirHandler;



public class AnimationPanel extends JPanel implements KeyListener, MouseListener, MouseMotionListener{

	private GameMapHandler gameMapController;
	private PlayerHandler playerController;
	private YmirHandler ymirController;
	private GameMap gameMap;
	private Phantasm phantasm;
	private Ability ability;
	private SphereHandler sphereHandler;
	private AbilityHandler abilityHandler = new AbilityHandler(ability);
	private JButton saveButton;
	private static JButton startButton;
	private JButton expansionButton;
	private JButton hexButton;
	private JButton unstoppableButton;
	private LoadSaveHandler lshandler = new LoadSaveHandler();
	private PauseResume pauseResume = new PauseResume();
	private static Timer timer;
	private static Timer timer2;
	private static Timer timer3;
	private static Timer timer4;
	private static Timer timer5;
	private static Timer timer6;
	private static Timer timer7;
	private static Timer timer8;
	private static Timer timer9;

	private int mouseClickCounter = 0;
	private boolean secondClickObstacle = false;
	private int k = 0;

	private BufferedImage simpleObsImage;
	private BufferedImage heartImage;
	private BufferedImage firmObsImage;
	private BufferedImage explosiveObsImage;
	private BufferedImage giftObsImage;
	private BufferedImage sphereImage;
	private BufferedImage phantasmImage;
	private BufferedImage obsImage;
	private BufferedImage gameOverImage;
	private BufferedImage frozenObsImage;

	private int angle = 10;

	private JLabel scoreLabel;
	private JLabel remainingLivesLabel;
	private JLabel scoreNumber;




	public AnimationPanel(GameMap gameMap, Player player) {

		this.gameMap = gameMap;
		this.gameMapController = new GameMapHandler(gameMap);
		this.playerController = new PlayerHandler();
		this.ymirController = new YmirHandler();
		this.phantasm = gameMapController.getPhantasm();
		this.sphereHandler = new SphereHandler(gameMapController.getSphere());
		Dimension dim = this.getPreferredSize();
		this.setPreferredSize(dim);
		setLayout(null);
		saveButton = new JButton("Save");
		saveButton.setBounds(355,450,70,25);
		add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				lshandler.save();
			}
		});
		saveButton.setFocusable(false);
		startButton = new JButton("Start");
		startButton.setBounds(285,450,70,25);
		add(startButton);
		startButton.addActionListener(pauseResume);
		startButton.setFocusable(false);

		expansionButton = new JButton("Phantasm Expansion");
		expansionButton.setBounds(285,500,70,25);
		add(expansionButton);
		expansionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				abilityHandler.activateExpansion();
			}
		});
		expansionButton.setFocusable(false);

		hexButton = new JButton("Magical Hex");
		hexButton.setBounds(355,500,70,25);
		add(hexButton);
		hexButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				abilityHandler.activateHex();
			}
		});
		hexButton.setFocusable(false);

		unstoppableButton = new JButton("Unstoppable Sphere");
		unstoppableButton.setBounds(425,500,70,25);
		add(unstoppableButton);
		unstoppableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				abilityHandler.activateUnstoppable();
			}
		});
		unstoppableButton.setFocusable(false);

		this.scoreLabel = new JLabel("Score: ");
		scoreLabel.setBounds(dim.width - 300, 10, 210, 20);
		this.remainingLivesLabel = new JLabel("RemainingLives: ");
		remainingLivesLabel.setBounds(dim.width - 300, 30, 210, 20);
		add(scoreLabel);
		add(remainingLivesLabel);
		this.scoreNumber = new JLabel("0");
		scoreNumber.setBounds(dim.width - 240, 10, 210, 20);
		add(scoreNumber);
		this.scoreNumber.setText(playerController.getScore());


		try {
			simpleObsImage = ImageIO.read(new File("src/nfs-images/simple_obstacle.png"));
			firmObsImage = ImageIO.read(new File("src/nfs-images/firm_obstacle_empty.png"));
			explosiveObsImage = ImageIO.read(new File("src/nfs-images/explosive_obstacle.png"));
			giftObsImage = ImageIO.read(new File("src/nfs-images/gift_obstacle.png"));
			sphereImage = ImageIO.read(new File("src/nfs-images/sphere.png"));
			phantasmImage = ImageIO.read(new File("src/nfs-images/phantasm.png"));
			heartImage = ImageIO.read(new File("src/nfs-images/heart.png"));
			gameOverImage = ImageIO.read(new File("src/nfs-images/game_over.png"));
			frozenObsImage = ImageIO.read(new File("src/nfs-images/frozen_obstacle.png"));

			/*
						simpleObsImage = ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\simple_obstacle.png"));
			firmObsImage = ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\firm_obstacle_empty.png"));
			explosiveObsImage = ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\explosive_obstacle.png"));
			giftObsImage = ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\gift_obstacle.png"));
			sphereImage = ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\sphere.png"));
			phantasmImage = ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\phantasm.png"));
			heartImage = ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\heart.png"));
			gameOverImage = ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\game_over.png"));
			 */

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addMouseListener(this);

		timer = new Timer(2, e-> {


			if(gameMapController.getCannon1() != null) {
				gameMapController.moveHex();
			}
			repaint();} );

		timer2 = new Timer(1000, e-> {
			if(gameMapController.getCannon1() != null) {
				gameMapController.getCannon1().fire();
				gameMapController.getCannon2().fire();
				gameMapController.getMagicalHex().deactivate();
			}
			;} );


		timer5 = new Timer(100, e-> {


			Random random = new Random();
			int x ;



			for(int i = 0; i < gameMapController.getAllObstacles().size();i++) {
				x = random.nextInt(20);
				if(x == 8) {

					gameMapController.slowObstacles(i);
				}


			}
			gameMapController.moveSimpleAndFirm();
			gameMapController.moveExplosive();


			mouseClickCounter = 5;

			;} );


		timer3 = new Timer(1000, e-> {
			if(phantasm.isExpanded() == true) {
				gameMapController.getPhantasmExpansion().deactivate();
			}
			;}
				);

		timer4 = new Timer(1000, e-> {
			if(gameMapController.getSphere().isUnstoppable() == true) {
				gameMapController.getUnstoppableSphere().deactivate();
			}
			;}
				);


		timer6 = new Timer(1000, e-> {

			playerController.setTimeElapsed(playerController.getTimeElapsed() + 1);


			this.scoreNumber.setText(playerController.getScore());
			if (playerController.getPlayerDead()) {
				playerController.decreaseRemLives();
				startButton.doClick();

				phantasm.setX(dim.width/2 );
				gameMapController.getSphere().setX(phantasm.getX()+ phantasm.getL()/2);
				gameMapController.getSphere().setY(phantasm.getY()-35);


			}

			playerController.setPlayerDead(false);

			;}
				);

		timer7 = new Timer(30000, e-> {
			if (ymirController.isActive()) {
				try {
					ymirController.useYmir();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			;}
				);

		timer8 = new Timer(1000, e-> {

			if(gameMapController.getSphere().isSlow() == true) {
				gameMapController.getDoubleAccel().deactivate();
			}
			;}
				);

		timer9 = new Timer(1000, e-> {

			if(gameMapController.isHasFrozen()) {
				gameMapController.getInfiniteVoid().deactivate();


			}
			;}
				);
	}




	public static JButton getStartButton() {
		return startButton;
	}


	public static Timer getTimer() {
		return timer;
	}
	public static Timer getTimer2() {
		return timer2;
	}

	public static Timer getTimer3() {
		return timer3;
	}

	public static Timer getTimer4() {
		return timer4;
	}

	public static Timer getTimer5() {
		return timer5;
	}
	public static Timer getTimer6() {
		return timer6;
	}

	public static Timer getTimer7() {
		return timer7;
	}

	public static Timer getTimer8() {
		return timer8;
	}


	public static Timer getTimer9() {
		return timer9;
	}

	public static void setTimer5(Timer timer5) {
		AnimationPanel.timer5= timer5;
	}



	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		sphereHandler.move();
		for (int i = 0; i<playerController.getRemLives(); i++){
			g.drawImage(heartImage,820 + (i*30),30,30,30,this);

		}
		if(playerController.getRemLives() == 0){
			g.drawImage(gameOverImage,300,100,500,500,this);
		}
		BufferedImage image = phantasmImage;
		double rads = Math.toRadians(angle);
		double sin = Math.abs(Math.sin(rads));
		double cos = Math.abs(Math.cos(rads));
		int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
		int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
		BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
		AffineTransform at = new AffineTransform();
		Rotator.Rotate(at,w,h,rads,image);
		AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		rotateOp.filter(image,rotatedImage);         

		g.setColor(gameMapController.getSphere().getBallColor());

		g.drawImage(sphereImage,gameMapController.getSphere().getX(), gameMapController.getSphere().getY(), gameMapController.getSphere().getR(), gameMapController.getSphere().getR(),this);


		g.setColor(phantasm.getPhantasmColor());

		g.drawImage(rotatedImage,phantasm.getX(),phantasm.getY(),phantasm.getL(), phantasm.getH(),this);


		Rectangle ballRectangle = new Rectangle(gameMapController.getSphere().getX(), gameMapController.getSphere().getY(), gameMapController.getSphere().getR(), gameMapController.getSphere().getR());
		Rectangle phantasmRectangle = new Rectangle(phantasm.getX(),phantasm.getY(),phantasm.getL(), phantasm.getH());

		if(gameMapController.getUranusBox()!=null) {

			Rectangle uranusBoxRect = new Rectangle(gameMapController.getUranusBox().getX(), gameMapController.getUranusBox().getY(), gameMapController.getUranusBox().getSize(), gameMapController.getUranusBox().getSize());

			if (gameMapController.getGameMapAbility().getClass() == UnstoppableSphere.class)
				g.setColor(Color.YELLOW);
			else if (gameMapController.getGameMapAbility().getClass() == MagicalHex.class)
				g.setColor(Color.BLUE);
			else if (gameMapController.getGameMapAbility().getClass() == PhantasmExpansion.class)
				g.setColor(Color.GREEN);
			else if (gameMapController.getGameMapAbility().getClass() == ChanceGiving.class)
				g.setColor(Color.RED);

			g.fillRect(gameMapController.getUranusBox().getX(),gameMapController.getUranusBox().getY(),gameMapController.getUranusBox().getSize(), gameMapController.getUranusBox().getSize());


			gameMapController.getUranusBox().performMove();


			if(phantasmRectangle.intersects(uranusBoxRect)) {


				ability.setGameMap(gameMap);
				gameMapController.setUranusBox(null);
				ability.getAbility();

			}

		}

		if(gameMapController.getCannon1() != null) {

			g.setColor(Color.BLACK);

			g.fillRect(gameMapController.getCannon1().getX(),gameMapController.getCannon1().getY(),gameMapController.getCannon1().getHeight(), gameMapController.getCannon1().getWidth());


			g.setColor(Color.BLACK);

			g.fillRect(gameMapController.getCannon2().getX(),gameMapController.getCannon2().getY(),gameMapController.getCannon2().getHeight(), gameMapController.getCannon2().getWidth());

			gameMapController.moveCannon();



		}

		ArrayList<Rectangle> cannon1Spheres = new ArrayList<>();

		ArrayList<Rectangle> cannon2Spheres = new ArrayList<>();


		if(gameMapController.getCannon1()!= null) {

			for( int i = 0; i< gameMapController.getCannon1().getSpheres().size(); i++) {
				g.setColor(gameMapController.getSphere().getBallColor());

				g.drawImage(sphereImage,gameMapController.getCannon1().getSpheres().get(i).getX(), gameMapController.getCannon1().getSpheres().get(i).getY(), gameMapController.getSphere().getR(), gameMapController.getSphere().getR(),this);

				cannon1Spheres.add(new Rectangle(gameMapController.getCannon1().getSpheres().get(i).getX(), gameMapController.getCannon1().getSpheres().get(i).getY(), gameMapController.getSphere().getR(), gameMapController.getSphere().getR()));

			}

			for( int i = 0; i< gameMapController.getCannon2().getSpheres().size(); i++) {
				g.setColor(gameMapController.getSphere().getBallColor());

				g.drawImage(sphereImage,gameMapController.getCannon2().getSpheres().get(i).getX(), gameMapController.getCannon2().getSpheres().get(i).getY(), gameMapController.getSphere().getR(), gameMapController.getSphere().getR(),this);

				cannon2Spheres.add(new Rectangle(gameMapController.getCannon2().getSpheres().get(i).getX(), gameMapController.getCannon2().getSpheres().get(i).getY(), gameMapController.getSphere().getR(), gameMapController.getSphere().getR()));

			}


		}

		int ballLeft = (int) ballRectangle.getMinX();
		int ballHeight = (int) ballRectangle.getHeight();
		int ballWidth = (int) ballRectangle.getWidth();
		int ballTop = (int) ballRectangle.getMinY();

		var pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
		var pointLeft = new Point(ballLeft - 1, ballTop);
		var pointTop = new Point(ballLeft, ballTop - 1);
		var pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

		boolean hasNotIntersected = true;

		if(ballRectangle.intersects(phantasmRectangle)) {
			if(gameMapController.getSphere().getX() +10 <= phantasmRectangle.x || gameMapController.getSphere().getX()+1 >= phantasmRectangle.x + phantasmRectangle.width)
				gameMapController.getSphere().performMove(false,true);
			else 
				gameMapController.getSphere().performMove(true,false);
		}


		for(Obstacle obs : gameMapController.getAllObstacles()) {
			JLabel healthNum = new JLabel(String.valueOf(obs.getObstacleHealth()));
			try {

				if (obs.getType() == 0) {	
					obsImage = (ImageIO.read(new File("src/nfs-images/simple_obstacle.png")));
					/*obsImage = (ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\simple_obstacle.png")));*/
				}else if (obs.getType() == 1) {
					obsImage = (ImageIO.read(new File("src/nfs-images/firm_obstacle_empty.png")));
					/*obsImage = (ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\firm_obstacle_empty.png")));*/
				}else if (obs.getType() == 2) {
					obsImage = (ImageIO.read(new File("src/nfs-images/explosive_obstacle.png")));
					/*obsImage = (ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\explosive_obstacle.png")));*/
				}else if (obs.getType() == 3) {
					obsImage = (ImageIO.read(new File("src/nfs-images/gift_obstacle.png")));
					/*obsImage = (ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\gift_obstacle.png")));*/
				}else if (obs.getType() == 4) {
					obsImage = (ImageIO.read(new File("src/nfs-images/hollow_purple.png")));
					/*obsImage = (ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\hollow_purple.png")));*/
				}else if (obs.getType() == 5) {
					obsImage = (ImageIO.read(new File("src/nfs-images/frozen_obstacle.png")));

				}

				if (obs.getType() == 0) {	
					obsImage = (ImageIO.read(new File("src/nfs-images/simple_obstacle.png")));
					/*obsImage = (ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\simple_obstacle.png")));*/
				}else if (obs.getType() == 1) {
					obsImage = (ImageIO.read(new File("src/nfs-images/firm_obstacle_empty.png")));
					/*obsImage = (ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\firm_obstacle_empty.png")));*/
				}else if (obs.getType() == 2) {
					obsImage = (ImageIO.read(new File("src/nfs-images/explosive_obstacle.png")));
					/*obsImage = (ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\explosive_obstacle.png")));*/
				}else if (obs.getType() == 3) {
					obsImage = (ImageIO.read(new File("src/nfs-images/gift_obstacle.png")));
					/*obsImage = (ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\gift_obstacle.png")));*/
				}else if (obs.getType() == 4) {
					obsImage = (ImageIO.read(new File("src/nfs-images/hollow_purple.png")));
					/*obsImage = (ImageIO.read(new File("D:\\2021_302_anonymous\\NeedForSpear\\src\\nfs-images\\hollow_purple.png")));*/
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(obs.getObstacleHealth()>0) {
				g.setColor(Color.BLACK);
				g.drawImage(obsImage,obs.getSpecialX(), obs.getSpecialY(), obs.getSize(), obs.getSize(),this);
				Rectangle brickRectangle = new Rectangle(obs.getSpecialX(), obs.getSpecialY(), obs.getSize(), obs.getSize());
				
				if(obs.isHasHealthText()) {
					healthNum = new JLabel(String.valueOf(obs.getObstacleHealth()));
					healthNum.setBounds(obs.getSpecialX() + 15,  obs.getSpecialY(), obs.getSize(), obs.getSize());

					if(!obs.isMove()) {
						add(healthNum);

					}
				
				}

				if(ballRectangle.intersects(brickRectangle) && hasNotIntersected) {

					obs.hit();

					if (obs.getClass() == GiftObstacle.class)
						ability = gameMapController.createAbility();

					if(gameMapController.getSphere().isUnstoppable() == false) {

						if (brickRectangle.contains(pointRight)) {
							sphereHandler.moveObjSide();


						} else if (brickRectangle.contains(pointLeft)) {
							sphereHandler.moveObjSide();


						}

						if (brickRectangle.contains(pointTop)) {
							sphereHandler.moveObjUp();


						} 
						else if (brickRectangle.contains(pointBottom)) {
							sphereHandler.moveObjUp();



						}
						hasNotIntersected = false;

					}


				}

				if(brickRectangle.intersects(phantasmRectangle)) {

					obs.explode(playerController.getPlayer());
				}


				for(int i = 0; i<cannon1Spheres.size(); i++) {

					if(cannon1Spheres.get(i).intersects(brickRectangle)) {

						obs.hit();

						if (obs.getClass() == GiftObstacle.class)
							ability = gameMapController.getUranusBox().getAbility();


						gameMapController.collideHex1(i);


					}
				}

				for(int i = 0; i<cannon2Spheres.size(); i++) {

					if(cannon2Spheres.get(i).intersects(brickRectangle)) {

						obs.hit();
						if (obs.getClass() == GiftObstacle.class)
							ability = gameMapController.getUranusBox().getAbility();

						gameMapController.collideHex2(i);


					}

				}
				for(int j = 0; j<gameMapController.getAllObstacles().size(); j++) {

					Rectangle brickRectangle2 = new Rectangle(gameMapController.getAllObstacles().get(j).getSpecialX(),gameMapController.getAllObstacles().get(j).getSpecialY(), obs.getSize(), obs.getSize());

					if(brickRectangle.intersects(brickRectangle2) && brickRectangle.x !=brickRectangle2.x ) {

						gameMapController.obstacleCollision( j);

					}


				}


			}

		}

	}

	public Dimension getPreferredSize() {
		return new Dimension(1000,1000);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if (this.getX()<410) {
				phantasm.movePhantasmRight();
			}

		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if (this.getX()>-10) {
				phantasm.movePhantasmLeft();
			}


		}else if(e.getKeyCode() == KeyEvent.VK_A){
			angle+=15;

		}else if(e.getKeyCode() == KeyEvent.VK_D){
			angle-=15;

		}else if(e.getKeyCode() == KeyEvent.VK_T){
			expansionButton.doClick();

		}else if(e.getKeyCode() == KeyEvent.VK_H){
			hexButton.doClick();

		}else if(e.getKeyCode() == KeyEvent.VK_E){
			unstoppableButton.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		int mouseX = e.getX();
		int mouseY = e.getY();

		if(mouseClickCounter == 0) {
			MouseTracker.FirstClick(mouseX,mouseY,gameMapController);
			mouseClickCounter = 1;
		}
		else {
			MouseTracker.NextClick(mouseX,mouseY,gameMapController,secondClickObstacle);
			mouseClickCounter = 0;


		}

		System.out.println(mouseX);
		System.out.println(mouseY);

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
