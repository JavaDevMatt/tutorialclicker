package pl.javadevmatt.tutorialclicker.service;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class PassiveIncomeService {
	
	private ScoreService scoreService;
	
	private final static int INFINITE = 100000000;
	
	public PassiveIncomeService(ScoreService scoreService){
		this.scoreService = scoreService;
	}
	
	public void start(){
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				scoreService.addPoints(scoreService.getPassiveIncome());
			}
		}, 1, 1, INFINITE);
	}

}
