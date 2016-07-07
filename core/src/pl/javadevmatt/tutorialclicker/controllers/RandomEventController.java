package pl.javadevmatt.tutorialclicker.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class RandomEventController {
	
	private static final int RANDOM_TICK_INTERVAL = 5; // TODO: change after initial implementation

	public RandomEventController(){
		init();
	}
	
	private void init(){
		
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				if(MathUtils.randomBoolean()){
					triggerRandomEvent();
				}
			}

			
		}, RANDOM_TICK_INTERVAL, RANDOM_TICK_INTERVAL);
		
	}
	
	private void triggerRandomEvent() {
		System.out.println("random event triggered");
	}
	
}
