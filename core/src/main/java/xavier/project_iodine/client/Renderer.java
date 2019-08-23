package xavier.project_iodine.client;

import org.mini2Dx.core.graphics.Graphics;

public class Renderer implements Renderable{
    private int layer;

    public Renderer(int layer) {
        this.layer = layer;
    }

    public Renderer() {
        this.layer = 1;
    }

    @Override
    public void draw(Graphics g, float x, float y) {
        g.drawTexture(Textures.getTexture(null), x, y);
    }

    public int getLayer() {
        return layer;
    }
}
