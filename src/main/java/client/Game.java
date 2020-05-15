package client;
/**
import client.renderables.*;
import common.registries.Tiles;
import common.registries.Items;
import common.registries.Recipes;
import common.world.World;
import inferno.client.resources.sounds.Sounds;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener {

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

    public static final List<UpdateableObject> entities = new ArrayList<>();
    public static final List<Drawable> drawables = new ArrayList<>();

    public static final int WIDTH      = 640*2;
    public static final int HEIGHT     = 640;


    public static World world;
    private Background background;


    private static final String TITLE   = "Game";

    private final FPSViewer fpsViewer = new FPSViewer();
    public static boolean up, down, left, right;
    private int count;
    public static GLFWWindow window;

    public static void main(String[] args) {
        instance = new Game();
    }

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
        window =  new GLFWWindow (WIDTH, HEIGHT, TITLE, this);
        Sounds.init();
        Tiles.init();
        Items.init();
        Recipes.init();
        textures.init(Items.ITEM_MAP, Tiles.BLOCK_MAP);
        headsUpDisplay = new HeadsUpDisplay();

        addKeyListener(this);
        world = new World("test", 256,256);
        background = new Background(world);
        long i = System.currentTimeMillis() + 1500;

        while (System.currentTimeMillis() < i) {
            splashScreen();
        }


        entities.add(background);
        drawables.add(background);

        this.addMouseListener(this);

        for (EntityRenderer e: world.getEntities().values()) {
            entities.add(e);
            drawables.add(e);
        }




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
        for (UpdateableObject e : entities) {
            e.tick();
        }
        world.update();
    }

    private void updatePerSecond() {
        for (UpdateableObject e : entities) {
            e.second();
        }
        world.updatePerSecond();
    }

    private void splashScreen(){
        BufferStrategy bufferstrategy = getBufferStrategy ();

        if (bufferstrategy == null) {
            createBufferStrategy(4);
            return;
        }

        Graphics2D g = (Graphics2D) bufferstrategy.getDrawGraphics();

        try {
            g.drawImage(ImageIO.read(this.getClass().getClassLoader().getResource("assets/test_game/tex/loading.png")), 0, 0, null);
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
        headsUpDisplay.draw(g);

        count++;

        g.dispose ();
        bufferstrategy.show();
    }

    @SuppressWarnings("")
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
            case KeyEvent.VK_F11:
                fullscreen();
                break;
            case KeyEvent.VK_F2:
                saveCanvas();
                break;
            case KeyEvent.VK_ESCAPE:
                world.closeCraftingUI();
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
        int x1 = (int) Math.floor((e.getX() - world.getEntities().get(world.player).offX) / 64) + (int) Math.floor((world.camX) / 64);
        int y1 = (int) Math.floor((e.getY() - world.getEntities().get(world.player).offY) / 64) + (int) Math.floor((world.camY) / 64);
        System.out.println("x " + x1 + " y " + y1);
        if (!world.isCraftingUIOpen()) {
            world.getMapR()[y1][x1].onClicked(e); //(x <= e.getX()+Game.world.camX && x+width>= e.getX()+Game.world.camX) && (y <= e.getY()+Game.world.camY && y+height>= e.getY()+Game.world.camY)
        } else {
            world.getCraftingUI().handleMouseClick(e);
        }
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

    @Override
    public void mouseDragged(MouseEvent e) {
        if (world.isCraftingUIOpen()) {
            System.out.println(e.getLocationOnScreen());
            world.getCraftingUI().handleMouseMove(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (world.isCraftingUIOpen()) {
            System.out.println(e.getLocationOnScreen());
            world.getCraftingUI().handleMouseMove(e);
        }
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
            while (isRunning) {
                Game.instance.render();
            }
        }
    }
}
**/