package inferno.client;

import inferno.client.user_interface.GLFWWindow;
import inferno.utils.Referance;

import static org.lwjgl.glfw.GLFW.glfwGetTime;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.*;

public class GameEngine {

    protected Timer timer;

    private GLFWWindow window;
    private ClientGame clientGame;

    public GameEngine() {
        this.timer = new Timer();
    }

    public void begin(){
        window = new GLFWWindow(Referance.WIDTH, Referance.HEIGHT, Referance.NAME+" | "+Referance.VERSION) {
            @Override
            protected void render() {
                clientGame.render();
            }
        };

        this.clientGame = new ClientGame();

        loop();
    }

    private void loop(){
        while (clientGame.isRunning()) {
            float delta = timer.getDelta();

            update();

            window.update();
            if (glfwWindowShouldClose(window.getWindowId())) {
                clientGame.requestShutdown();
            }
        }
    }

    private void update(){
        clientGame.update();
    }
}
