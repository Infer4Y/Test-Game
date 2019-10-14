package client.ui;

import client.renderables.Drawable;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Button implements Drawable {
    public int x, xBound, y, yBound;
    private ActionButton action;

    public Button(int x, int xBound, int y, int yBound, ActionButton action) {
        this.x = x;
        this.xBound = xBound;
        this.y = y;
        this.yBound = yBound;
        this.action = action;
    }

    public void onClick(int x, int y) {
        if ((x >= this.x && x <= (this.x+this.xBound))&&(y >= this.y && x <= (this.y+this.yBound))) {
            action.action();
        }
    }

    @Override
    public void draw(@NotNull Graphics g) {}
}
