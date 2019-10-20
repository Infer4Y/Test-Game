package client

import bvanseg.talaria.client.ClientProperties
import bvanseg.talaria.client.TalariaClientManager
import common.Game
import server.ServerLaunch

object ClientLaunch {
    var lastLoopTime = System.nanoTime()
    var currentTime: Long = 0
    var deltaTime: Double = 0.0

    @JvmStatic
    fun main(args: Array<String>) {

        // This will act as the internal server for the client.
        // When the client wants to host, this server will unbind and rebind to another address and port.
        ServerLaunch.launchServer()

        val clientManager = TalariaClientManager(ClientProperties())

        clientManager.entityHandler.registerEntity(ClientWorld::class.java)

        ClientGame.instance = ClientGame()
        clientManager.whileRunning = {
            currentTime = System.nanoTime()
            deltaTime += (currentTime - lastLoopTime) / Game.OPTIMAL_TIME
            lastLoopTime = currentTime

            while (ServerLaunch.deltaTime >= 1) {
                ClientGame.instance.update()
                deltaTime--
            }
        }
        clientManager.start()

    }
}