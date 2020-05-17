package inferno.client.states;

import inferno.client.graphics.RenderingManager;
import inferno.client.resources.textures.Textures;
import inferno.common.Game;
import inferno.common.registries.Items;
import inferno.common.registries.Tiles;

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

    public boolean requestShutdown() {
        textures.dispose();

        setRunning(false);

        return isRunning();
    }
}
