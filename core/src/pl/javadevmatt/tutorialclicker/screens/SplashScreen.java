package pl.javadevmatt.tutorialclicker.screens;

import pl.javadevmatt.tutorialclicker.IRequestCallback;
import pl.javadevmatt.tutorialclicker.TutorialClickerGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class SplashScreen extends AbstractScreen{
	
	private Texture splashImg, noInternetImg;
	private boolean showError = false;

	public SplashScreen(final TutorialClickerGame game) {
		super(game);
	}
	
	@Override
	protected void init() {
		// TODO implement better assets loading when game grows
		splashImg = new Texture("splash.png");
		noInternetImg = new Texture("nointernet.png");
		
		game.getFeatureFlagService().makeFeatureFlagsRequest(new IRequestCallback() {
			
			@Override
			public void onSucceed() {
				showError = false;
				Gdx.app.postRunnable(new Runnable() {
			         @Override
			         public void run() {
			            game.setScreen(new GameplayScreen(game));
			         }
			      });
			}
			
			@Override
			public void onError() {
				showError = true;
			}
		});
	}

	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		if(showError){
			spriteBatch.draw(noInternetImg, 0, 0);
		} else {
			spriteBatch.draw(splashImg, 0, 0);
		}
		spriteBatch.end();
	}



}
