package client;

import client.handlers.BlockHandler;
import client.renderables.BlockRender;
import client.renderables.Drawable;
import client.renderables.Entity;
import client.renderables.EntityRenderer;
import common.block.Block;
import common.registries.Blocks;
import common.world.World;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private boolean isRunning = true;
    private Thread thread;

    private static final long NANOSECOND        = 1000000000;
    private static final double OPTIMAL_TICKS   = 50.0;
    private static final double OPTIMAL_TIME    = NANOSECOND / OPTIMAL_TICKS;

    private long lastLoopTime = System.nanoTime();
    private long currentTime;
    private double deltaTime;
    private long secondTimer = System.currentTimeMillis();

    private BlockHandler blocktest;

    private final List<Entity> entities = new ArrayList<>();
    private final List<Drawable> drawables = new ArrayList<>();

    public static final int WIDTH      = 1280;
    protected static final int HEIGHT     = 640;


    private World world = new World("test", WIDTH/64,HEIGHT/64);


    private static final String TITLE   = "Game";

    private final FPSViewer fpsViewer = new FPSViewer();

    public static void main(String[] args) {
        new Game();
    }



    public Game () {
        Blocks.init();
        for (int i = 0; i < world.getWidth(); i++) {
            for (int j = 0; j < world.getHeight(); j++) {
                entities.add(world.getMapR()[j][i]);
                drawables.add(world.getMapR()[j][i]);
            }
        }

        for (EntityRenderer e: world.getEntities().values()) {
            entities.add(e);
            drawables.add(e);
        }

        entities.add(fpsViewer);
        drawables.add(fpsViewer);



        Window window = new Window (WIDTH, HEIGHT, TITLE, this);

        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (isRunning) {
            currentTime = System.nanoTime ();
            deltaTime += (currentTime - lastLoopTime) / OPTIMAL_TIME;
            lastLoopTime = currentTime;

            while (deltaTime >= 1) {
                update ();
                deltaTime--;
            }

            render ();

            if (System.currentTimeMillis () - secondTimer > 1000) {
                updatePerSecond();
                secondTimer += 1000;
            }
        }
    }

    private void update() {
        for (Entity e : entities) {
            e.tick();
        }
        world.update();
    }

    private void updatePerSecond() {
        for (Entity e : entities) {
            e.second();
        }
        world.updatePerSecond();
    }

    private void render() {
        BufferStrategy bufferstrategy = getBufferStrategy ();

        if (bufferstrategy == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bufferstrategy.getDrawGraphics();

        g.setColor (Color.white);
        g.fillRect (0, 0, getWidth(), getHeight());

        for (Drawable d : drawables) {
            d.draw(g);
        }

        g.dispose ();
        bufferstrategy.show();
    }
}
