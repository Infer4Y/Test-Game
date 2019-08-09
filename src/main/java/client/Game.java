package client;

import client.handlers.BlockHandler;
import client.renderables.*;
import common.registries.Blocks;
import common.world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable, KeyListener {

    private boolean isRunning = true;
    private Thread thread;

    private static final long NANOSECOND        = 1000000000;
    private static final double OPTIMAL_TICKS   = 75.0;
    private static final double OPTIMAL_TIME    = NANOSECOND / OPTIMAL_TICKS;

    private long lastLoopTime = System.nanoTime();
    private long currentTime;
    private double deltaTime;
    private long secondTimer = System.currentTimeMillis();

    private BlockHandler blocktest;

    public static Game instance;

    public static HeadsUpDisplay headsUpDisplay;

    public static final List<Entity> entities = new ArrayList<>();
    public static final List<Drawable> drawables = new ArrayList<>();

    public static final int WIDTH      = 1280;
    public static final int HEIGHT     = 640;


    public static World world = new World("test", WIDTH/64,(HEIGHT/64)+1);
    private Background background = new Background(world);


    private static final String TITLE   = "Game";

    private final FPSViewer fpsViewer = new FPSViewer();
    public static boolean up, down, left, right;

    public static void main(String[] args) {
        instance = new Game();
    }



    public Game () {
        Blocks.init();
        headsUpDisplay = new HeadsUpDisplay();

        addKeyListener(this);


        entities.add(background);
        drawables.add(background);

        for (int i = 0; i < world.getWidth(); i++) {
            for (int j = 0; j < world.getHeight(); j++) {
                entities.add(world.getMapR()[j][i]);
                drawables.add(world.getMapR()[j][i]);
                this.addMouseListener(world.getMapR()[j][i]);
            }
        }

        for (EntityRenderer e: world.getEntities().values()) {
            entities.add(e);
            drawables.add(e);
        }

        entities.add(headsUpDisplay);
        drawables.add(headsUpDisplay);
        addKeyListener(headsUpDisplay);

        entities.add(fpsViewer);
        drawables.add(fpsViewer);

        this.requestFocus();

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
            createBufferStrategy(2);
            return;
        }

        Graphics g = bufferstrategy.getDrawGraphics();

        g.setColor (Color.BLACK);
        g.fillRect (0, 0, getWidth(), getHeight());

        for (Drawable d : drawables) {
            d.draw(g);
        }

        g.dispose ();
        bufferstrategy.show();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_S:
                down=true;
                break;
            case KeyEvent.VK_D:
                right=true;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_S:
                down=false;
                break;
            case KeyEvent.VK_D:
                right=false;
                break;
            default:
                break;
        }
    }
}
