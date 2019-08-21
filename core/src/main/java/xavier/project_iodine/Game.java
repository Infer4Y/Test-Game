package xavier.project_iodine;

import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import xavier.project_iodine.client.Sounds;
import xavier.project_iodine.client.Textures;
import xavier.project_iodine.common.registries.Blocks;
import xavier.project_iodine.common.registries.Items;
import xavier.project_iodine.common.registries.Recipes;
import xavier.project_iodine.common.world.World;

import java.util.ArrayList;
import java.util.List;

public class Game extends BasicGame {
	public static final String GAME_IDENTIFIER = "xavier.project-iodine";

    public static final int WIDTH      = 640*2;
    public static final int HEIGHT     = 640;


    public static World world;

	
	@Override
    public void initialise() {
        Sounds.init();
        Blocks.init();
        Items.init();
        Recipes.init();
        Textures.init(Items.ITEM_MAP, Blocks.BLOCK_MAP);
    }
    
    @Override
    public void update(float delta) {
    
    }
    
    @Override
    public void interpolate(float alpha) {
    
    }
    
    @Override
    public void render(Graphics g) {
	    g.drawTexture(Textures.getTexture("ore_iron"), 0 ,0,  64, 64);
    }
}
