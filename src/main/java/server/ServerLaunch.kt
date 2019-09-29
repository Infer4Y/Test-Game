package server

import common.Game
import common.world.World
import talaria.server.TalariaServerManager

object ServerLaunch {
    var lastLoopTime = System.nanoTime()
    var currentTime: Long = 0
    var deltaTime: Double = 0.toDouble()

    @JvmStatic
    fun main(args: Array<String>) {
        launchServer()
    }

    fun launchServer() {
        val serverManager = TalariaServerManager(TalariaServerManager.Properties())

        ServerGame.instance = ServerGame()

        serverManager.entityHandler.registerEntity(ServerWorld::class.java)

        serverManager.whileRunning = {
            currentTime = System.nanoTime()
            deltaTime += (currentTime - lastLoopTime) / Game.OPTIMAL_TIME
            lastLoopTime = currentTime

            while (deltaTime >= 1) {
                ServerGame.instance.update()
                deltaTime--
            }
        }

        serverManager.start()
    }
}