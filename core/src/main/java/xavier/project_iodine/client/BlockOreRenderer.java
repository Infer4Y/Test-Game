package xavier.project_iodine.client;

import com.badlogic.gdx.graphics.Color;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import xavier.project_iodine.common.block.BlockOre;

public class BlockOreRenderer extends BlockRenderer {
    private Sprite vein;
    private Color color;

    public BlockOreRenderer(int layer, BlockOre block) {
        super(layer, block);
        vein = new Sprite(Textures.ore_overlay);
        color = Color.valueOf(""+block.getColor());
    }

    public BlockOreRenderer(BlockOre block) {
        super(2, block);
        vein = new Sprite(Textures.ore_overlay);
        color = Color.valueOf(""+block.getColor());
    }

    @Override
    public void draw(Graphics g, float x, float y) {
        g.drawTexture(Textures.getTexture("stone"), x, y);
        g.setColor(color);
        g.drawSprite(vein, x, y);
        g.setColor(Color.WHITE);
    }
}

