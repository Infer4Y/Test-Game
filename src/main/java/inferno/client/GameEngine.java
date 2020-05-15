package inferno.client;

import inferno.client.graphics.RenderingManager;
import inferno.client.user_interface.GLFWWindow;
import inferno.utils.Referance;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class GameEngine {
    private static final long NANOSECOND        = 1000000000;
    private static final double OPTIMAL_TICKS   = Referance.TICKS;
    private static final double OPTIMAL_TIME    = NANOSECOND / OPTIMAL_TICKS;

    private long lastLoopTime = System.nanoTime();
    private long currentTime;
    private double deltaTime;
    private long secondTimer = System.currentTimeMillis();

    private GLFWWindow window;
    private ClientGame clientGame;

    public GameEngine() {
        this.clientGame = new ClientGame();
    }

    public void begin(){
        window = new GLFWWindow(Referance.WIDTH, Referance.HEIGHT, Referance.NAME+" | "+Referance.VERSION) {
            @Override
            protected void render() {
                clientGame.render();
            }
        };
        loop();
    }

    private void loop(){
        while (clientGame.isRunning() && !glfwWindowShouldClose(window.getWindowId())) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastLoopTime) / OPTIMAL_TIME;
            lastLoopTime = currentTime;

            while (deltaTime >= 1) {
                update();
                deltaTime--;
            }
        }
    }

    private void update(){
        clientGame.update();
    }
}
