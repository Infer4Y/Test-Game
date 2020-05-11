package inferno.client.graphics.renderables;

import inferno.client.graphics.renderables.Drawable;

import java.awt.*;

public class EntityRenderer implements Drawable {
    private int x, y;

    public EntityRenderer() {
    }

    @Override
    public void draw(Graphics g) {
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
