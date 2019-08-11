package client.renderables;

import client.Game;

import java.awt.*;

public class Rain implements Drawable, Entity {
    private int x, y, size, speed, count;

    public Rain(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        speed = 10;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(61, 139, 255, 95));
        g.fillOval(x,y,size,size);
    }

    @Override
    public void tick() {
        if (count == (10 - speed)){
            count = 0;
            if (Game.world.getMapR()[(int) Math.floor(y/64)][(int) Math.floor(x/64)].getBlock().isSolid()){
                y = 0;
            } else {
                y++;
            }
        } else {
            count++;
        }
    }

    @Override
    public void second() {

    }
}

