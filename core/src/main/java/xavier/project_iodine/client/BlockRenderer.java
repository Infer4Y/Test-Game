package xavier.project_iodine.client;

import org.mini2Dx.core.graphics.Graphics;
import xavier.project_iodine.common.block.Block;
import xavier.project_iodine.common.registries.Blocks;

public class BlockRenderer extends Renderer {
    private Block block;

    public BlockRenderer(int layer, Block block) {
        super(layer);
        this.block = block;
    }

    public BlockRenderer(Block block) {
        super(2);
        this.block = block;
    }

    public BlockRenderer(int layer) {
        super(layer);
        this.block = Blocks.air;
    }

    public BlockRenderer() {
        super(2);
        this.block = Blocks.air;
    }

    @Override
    public void draw(Graphics g, float x, float y) {
        g.drawTexture(Textures.getTexture(block.getName()), x, y);
    }

    @Override
    public int getLayer() {
        return super.getLayer();
    }
}
