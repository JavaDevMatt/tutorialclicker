package pl.javadevmatt.tutorialclicker.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.TimeUtils;

public class ScoreService {
	
	public final static String GAME_PREFS = "pl.javadevmatt.preclicker.prefs";
	public final static String GAME_SCORE = "pl.javadevmatt.preclicker.prefs.score";
	public final static String GAME_PASSIVE_INCOME = "pl.javadevmatt.preclicker.prefs.passiveincome";
	public final static String GAME_SAVED_TIMESTAMP = "pl.javadevmatt.preclicker.prefs.savedtimestamp";
	
	private Preferences prefs;
	
	private int points;
	private int passiveIncome;
	
	public ScoreService(){
		init();
	}
	
	private void init() {
		prefs =  Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
		loadPassiveIncome();
	}

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
	}
	
	private void loadPassiveIncome(){
		passiveIncome = prefs.getInteger(GAME_PASSIVE_INCOME);
	}
	
	public void addPoints(int pointsToAdd){
		points += pointsToAdd;
	}

	public void addPoint(){
		points++;
	}
	
	public void resetGameScore() {
		points = 0;
		passiveIncome = 0;
	}
	public void addPassiveIncome() {
		passiveIncome++;
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getPassiveIncome(){
		return passiveIncome;
	}
	
	public long getSavedTimestamp(){
		return prefs.getLong(GAME_SAVED_TIMESTAMP);
	}

	public void saveCurrentGamestate() {
		prefs.putLong(GAME_SAVED_TIMESTAMP, TimeUtils.millis());
		prefs.putInteger(GAME_SCORE, points);
		prefs.putInteger(GAME_PASSIVE_INCOME, passiveIncome);
		prefs.flush();
	}
	
}
