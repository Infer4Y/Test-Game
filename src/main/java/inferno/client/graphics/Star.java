package inferno.client.graphics;

import inferno.client.graphics.renderables.Drawable;

import java.awt.*;

public class Star implements UpdateableObject {
    private int x, y, size, speed, count;

    public Star(int x, int y, int size, int speed) {
        this.x = x;
        this.y = y;
        this.size = size;
        if (speed > 10) {
            this.speed = 10;
        } else if (speed >=0){
            this.speed = speed;
        }else {
            this.speed = 0;
        }
    }

    @Override
    public void tick() {
        if (count == (10 - speed)){
            count = 0;
            if (x <= 0) {
                x = - 1;
            } else {
                x--;
            }
        } else {
            count++;
        }
    }

    @Override
    public void second() {}
}
