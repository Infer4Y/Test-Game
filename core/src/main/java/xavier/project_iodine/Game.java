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

	public static FillViewport viewport;

	private Random r = new Random();

	float x, y;

    public static World world;
    public BlockOreRenderer[] ore_renderer;
    public BlockOreRenderer[][] ore_renderer1 = new BlockOreRenderer[20][10];
    public static BlockOre[] ores =
            {
                    Blocks.ore_coal,
                    Blocks.ore_copper,
                    Blocks.ore_diamond,
                    Blocks.ore_iron,
                    Blocks.ore_gold,
                    Blocks.ore_tin,
                    Blocks.ore_silver,
                    Blocks.ore_ruby
            };

    @Override
    public void initialise() {
        Sounds.init();
        Blocks.init();
        Items.init();
        Entities.init();
        Recipes.init();
        Textures.init(Items.ITEM_MAP, Blocks.BLOCK_MAP);
        ore_renderer = new BlockOreRenderer[ores.length];
        for (int i = 0; i < ores.length; i++) {
            ore_renderer[i] = new BlockOreRenderer(ores[i]);
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                ore_renderer1[i][j] = ore_renderer[r.nextInt(ores.length)];
            }
        }
        world = new World("",64, 64);
        viewport = new FillViewport(this.width, this.height);
        x = y = 0;
    }

    @Override
    public int getInitialScreenId() {
        return 0;
    }

    @Override
    public void update(float delta) {
        viewport.toWorldCoordinates(new Vector2(x, y));
        x++;
        y++;
    }
    
    @Override
    public void interpolate(float alpha) {
    
    }
    
    @Override
    public void render(Graphics g) {
        viewport.apply(g);
        world.draw(g);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                ore_renderer1[i][j].draw(g, i * 64 , j * 64);
            }
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        Textures.dispose();
    }

}
