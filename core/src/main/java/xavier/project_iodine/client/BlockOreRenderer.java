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
        vein.scale(4.0f);
        color = new Color(block.getColor());
        vein.setColor(color);
    }

    public BlockOreRenderer(BlockOre block) {
        super(2, block);
        vein = new Sprite(Textures.ore_overlay);
        color = new Color(block.getColor());
        vein.setColor(color);
    }

    @Override
    public void draw(Graphics g, float x, float y) {
        g.drawTexture(Textures.getTexture("stone"), x, y,64,64);
        g.setColor(color);
        g.drawTexture(Textures.ore_overlay, x, y,64,64);
        g.setColor(Color.WHITE);
    }
}

