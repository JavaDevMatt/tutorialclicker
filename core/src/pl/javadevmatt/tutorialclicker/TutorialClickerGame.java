package pl.javadevmatt.tutorialclicker;

import pl.javadevmatt.tutorialclicker.screens.SplashScreen;

import com.badlogic.gdx.Game;

public class TutorialClickerGame extends Game {
	
	public final static String GAME_NAME = "Tutorial Clicker";
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	
	private boolean paused;
	
	
	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}

	/**
	 * ---------------------
	 * getters and setters
	 * 
	 */

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
