package inferno.client.graphics.user_interface;

import inferno.client.graphics.UpdateableObject;
import inferno.client.graphics.renderables.Drawable;

import java.awt.*;

public class FPSViewer implements Drawable, UpdateableObject {
    private int ticks;
    private int frames;

    private int averageTicks;
    private int averageFrames;

    public void draw (Graphics g) {
        frames++;
        //if (Game.f3) {
            g.setColor(Color.GREEN);
            g.setFont(new Font(null, 0, 24));
            g.drawString("FPS: " + averageFrames + " Ticks: " + averageTicks, 1280 - (14 * (5 + 2 + 6 + 2)), 24);
        //}
    }

    public void tick () {
        ticks ++;
    }

    public void second () {
        averageFrames = frames;
        averageTicks = ticks;
        frames = 0;
        ticks = 0;
    }
}
