package pl.javadevmatt.tutorialclicker.screens;

import pl.javadevmatt.tutorialclicker.TutorialClickerGame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class SplashScreen extends AbstractScreen{
	
	private Texture splashImg;

	public SplashScreen(final TutorialClickerGame game) {
		super(game);
		
		Timer.schedule(new Task() {
			@Override
			public void run() {
				game.setScreen(new GameplayScreen(game));
			}
		}, 3);
	}
	
	@Override
	protected void init() {
		// TODO implement better assets loading when game grows
		splashImg = new Texture("splash.png");
	}

	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		spriteBatch.draw(splashImg, 0, 0);
		spriteBatch.end();
	}



}
