package inferno.client.user_interface;

import org.joml.Vector2d;
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

    private double currentMouseWheel;

    public MouseInput(long window) {
        this.window = window;
        glfwSetScrollCallback(window, new GLFWScrollCallback() {
            @Override
            public void invoke(long window, double xoffset, double yoffset) {
                currentMouseWheel  = yoffset;
            }
        });
    }

    public boolean isLeftClick(){
        return glfwGetMouseButton(window, GLFW_MOUSE_BUTTON_LEFT) == GLFW_PRESS;
    }

    public boolean isWheelDown(){
        float test = (float) currentMouseWheel;
        return test < 0;
    }

    public boolean isWheelUp(){
        float test = (float) currentMouseWheel;
        return test > 0;
    }

    public void resetWheel(){
        currentMouseWheel = 0;
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
