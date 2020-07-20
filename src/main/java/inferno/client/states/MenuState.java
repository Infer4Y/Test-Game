package inferno.client.states;

import inferno.client.GameEngine;
import inferno.client.TestGame;
import inferno.client.graphics.renderables.TextureHelper;
import inferno.client.graphics.user_interface.Button;
import inferno.client.resources.textures.Textures;
import inferno.common.Game;
import inferno.utils.Referance;
import org.joml.AABBf;
import org.joml.Vector3f;
import org.joml.Vector4f;
import static inferno.client.states.ClientGame.textures;

public class MenuState implements State {
    private Button startButton = new Button(new Vector4f(.5f), new AABBf(340f, 320f, 0, Referance.WIDTH-(340f*2f + 40f) , 360f, 1f));
    private Button exitButton = new Button(new Vector4f(.5f), new AABBf(340f, 400f, 0, Referance.WIDTH-(340f*2f + 40f), 440f, 1f));

    public MenuState(){
        startButton.setColor(new Vector4f(0f, 1f, 0f, 95f));
        exitButton.setColor(new Vector4f(1f, 0f, 0f, 95f));
    }
    @Override
    public void render() {
        TextureHelper.draw(Textures.loading,0,0, Referance.WIDTH-1, Referance.HEIGHT-1);
        GameEngine.gameFontTitle.drawText(Referance.NAME+ " | " +Referance.VERSION, 20,20,true);
        startButton.draw();
        GameEngine.gameFontButton.drawText("Start Game", 360f, 320f,false);
        exitButton.draw();
        GameEngine.gameFontButton.drawText("Exit", 360f, 400f,false);
    }

    @Override
    public void update() {
        if (TestGame.getEngine().getMouseInput().isLeftClick()) {
            if (startButton.isPointInBounds(TestGame.getEngine().getMouseInput().getMousePos())){
                TestGame.getEngine().startGame();
            }
            if (exitButton.isPointInBounds(TestGame.getEngine().getMouseInput().getMousePos())){
                TestGame.getEngine().setRunning(false);
            }
        }
    }

    @Override
    public boolean requestShutdown() {
        textures.dispose();

        return false;
    }
}
