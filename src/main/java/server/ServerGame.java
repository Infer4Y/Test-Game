package server;

import common.Game;
import talaria.common.Talaria;

public class ServerGame extends Game {

    public static ServerGame instance = null;

    public ServerWorld world;

    /**
     * Updates the world.
     */
    public ServerGame() {
        world = new ServerWorld("foo", 0, 0);
    }

    /**
     * Updates the world.
     */
    public void update() {
        world.update();
        // This will sync the clients to the server.
        Talaria.INSTANCE.getServer().sendEntityToAll(world);
    }
}
