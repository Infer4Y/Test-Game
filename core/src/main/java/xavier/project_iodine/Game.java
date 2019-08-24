package xavier.project_iodine;

import com.badlogic.gdx.math.Vector2;
import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.viewport.FillViewport;
import xavier.project_iodine.client.BlockOreRenderer;
import xavier.project_iodine.client.BlockRenderer;
import xavier.project_iodine.client.Sounds;
import xavier.project_iodine.client.Textures;
import xavier.project_iodine.common.block.BlockOre;
import xavier.project_iodine.common.registries.Blocks;
import xavier.project_iodine.common.registries.Entities;
import xavier.project_iodine.common.registries.Items;
import xavier.project_iodine.common.registries.Recipes;
import xavier.project_iodine.common.world.World;

import java.util.Random;

public class Game extends ScreenBasedGame {
	public static final String GAME_IDENTIFIER = "xavier.project-iodine";

    public static World world;
    public static ScreenBasedGame instance;

    @Override
    public void initialise() {
        Sounds.init();
        Blocks.init();
        Items.init();
        Entities.init();
        Recipes.init();
        Textures.init(Items.ITEM_MAP, Blocks.BLOCK_MAP);

        instance = this;

        this.addScreen(new MainMenu());
        this.addScreen(world = new World("", 256, 256));
    }

    @Override
    public int getInitialScreenId() {
        return MainMenu.ID;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }
    
    @Override
    public void interpolate(float alpha) {
    
    }
    
    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    @Override
    public void dispose() {
        super.dispose();
        Textures.dispose();
    }

}
