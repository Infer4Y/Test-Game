package inferno.client.user_interface;

import org.joml.Vector2f;
import org.lwjgl.BufferUtils;

import java.nio.DoubleBuffer;

import static org.lwjgl.glfw.GLFW.*;

public class MouseInput {
    private DoubleBuffer b1 = BufferUtils.createDoubleBuffer(1);
    private DoubleBuffer b2 = BufferUtils.createDoubleBuffer(1);
    private long window;

    public MouseInput(long window) {
        this.window = window;
    }

    public boolean isLeftClick(){
        return glfwGetMouseButton(window, GLFW_MOUSE_BUTTON_LEFT) == GLFW_PRESS;
    }

    public boolean isRightClick(){
        return glfwGetMouseButton(window, GLFW_MOUSE_BUTTON_RIGHT) == GLFW_PRESS;
    }

    public Vector2f getMousePos(){
        glfwGetCursorPos(window, b1, b2);

        Vector2f temp = new Vector2f(new Float(b1.get(0)), new Float(b2.get(0)));

        return temp;
    }

    void dispose(){
        b1.clear();
        b2.clear();
    }
}
