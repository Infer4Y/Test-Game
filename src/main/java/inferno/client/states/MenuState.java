package inferno.client.states;

import inferno.client.GameEngine;
import inferno.client.TestGame;
import inferno.client.graphics.renderables.TextureHelper;
import inferno.client.graphics.user_interface.Button;
import inferno.client.resources.textures.Textures;
import inferno.utils.Referance;
import org.joml.AABBf;
import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

import static inferno.client.states.ClientGame.textures;

public class MenuState implements State {
    private Button startButton = new Button(new Vector4f(.5f), new AABBf(340f, 320f, 0, Referance.WIDTH-340f, 360f, 1f));

    @Override
    public void render() {
        TextureHelper.draw(Textures.loading,0,0, Referance.WIDTH-1, Referance.HEIGHT-1);
        startButton.draw();
    }

    @Override
    public void update() {
        if (TestGame.getEngine().getMouseInput().isLeftClick()) {
            if (startButton.isPointInBounds(TestGame.getEngine().getMouseInput().getMousePos())){
                TestGame.getEngine().startGame();
            }
        }
    }

    @Override
    public boolean requestShutdown() {
        textures.dispose();

        return false;
    }
}
