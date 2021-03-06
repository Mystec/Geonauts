/**
 * 
 */
package com.me.geonauts.utils;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;



/**
 * @author tamas
 *
 */
public class TextureSetup {
	
	/** External folder where graphics lie on the computer. */
	private static final String ASSET_FOLDER = "/home/joel/workspace/libgdx/assets/Geonauts/";
	
	/** "internal" folder where textures and texture.pack should be put */
	private static final String ROOT_DIR = "/home/joel/workspace/libgdx/Geonauts/Geonauts-android/assets/images/";
	
	
	
	public static void main(String[] args) {
		
		// Animations
		/**
		TexturePacker2.process(ASSET_FOLDER + "animations/explosion_06", ROOT_DIR + "textures/explosions", "explosion_06.pack");
		TexturePacker2.process(ASSET_FOLDER + "animations/explosion_10", ROOT_DIR + "textures/explosions", "explosion_10.pack");
		TexturePacker2.process(ASSET_FOLDER + "animations/explosion_11", ROOT_DIR + "textures/explosions", "explosion_11.pack");
		TexturePacker2.process(ASSET_FOLDER + "animations/hit", ROOT_DIR + "textures/explosions", "hit.pack");
		TexturePacker2.process(ASSET_FOLDER + "animations/coins", ROOT_DIR + "textures/misc", "coins.pack");
		
		// nauts
		TexturePacker2.process(ASSET_FOLDER + "nauts", ROOT_DIR + "textures/nauts", "nauts.pack");
		
		// tiles
		TexturePacker2.process(ASSET_FOLDER + "tiles", ROOT_DIR + "textures/tiles", "tiles.pack");
		
		// Planets
		TexturePacker2.process(ASSET_FOLDER + "planets", ROOT_DIR + "textures/planets", "planets.pack");
		
		// misc
		TexturePacker2.process(ASSET_FOLDER + "misc", ROOT_DIR + "textures/misc", "misc.pack");
		*/
		// missiles
		TexturePacker2.process(ASSET_FOLDER + "missiles", ROOT_DIR + "textures/missiles", "missiles.pack");

		
		// enemies
		TexturePacker2.process(ASSET_FOLDER + "enemies", ROOT_DIR + "textures/enemies", "enemies.pack");
		
		// Powerups
		TexturePacker2.process(ASSET_FOLDER + "powerups", ROOT_DIR + "textures/misc", "powerups.pack");
		TexturePacker2.process(ASSET_FOLDER + "animations/barrier", ROOT_DIR + "textures/misc", "barrier.pack");
		

		// UI stuff
		TexturePacker2.process(ASSET_FOLDER + "ui", ROOT_DIR + "ui/", "ui.pack");

	}
}
