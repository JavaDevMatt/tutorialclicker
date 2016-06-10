package pl.javadevmatt.tutorialclicker.controllers;

import pl.javadevmatt.tutorialclicker.TutorialClickerGame;
import pl.javadevmatt.tutorialclicker.entities.FlyingObject;
import pl.javadevmatt.tutorialclicker.entities.FlyingObject.FlyingObjectType;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class FlyingObjectController {

	private int spawnTime;
	
	public FlyingObjectController(TutorialClickerGame game, Stage stage){
		init(game, stage);
	}

	private void init(final TutorialClickerGame game, final Stage stage) {
		randomizeSpawnTime();
		
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				
				Timer.schedule(new Task() {
					
					@Override
					public void run() {
						
						addRandomFlyingObjectToStage(game, stage);
						randomizeSpawnTime();
						
					}
				}, spawnTime);
			}
		}, 0, 5);
	}

	private void randomizeSpawnTime() {
		spawnTime = MathUtils.random(5, 10);
	}
	
	private void addRandomFlyingObjectToStage(TutorialClickerGame game, Stage stage){
		FlyingObject flyingObject = null;
		
		if(MathUtils.randomBoolean()){
			flyingObject = new FlyingObject(FlyingObjectType.MONEY, game);
		} else{
			flyingObject = new FlyingObject(FlyingObjectType.PASSIVE, game);
		}
		
		stage.addActor(flyingObject);
		flyingObject.flyLikeHell();
	}
	
	
}
