package inferno.utils;

import org.joml.Vector2f;

public class Bounds {
    public float x, y, width, height;

    public Bounds (Vector2f pos, Vector2f size){
        this(pos.x, pos.y, size.x, size.y);
    }

    public Bounds(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isPosIn(Vector2f pos) {
        return ((pos.x >= x) &&
                (pos.x <= x + width) &&
                (pos.y >= y) &&
                (pos.y <= y + height));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
