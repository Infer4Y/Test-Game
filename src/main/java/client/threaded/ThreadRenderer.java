package client.threaded;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class ThreadRenderer extends Thread {

    private void render() {
        /*BufferStrategy bufferstrategy = Game.instance.getBufferStrategy ();

        if (bufferstrategy == null) {
            Game.instance.createBufferStrategy(4);
            return;
        }

        Graphics2D g = (Graphics2D) bufferstrategy.getDrawGraphics();

        g.setColor (Color.BLACK);
        g.fillRect (0, 0, Game.instance.getWidth(), Game.instance.getHeight());
        g.dispose ();
        bufferstrategy.show();
         */
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        //while (Game.isRunning) {
        //    render();
        //}
    }
}
