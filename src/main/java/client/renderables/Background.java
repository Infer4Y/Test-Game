package client.renderables;

import client.Game;

import java.awt.*;

public class Background implements Entity, Drawable {
    private Color c = Color.BLACK;
    private boolean f = true;
    private int count;



    @Override
    public void tick() {
    }

    @Override
    public void second() {
        if (count == 3) {
            if (f) {
                if (c.equals(Color.white)) {
                    f = false;
                }
                c = c.brighter();
            } else {
                if (c.equals(Color.BLACK)) {
                    f = true;
                }
                c = c.darker();
            }
            count = 0;
        } else {
            count++;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
    }
}
