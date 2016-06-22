package pl.javadevmatt.tutorialclicker;



import pl.javadevmatt.tutorialclicker.screens.SplashScreen;
import pl.javadevmatt.tutorialclicker.service.ScoreService;
import pl.javadevmatt.tutorialclicker.service.SoundService;

import com.badlogic.gdx.Game;

public class TutorialClickerGame extends Game {
	
	public final static String GAME_NAME = "Tutorial Clicker";
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	
	private SoundService soundService;
	private ScoreService scoreService;
	
	private boolean paused;
	
	
	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}
	
	private void init() {
		initSoundService();
		initScoreService();
	}
	

	private void initScoreService() {
		scoreService = new ScoreService();
	}

	private void initSoundService() {
		soundService = new SoundService();
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

	public SoundService getSoundService() {
		return soundService;
	}

	public ScoreService getScoreService() {
		return scoreService;
	}

}
