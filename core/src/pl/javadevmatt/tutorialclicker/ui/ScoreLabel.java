package pl.javadevmatt.tutorialclicker.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ScoreLabel extends Label{
	
	public ScoreLabel(){
		super("", prepareLabelStyle());
		init();
	}

	private void init() {
		this.setX(20);
		this.setY(650);
	}

	private static LabelStyle prepareLabelStyle() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		return labelStyle;
	}
}
