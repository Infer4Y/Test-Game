package client;

import client.renderables.*;
import common.registries.BlockRegistry;
import common.registries.Items;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Game extends Canvas implements Runnable{

    public static boolean f3;
    public static boolean f11;
    public static boolean isRunning = true;
    private Thread thread;

    private static final long NANOSECOND        = 1000000000;
    private static final double OPTIMAL_TICKS   = 50.0;
    private static final double OPTIMAL_TIME    = NANOSECOND / OPTIMAL_TICKS;

    private long lastLoopTime = System.nanoTime();
    private long currentTime;
    private double deltaTime;

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



    public Game () {
        this.requestFocus();
        window =  new Window (WIDTH, HEIGHT, TITLE, this);

        world = new ClientWorld("foo", 120, 50);

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
        }
    }

    // TODO: The entities should be updated in ClientWorld, not directly here.
    public void update() {
        world.update();
    }
}
