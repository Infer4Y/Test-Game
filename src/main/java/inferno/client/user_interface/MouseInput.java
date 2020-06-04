package inferno.client.user_interface;

import org.joml.Vector2f;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWScrollCallback;

import java.nio.DoubleBuffer;

import static org.lwjgl.glfw.GLFW.*;

public class MouseInput {
    private DoubleBuffer b1 = BufferUtils.createDoubleBuffer(1);
    private DoubleBuffer b2 = BufferUtils.createDoubleBuffer(1);
    private long window;

    private boolean up, down;

    public MouseInput(long window) {
        this.window = window;
        glfwSetScrollCallback(window, new GLFWScrollCallback() {
            @Override
            public void invoke(long window, double xoffset, double yoffset) {
                up = 0 < yoffset;
                down = 0 > yoffset;
            }
        });
    }

    public boolean isLeftClick(){
        return glfwGetMouseButton(window, GLFW_MOUSE_BUTTON_LEFT) == GLFW_PRESS;
    }

    public boolean isWheelDown(){
        return down;
    }

    public boolean isWheelUp(){
        return up;
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
