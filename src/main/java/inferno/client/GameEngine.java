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
        this.clientGame = new ClientGame();
    }

    public void begin(){
        window = new GLFWWindow(Referance.WIDTH, Referance.HEIGHT, Referance.NAME+" | "+Referance.VERSION) {
            @Override
            protected void render() {
                clientGame.render();

                /* Rotate matrix */
                glLoadIdentity();
                glRotatef((float) glfwGetTime() * 50f, 0f, 0f, 1f);

                /* Render triangle */
                glBegin(GL_TRIANGLES);
                glColor3f(1f, 0f, 0f);
                glVertex3f(-0.6f, -0.4f, 0f);
                glColor3f(0f, 1f, 0f);
                glVertex3f(0.6f, -0.4f, 0f);
                glColor3f(0f, 0f, 1f);
                glVertex3f(0f, 0.6f, 0f);
                glEnd();
            }
        };
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
