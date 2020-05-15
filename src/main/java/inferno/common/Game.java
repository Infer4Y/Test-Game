package inferno.common;

import inferno.common.world.World;

public class Game {
    protected World world;
    private boolean running;

    public Game() {
        world = new World("world_one");
        running = true;
    }

    public void update(){
        world.update();
    }


    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
