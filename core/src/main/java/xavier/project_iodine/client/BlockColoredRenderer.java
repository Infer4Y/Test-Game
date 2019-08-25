package xavier.project_iodine.client;

import com.badlogic.gdx.graphics.Color;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import xavier.project_iodine.common.block.BlockColored;
import xavier.project_iodine.common.block.BlockOre;

public class BlockColoredRenderer extends BlockRenderer {
    private Sprite vein;
    private Color color;

    public BlockColoredRenderer(int layer, BlockColored block) {
        super(layer, block);
    }

    public BlockColoredRenderer(BlockColored block) {
        super(2, block);
    }

    @Override
    public void draw(Graphics g, float x, float y) {
        if (vein == null && color == null) {
            vein = new Sprite(Textures.getTexture(block.getName().replace("_" + ((BlockColored) block).getColorState().get_name(), "")));
            color = new Color(((BlockColored) block).getColorState().get_color());
        }
        g.setTint(color);
        g.drawTexture(vein.getTexture(), x, y,64,64);
        g.setTint(Color.WHITE);
    }
}
