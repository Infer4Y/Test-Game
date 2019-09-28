package common.world;

import talaria.common.entity.NetworkEntity;

import java.awt.*;
abstract public class World extends NetworkEntity {

    public World (String name, int x, int y) {}

    public abstract  void draw(Graphics g);

    public abstract void update();

}
