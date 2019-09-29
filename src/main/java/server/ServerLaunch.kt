package server

import common.world.World
import talaria.server.TalariaServerManager

object ServerLaunch {

    @JvmStatic
    fun main(args: Array<String>) {
        launchServer()
    }

    fun launchServer() {
        val serverManager = TalariaServerManager(TalariaServerManager.Properties())

        ServerGame.instance = ServerGame()

        serverManager.entityHandler.registerEntity(World::class.java)

        serverManager.whileRunning = {
            ServerGame.instance.update()
        }

        serverManager.start()
    }
}