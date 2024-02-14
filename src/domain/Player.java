package domain;

import java.io.Serializable;

public class Player implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static Player player;
	public static boolean playerDead = false;
	public static boolean gameOver = false;
	private boolean unstoppable;
	private boolean hex;
	public  int Score;
	public  int remLives;
	public int TimeElapsed;
	
	public Player() {
		this.Score = 0;
		this.remLives = 3;
		this.TimeElapsed = 0;
	}

	
	
	public int scoreHelper() {
		if (TimeElapsed > 0) {
			return Score;
		} else {
			return 0;
		}

	}
	public void scoreUpdater() {
		if (TimeElapsed > 0) {
			Score = Score + (300 / TimeElapsed);

		}

	}



	public void setScore(int score) {
		Score = score;
	}

	public int getRemLives() {
		return remLives;
	}

	public void setRemLives(int remLives) {
		this.remLives = remLives;
	}



}
