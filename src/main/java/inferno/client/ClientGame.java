package inferno.client;

import inferno.client.graphics.RenderingManager;
import inferno.client.resources.textures.Textures;
import inferno.common.Game;
import inferno.common.registries.Items;
import inferno.common.registries.Tiles;

public class ClientGame extends Game {
    public static Textures textures = new Textures();
    public static RenderingManager manager = new RenderingManager();

    public ClientGame(){
        super();
        init();
    }

    private void init() {
        Tiles.init();
        Items.init();
        textures.init(Items.ITEM_MAP, Tiles.BLOCK_MAP);
    }

    public void render(){
        if (world != null) {
            manager.render(world);
        }
    }

    public void requestShutdown() {
        textures.dispose();

        setRunning(false);
    }
}
