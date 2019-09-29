package server

import common.Game
import talaria.common.Talaria

class ServerGame : Game() {

    var world: ServerWorld = ServerWorld("foo", 0, 0)

    /**
     * Updates the world.
     */
    override fun update() {
        world.update()
        // This will sync the clients to the server.
        Talaria.server?.sendEntityToAll(world)
    }

    companion object {

        @JvmStatic
        lateinit var instance: ServerGame
    }
}
