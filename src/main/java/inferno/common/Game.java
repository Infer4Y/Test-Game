package inferno.common;

import inferno.common.world.World;

public class Game {
    protected World world;

    public Game() {
        world = new World("world_one");

    }

    public void update(){
        world.update();
    }


}
