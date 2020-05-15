package inferno.client.graphics.renderables;

import inferno.client.graphics.renderables.Drawable;

import java.awt.*;

public class EntityRenderer implements Drawable {
    private int x, y;

    public EntityRenderer() {
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public void draw() { }
}
