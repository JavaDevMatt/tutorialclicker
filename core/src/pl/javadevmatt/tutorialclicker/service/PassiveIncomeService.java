package pl.javadevmatt.tutorialclicker.service;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class PassiveIncomeService {
	
	private ScoreService scoreService;
	
	private final static int INFINITE = 100000000;
	
	public PassiveIncomeService(ScoreService scoreService){
		this.scoreService = scoreService;
		calculateGainedPassiveIcome();
	}
	
	public void start(){
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				scoreService.addPoints(scoreService.getPassiveIncome());
			}
		}, 1, 1, INFINITE);
	}
	
	private void calculateGainedPassiveIcome() {
		long savedTimestamp = scoreService.getSavedTimestamp();
		if(savedTimestamp > 0){
			long millisPassed = TimeUtils.timeSinceMillis(savedTimestamp);
			long seconds = TimeUnit.MILLISECONDS.toSeconds(millisPassed);
			addPointsBasedOnPassedTime(seconds);
		} else {
			// do nothing
		}
	}
	
	private void addPointsBasedOnPassedTime(long seconds){
		if(seconds > 0){
			int points = (int) (seconds * scoreService.getPassiveIncome());
			points = points / 5;
			scoreService.addPoints(points);
		}
	}

}
