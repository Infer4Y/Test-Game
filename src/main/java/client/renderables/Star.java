package client.renderables;

import client.Game;

import java.awt.*;

public class Star implements Drawable, Entity {
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
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x,y,size,size);
    }

    @Override
    public void tick() {
        if (count == (10 - speed)){
            count = 0;
            if (x <= 0) {
                x = Game.WIDTH - 1;
            } else {
                x--;
            }
        } else {
            count++;
        }
    }

    @Override
    public void second() {

    }
}
