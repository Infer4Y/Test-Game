package client;

import common.world.World;

import java.awt.*;

public class ClientWorld extends World {
    public ClientWorld(String name, int x, int y) {
        super(name, x, y);
    }

    /** Worlds shouldn't be doing any drawing. your Render manager should be **/
    @Deprecated
    public void draw(Graphics g) {

    }

    @Override
    public void update() {

    }
}
