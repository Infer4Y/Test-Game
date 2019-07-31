package client;

import client.renderables.Drawable;
import client.renderables.Entity;

import java.awt.*;

public class FPSViewer implements Drawable, Entity {
    private int ticks;
    private int frames;

    private int averageTicks;
    private int averageFrames;

    public void draw (Graphics g) {
        frames++;
        g.setColor(Color.GREEN);
        g.setFont(new Font(null, 0, 24));
        g.drawString("FPS: " + averageFrames + " Ticks: " + averageTicks, 600, 24);
    }

    public void tick () {
        ticks ++;
    }

    public void second () {
        averageFrames = frames / 60;
        averageTicks = ticks;
        frames = 0;
        ticks = 0;
    }
}
