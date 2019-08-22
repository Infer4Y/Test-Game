package xavier.project_iodine;

import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.core.graphics.Graphics;
import xavier.project_iodine.client.Sounds;
import xavier.project_iodine.client.Textures;
import xavier.project_iodine.common.registries.Blocks;
import xavier.project_iodine.common.registries.Items;
import xavier.project_iodine.common.registries.Recipes;
import xavier.project_iodine.common.world.World;

public class Game extends ScreenBasedGame {
	public static final String GAME_IDENTIFIER = "xavier.project-iodine";

    public static World world;

    @Override
    public void initialise() {
        Sounds.init();
        Blocks.init();
        Items.init();
        Recipes.init();
        Textures.init(Items.ITEM_MAP, Blocks.BLOCK_MAP);

        world = new World("",64, 64);
    }

    @Override
    public int getInitialScreenId() {
        return 0;
    }

    @Override
    public void update(float delta) {
    
    }
    
    @Override
    public void interpolate(float alpha) {
    
    }
    
    @Override
    public void render(Graphics g) {
        world.draw(g);
    }

    @Override
    public void dispose() {
        super.dispose();
        Textures.dispose();
    }
}
