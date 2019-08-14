package client;

import client.handlers.BlockHandler;
import client.renderables.*;
import common.registries.Blocks;
import common.registries.Items;
import common.world.World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener {

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

    private BlockHandler blocktest;

    public static Game instance;
    public static Textures textures = new Textures();

    private static Renderer rendererThread;

    public static HeadsUpDisplay headsUpDisplay;

    public static final List<Entity> entities = new ArrayList<>();
    public static final List<Drawable> drawables = new ArrayList<>();

    public static final int WIDTH      = 640*2;
    public static final int HEIGHT     = 640;


    public static World world;
    private Background background;


    private static final String TITLE   = "Game";

    private final FPSViewer fpsViewer = new FPSViewer();
    public static boolean up, down, left, right;
    private int count;

    public static void main(String[] args) {
        instance = new Game();
    }



    public Game () {
        Sounds.init();
        Blocks.init();
        Items.init();
        textures.init(Items.ITEM_MAP, Blocks.BLOCK_MAP);
        headsUpDisplay = new HeadsUpDisplay();

        addKeyListener(this);
        world = new World("test", 256,256);
        background = new Background(world);


        entities.add(background);
        drawables.add(background);

        this.addMouseListener(this);

        for (EntityRenderer e: world.getEntities().values()) {
            entities.add(e);
            drawables.add(e);
        }



        this.requestFocus();
        Window window = new Window (WIDTH, HEIGHT, TITLE, this);
        thread = new Thread(this);
        rendererThread = new Renderer("client");
        thread.start();
        rendererThread.start();
        entities.add(headsUpDisplay);
        drawables.add(headsUpDisplay);
        addKeyListener(headsUpDisplay);
        addMouseWheelListener(headsUpDisplay);

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
        headsUpDisplay.draw(g);

        count++;

        g.dispose ();
        bufferstrategy.show();
    }

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
            headsUpDisplay.draw(g);

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
            case KeyEvent.VK_F3:
                f3 = !f3;
                break;
            case KeyEvent.VK_F2:
                saveCanvas();
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

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x1 = (int)Math.floor(e.getX()/64)+(int)Math.floor(world.camX/64);
        int y1 = (int)Math.floor(e.getY()/64)+(int)Math.floor(world.camY/64);
        System.out.println("x "+x1+" y "+y1);
        world.getMapR()[y1][x1].onClicked(e); //(x <= e.getX()+Game.world.camX && x+width>= e.getX()+Game.world.camX) && (y <= e.getY()+Game.world.camY && y+height>= e.getY()+Game.world.camY)
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

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
            while (Game.isRunning) {
                Game.instance.render();
            }
        }
    }
}
