package inferno.client;

import inferno.client.resources.textures.Textures;
import inferno.common.Game;
import inferno.common.registries.Items;
import inferno.common.registries.Tiles;

public class ClientGame extends Game {
    public static Textures textures = new Textures();

    public ClientGame(){
        init();
    }

    private void init() {
        Tiles.init();
        Items.init();
        textures.init(Items.ITEM_MAP, Tiles.BLOCK_MAP);
    }
}
