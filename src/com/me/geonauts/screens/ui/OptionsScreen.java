package com.me.geonauts.screens.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.me.geonauts.Geonauts;

public class OptionsScreen extends AbstractScreen{
	private TextButton btnReset;
	private TextButton btnDisableMusic;
	private TextButton btnGoBack;
	
	private TextureAtlas uiAtlas;
	private TextButtonStyle style;
	
	private Label lblReset;
	
	private Preferences prefs = Gdx.app.getPreferences("game-prefs");
	
	
	public OptionsScreen(Geonauts game) {
		super(game);		
		
		Skin skin = new Skin(Gdx.files.internal("images/ui/default-skin.json"));
		
		//Texture
		// Load textures
		// Load textures
		uiAtlas = new TextureAtlas(Gdx.files.internal("images/ui/ui.pack"));
		// TextureRegions
		TextureRegion upRegion = uiAtlas.findRegion("buttonNormal");
		TextureRegion downRegion = uiAtlas.findRegion("buttonPressed");

		// Styles
		style = new TextButtonStyle();
		style.up = new TextureRegionDrawable(upRegion);
		style.down = new TextureRegionDrawable(downRegion);
		style.font = new BitmapFont(
				Gdx.files.internal("fonts/regular.fnt"),
				Gdx.files.internal("fonts/regular.png"), false);
		
		//Button
		btnReset = new TextButton("Reset Game", style);
		btnReset.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				prefs.putInteger("Reload", 2);
				prefs.putInteger("Attack", 1);
				prefs.putInteger("Health", 1);
				prefs.putInteger("Moneyx", 1);
				prefs.putInteger("max targets", 2);
				prefs.putInteger("Money", 200);
				prefs.putInteger("total upgrades", 7);
				prefs.putBoolean("bossMode", false);
				prefs.flush();
				
			}
		});
		lblReset = new Label("Reset all game upgrades", skin);
		boolean music = prefs.getBoolean("play-music");
		if (music) 
			btnDisableMusic = new TextButton("Sound Enabled!", style);
		else
			btnDisableMusic = new TextButton("Sound Disabled", style);
		
		btnDisableMusic.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				boolean music = prefs.getBoolean("play-music");
				// If music enabled, disable.
				if (music) {
					prefs.putBoolean("play-music", false);
					btnDisableMusic.setText("Sound Disabled");
				// Sound is now enabled
				} else {
					prefs.putBoolean("play-music", true);
					btnDisableMusic.setText("Sound Enabled!");
				}
				prefs.flush();
				
			}
		});

		btnGoBack = new TextButton("Return", style);
		btnGoBack.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				goToMenu();			
			}
		});		
		
	}
		

    @Override
    public void resize( int width, int height )  {
    	super.resize(width, height);
     
    	
    	int btnWidth = uiAtlas.findRegion("buttonNormal").getRegionWidth();
    	int btnHeight = uiAtlas.findRegion("buttonNormal").getRegionHeight();
    	
    	if (height < 512) {    	
    		btnWidth /= 2f;
    		btnHeight /= 2f;
    		style.font.setScale(0.5f);
    	} else {
    		style.font.setScale(1);
    	}
    	
		table.add(lblReset);
		table.row();
		table.add(btnReset).width(btnWidth).height(btnHeight);//.uniform().fill();
		table.row();
		table.add(btnDisableMusic);
		table.row();
		table.add(btnGoBack).width(btnWidth).height(btnHeight);//.uniform().fill();
		table.invalidate();
    }
		
	
	
	public void render(float delta) {
		super.render(delta);
	}

	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	public void show() {
		Gdx.input.setInputProcessor(stage);
		
		// Show an 50% of the time
		if (game.randomGen.nextBoolean()) 
			game.getActionResolver().showAd();
		
		
    	table.setBackground(background);
	}

	private void goToMenu() {
		game.setScreen(game.getMainMenuScreen());
	}
}