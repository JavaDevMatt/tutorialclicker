package pl.javadevmatt.tutorialclicker.screens;

import pl.javadevmatt.tutorialclicker.IRequestCallback;
import pl.javadevmatt.tutorialclicker.TutorialClickerGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class SplashScreen extends AbstractScreen{
	
	private Texture splashImg;

	public SplashScreen(final TutorialClickerGame game) {
		super(game);
	}
	
	@Override
	protected void init() {
		// TODO implement better assets loading when game grows
		splashImg = new Texture("splash.png");
		
		game.getFeatureFlagService().makeFeatureFlagsRequest(new IRequestCallback() {
			
			@Override
			public void onSucceed() {
				Gdx.app.postRunnable(new Runnable() {
			         @Override
			         public void run() {
			            game.setScreen(new GameplayScreen(game));
			         }
			      });
			}
			
			@Override
			public void onError() {
				// TODO make some error message
			}
		});
	}

	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		spriteBatch.draw(splashImg, 0, 0);
		spriteBatch.end();
	}



}
