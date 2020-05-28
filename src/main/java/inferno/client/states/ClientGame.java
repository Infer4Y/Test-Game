package inferno.client.states;

import inferno.client.GameEngine;
import inferno.client.TestGame;
import inferno.client.graphics.RenderingManager;
import inferno.client.graphics.renderables.tiles.TileOutlineRenderer;
import inferno.client.resources.textures.Textures;
import inferno.client.user_interface.KeyboardInput;
import inferno.client.user_interface.MouseInput;
import inferno.common.Game;
import inferno.common.registries.Items;
import inferno.common.registries.Tiles;
import inferno.utils.ChunkUtils;
import inferno.utils.Referance;
import org.joml.Vector2f;

import static org.lwjgl.glfw.GLFW.*;

public class ClientGame extends Game implements State {
    public static Textures textures = new Textures();
    public static RenderingManager manager = new RenderingManager();
    private static Vector2f centerd = new Vector2f(Referance.WIDTH/Referance.TEXTURE_UNIT/2,Referance.HEIGHT/Referance.TEXTURE_UNIT/2);
    private Vector2f clientMouse;

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
        MouseInput mouseInput = TestGame.getEngine().getMouseInput();
        clientMouse = mouseInput.getMousePos().mul(1f/ Referance.TEXTURE_UNIT, new Vector2f()).add(GameEngine.userInstance.getLocation(), new Vector2f()).sub(10,5);

        float speedMod = keyboardInput.isKeyPressed(GLFW_KEY_LEFT_CONTROL) ? 2.5f : 1f;

        if (keyboardInput.isKeyPressed(GLFW_KEY_W) && GameEngine.userInstance.isGrounded(world)) {
            GameEngine.userInstance.addForce(new Vector2f(0, -2.45f));
        }
        if (keyboardInput.isKeyPressed(GLFW_KEY_S)) {
            //GameEngine.userInstance.addForce(new Vector2f(0, .25f));
        }
        if (keyboardInput.isKeyPressed(GLFW_KEY_A)) {
            GameEngine.userInstance.setXForce(-.25f * speedMod);
        }
        if (keyboardInput.isKeyPressed(GLFW_KEY_D)) {
            GameEngine.userInstance.setXForce(.25f * speedMod);
        }

        if (mouseInput.isLeftClick()||keyboardInput.isKeyPressed(GLFW_KEY_SPACE)){
            world.setTileFromMousePos(clientMouse, Tiles.air);
        }
        System.out.println("Player pos : " + GameEngine.userInstance.getLocation().toString() + "\nMouse pos : " + clientMouse.toString());

        ClientGame.manager.drawables.add(new TileOutlineRenderer(clientMouse));
    }

    public boolean requestShutdown() {
        textures.dispose();

        setRunning(false);

        return isRunning();
    }
}
