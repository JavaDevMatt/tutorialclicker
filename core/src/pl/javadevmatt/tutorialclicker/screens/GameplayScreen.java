package pl.javadevmatt.tutorialclicker.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.javadevmatt.tutorialclicker.TutorialClickerGame;
import pl.javadevmatt.tutorialclicker.entities.Player;
import pl.javadevmatt.tutorialclicker.ui.IClickCallback;
import pl.javadevmatt.tutorialclicker.ui.PlayerButton;
import pl.javadevmatt.tutorialclicker.ui.ResetScoreButton;
import pl.javadevmatt.tutorialclicker.ui.ScoreLabel;

public class GameplayScreen extends AbstractScreen{
	
	private Image bgImg;
	private Player player;
	private PlayerButton playerButton;
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;

	public GameplayScreen(TutorialClickerGame game) {
		super(game);
	}
	
	@Override
	protected void init() {
		initBg();
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initScoreLabel();
	}
	
	private void initBg() {
		bgImg = new Image(new Texture("bg.png"));
		stage.addActor(bgImg);
	}

	private void initResetScoreButton() {
		resetScoreButton = new ResetScoreButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				game.resetGameScore();
			}
		});
		
		stage.addActor(resetScoreButton);
	}

	private void initScoreLabel() {
		scoreLabel = new ScoreLabel();
		stage.addActor(scoreLabel);
	}

	private void initPlayerButton() {
		playerButton = new PlayerButton(new IClickCallback() {
			@Override
			public void onClick() {
				player.reactOnClick();
				game.addPoint();
			}
		});
		
		stage.addActor(playerButton);
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
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act();
	}


	

}
