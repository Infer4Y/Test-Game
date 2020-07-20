package inferno.client.graphics.user_interface;

import org.joml.AABBf;
import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;

public class Button {
    private Vector4f color = new Vector4f(1,1,1,.75f);
    private AABBf bounds;

    public Button(Vector4f color, AABBf bounds) {
        this.color = color;
        this.bounds = bounds;
        bounds.maxZ = 1f;
        bounds.minZ = 0f;
    }

    public Button(AABBf bounds) {
        this.bounds = bounds;
        bounds.maxZ = 1f;
        bounds.minZ = 0f;
    }

    public void draw(){
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glBegin(GL11.GL_TRIANGLES);
            GL11.glColor3f(color.x, color.y, color.z);
            GL11.glVertex2f(bounds.minX,bounds.minY);
            GL11.glVertex2f(bounds.maxX,bounds.minY);
            GL11.glVertex2f(bounds.maxX,bounds.maxY);
            GL11.glVertex2f(bounds.maxX,bounds.maxY);
            GL11.glVertex2f(bounds.minX,bounds.maxY);
            GL11.glVertex2f(bounds.minX,bounds.minY);
        GL11.glEnd();

        //GL11.glRectf(bounds.minX, bounds.minY, bounds.maxX, bounds.maxY);
    }

    public boolean isPointInBounds(Vector2f point){
        return bounds.testPoint(point.x, point.y, .5f);
    }

    public void setColor(Vector4f color) {
        this.color = color;
    }
}
