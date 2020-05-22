package inferno.client.states;

import inferno.client.GameEngine;
import inferno.client.TestGame;
import inferno.client.graphics.RenderingManager;
import inferno.client.resources.textures.Textures;
import inferno.client.user_interface.KeyboardInput;
import inferno.common.Game;
import inferno.common.registries.Items;
import inferno.common.registries.Tiles;
import org.joml.Vector2f;

import static org.lwjgl.glfw.GLFW.*;

public class ClientGame extends Game implements State {
    public static Textures textures = new Textures();
    public static RenderingManager manager = new RenderingManager();

    public ClientGame(){
        super();
    }

    public void render(){
        if (world != null) {
            manager.render(world);
        }
    }

    @Override
    public void update() {
        super.update();

        KeyboardInput keyboardInput = TestGame.getEngine().getKeyboardInput();

        if (keyboardInput.isKeyPressed(GLFW_KEY_W)) {
            GameEngine.userInstance.addForce(new Vector2f(0, -.45f));
        }
        if (keyboardInput.isKeyPressed(GLFW_KEY_S)) {
            //GameEngine.userInstance.addForce(new Vector2f(0, .25f));
        }
        if (keyboardInput.isKeyPressed(GLFW_KEY_A)) {
            GameEngine.userInstance.addForce(new Vector2f(-.25f, 0));
        }
        if (keyboardInput.isKeyPressed(GLFW_KEY_D)) {
            GameEngine.userInstance.addForce(new Vector2f(.25f, 0));
        }
    }

    public boolean requestShutdown() {
        textures.dispose();

        setRunning(false);

        return isRunning();
    }
}
