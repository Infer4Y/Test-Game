package client;

import client.renderables.*;
import common.registries.Blocks;
import common.registries.Items;
import common.registries.Recipes;
import talaria.common.Talaria;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    public static boolean f3;
    public static boolean f11;
    private static boolean isRunning = true;
    private Thread thread;

    private static final long NANOSECOND        = 1000000000;
    private static final double OPTIMAL_TICKS   = 50.0;
    private static final double OPTIMAL_TIME    = NANOSECOND / OPTIMAL_TICKS;

    private long lastLoopTime = System.nanoTime();
    private long currentTime;
    private double deltaTime;
    private long secondTimer = System.currentTimeMillis();

    public static Game instance;
    public static Textures textures = new Textures();

    /**
     * These two do not belong here. Also, entities should really be a hashmap, since you want to ID entities.
     */
    @Deprecated
    public static final List<Entity> entities = new ArrayList<>();
    @Deprecated
    public static final List<Drawable> drawables = new ArrayList<>();

    public static final int WIDTH      = 640*2;
    public static final int HEIGHT     = 640;

    public static ClientWorld world;

    private static final String TITLE   = "Game";

    private final FPSViewer fpsViewer = new FPSViewer();
    public static Window window;
    private int count1;

    private void fullscreen(){
        if (!f11) {
            window.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            window.getGraphicsConfiguration().getDevice().setFullScreenWindow(window);
            window.setVisible(true);
            f11 = true;
        } else {
            window.getGraphicsConfiguration().getDevice().setFullScreenWindow(null);
            window.setSize(new Dimension (WIDTH, HEIGHT));
            window.setVisible(true);
            f11=false;
        }
    }

    public Game () {
        this.requestFocus();
        window =  new Window (WIDTH, HEIGHT, TITLE, this);
        Sounds.init();
        Blocks.init();
        Items.init();
        Recipes.init();
        textures.init(Items.ITEM_MAP, Blocks.BLOCK_MAP);
        long i = System.currentTimeMillis() + 1500;

        while (System.currentTimeMillis() < i) {
            splashScreen();
        }

        thread = new Thread(this);
        thread.start();
        entities.add(fpsViewer);
        drawables.add(fpsViewer);

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

            //render();

            if (System.currentTimeMillis () - secondTimer > 1000) {
                updatePerSecond();
                secondTimer += 1000;
            }
        }
    }

    // TODO: The entities should be updated in ClientWorld, not directly here.
    public void update() {
        world.update();
    }

    // TODO: Where is this useful? It's only referenced here in this file.
    private void updatePerSecond() {
        for (Entity e : entities) {
            e.second();
        }
    }

    // TODO: Should be moved to a general renderer. Also, you should maybe organize STATES for your game.
    // States = Screens. MenuState, SplashState, etc. And call their render methods.
    private void splashScreen(){
        BufferStrategy bufferstrategy = getBufferStrategy ();

        if (bufferstrategy == null) {
            createBufferStrategy(4);
            return;
        }

        Graphics2D g = (Graphics2D) bufferstrategy.getDrawGraphics();

        try {
            g.drawImage(ImageIO.read(this.getClass().getClassLoader().getResource("tex/loading.png")), 0, 0, null);
            g.setColor(new Color(0xFFFFFF));
            g.setFont(new Font(null, Font.BOLD, 42));
            g.drawString("World is loading.",640-160,320);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.dispose ();
        bufferstrategy.show();
    }

    private void render() {
        BufferStrategy bufferstrategy = getBufferStrategy ();

        if (bufferstrategy == null) {
            createBufferStrategy(4);
            return;
        }

        Graphics2D g = (Graphics2D) bufferstrategy.getDrawGraphics();

        g.setColor (Color.BLACK);
        g.fillRect (0, 0, getWidth(), getHeight());

        for (Drawable d : drawables) {
            d.draw(g);
        }

        world.draw(g);

        fpsViewer.draw(g);
        g.dispose ();
        bufferstrategy.show();
    }

    // Should also be moved to a rendering manager.
    public void saveCanvas() {
        try {
            BufferedImage image=new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = image.createGraphics();

            g.setColor (Color.BLACK);
            g.fillRect (0, 0, getWidth(), getHeight());

            for (Drawable d : drawables) {
                d.draw(g);
            }

            world.draw(g);

            fpsViewer.draw(g);

            g.dispose ();

            File screenshotFolder = new File(".", "screenshots");

            if (screenshotFolder.exists()) {
                File out = new File(screenshotFolder,"Screenshot-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + ".png");
                if (!out.exists()) {
                    out.createNewFile();
                    ImageIO.write(image, "png", out);
                } else {
                    ImageIO.write(image, "png", out);
                }
            } else {
                screenshotFolder.mkdir();
                File out = new File(screenshotFolder,  "Screenshot-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + ".png");
                if (!out.exists()) {
                    out.createNewFile();
                    ImageIO.write(image, "png", out);
                } else {
                    ImageIO.write(image, "png", out);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Move this out of this class, it's importance warrants its own file.
    private class Renderer extends Thread{

        public Renderer(String name) {
            super(name);
        }

        @Override
        public synchronized void start() {
            super.start();
        }

        @Override
        public void run() {
            while (isRunning) {
                Game.instance.render();
            }
        }
    }
}
