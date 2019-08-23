package xavier.project_iodine.client;

import com.badlogic.gdx.graphics.Color;
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

    public Color toRGB(int r, int g, int b) {
        float RED = r / 255.0f;
        float GREEN = g / 255.0f;
        float BLUE = b / 255.0f;
        return new Color(RED, GREEN, BLUE, 1);
    }

    public Color toRGB(int hex) {
        float r = (hex & 0xFF0000) >> 16;
        float g = (hex & 0xFF00) >> 8;
        float b = (hex & 0xFF);
        float RED = r / 255.0f;
        float GREEN = g / 255.0f;
        float BLUE = b / 255.0f;
        return new Color(RED, GREEN, BLUE, 1);
    }
}
