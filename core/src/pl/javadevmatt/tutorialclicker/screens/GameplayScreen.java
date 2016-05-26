package pl.javadevmatt.tutorialclicker.screens;

import pl.javadevmatt.tutorialclicker.TutorialClickerGame;
import pl.javadevmatt.tutorialclicker.entities.Player;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameplayScreen extends AbstractScreen{
	
	private Player player;
	private Button playerButton;

	public GameplayScreen(TutorialClickerGame game) {
		super(game);
	}
	
	@Override
	protected void init() {
		initPlayer();
		initPlayerButton();
	}

	private void initPlayerButton() {
		playerButton = new Button(new ButtonStyle());
		playerButton.setWidth(460);
		playerButton.setHeight(360);
		playerButton.setX(10);
		playerButton.setY(170);
		playerButton.setDebug(true);
		
		stage.addActor(playerButton);
		
		playerButton.addListener(new ClickListener(){
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				
				return super.touchDown(event, x, y, pointer, button);
			}
			
		});
	}

	private void initPlayer() {
		player = new Player();
		stage.addActor(player);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		update();
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		stage.act();
	}


	

}
