package inferno.client.user_interface;

import static org.lwjgl.glfw.GLFW.*;

public class KeyboardInput {
    private long window;

    public KeyboardInput(long window) {
        this.window = window;
    }

    public boolean isKeyPressed(int key){
        return glfwGetKey(window, key) == GLFW_PRESS;
    }
}
