package pl.javadevmatt.tutorialclicker.entities;

import pl.javadevmatt.tutorialclicker.TutorialClickerGame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class FlyingObject extends Image{
	
	public enum FlyingObjectType{
		MONEY, PASSIVE
	}
	
	public final static String MONEY = "img/money.png";
	public final static String BOOKS = "img/books.png";
	
	private final static int WIDHT = 80;
	private final static int HEIGHT = 80;
	
	private final static int STARTING_X = 0;
	private final static int STARTING_Y = -100;
	
	private TutorialClickerGame game;
	private FlyingObjectType type;

	public FlyingObject(FlyingObjectType type, TutorialClickerGame game){
		super(new Texture(getTextureString(type)));
		
		this.type = type;
		this.game = game;
		
		this.setOrigin(WIDHT / 2, HEIGHT / 2);
		this.setSize(WIDHT, HEIGHT);
		
		// starting position
		this.setPosition(STARTING_X, STARTING_Y);
		
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				
				reactOnClick();
				return super.touchDown(event, x, y, pointer, button);
			}

			
		});
	}
	
	private void reactOnClick() {
		if(FlyingObjectType.MONEY.equals(type)){
			game.addPoints(50);
		} else if(FlyingObjectType.PASSIVE.equals(type)){
			game.addPassiveIncome();
		}
		
		FlyingObject.this.remove();
	}
	
	private static String getTextureString(FlyingObjectType type) {
		if(FlyingObjectType.MONEY.equals(type)){
			return MONEY;
		} else if(FlyingObjectType.PASSIVE.equals(type)){
			return BOOKS;
		}
		
		return "";
	}

	public void flyLikeHell(){
		
		Action a = Actions.parallel(
				Actions.moveBy(300, 200, 5),
				Actions.rotateBy(360, 5)
				);
		
		Action b = Actions.parallel(
				Actions.moveBy(-500, 900, 3),
				Actions.rotateBy(360, 3)
				);
		
		Action c = Actions.run(new Runnable() {
			
			@Override
			public void run() {
				FlyingObject.this.remove();
			}
		});
		
		
		this.addAction(Actions.sequence(a, b, c));
	}
	
}
