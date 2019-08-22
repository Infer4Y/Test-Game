package xavier.project_iodine.desktop;

import org.mini2Dx.desktop.DesktopMini2DxConfig;

import com.badlogic.gdx.backends.lwjgl.DesktopMini2DxGame;

import xavier.project_iodine.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopMini2DxConfig config = new DesktopMini2DxConfig(Game.GAME_IDENTIFIER);
		config.vSyncEnabled = true;
		config.width = 1280;
		config.height = 640;
		new DesktopMini2DxGame(new Game(), config);
	}
}
