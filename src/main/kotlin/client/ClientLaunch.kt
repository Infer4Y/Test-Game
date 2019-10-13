package client

import common.Game
import server.ServerLaunch
import talaria.client.TalariaClientManager

object ClientLaunch {
    var lastLoopTime = System.nanoTime()
    var currentTime: Long = 0
    var deltaTime: Double = 0.0

    @JvmStatic
    fun main(args: Array<String>) {

        // This will act as the internal server for the client.
        // When the client wants to host, this server will unbind and rebind to another address and port.
        ServerLaunch.launchServer()

        val clientManager = TalariaClientManager(TalariaClientManager.Properties())

        clientManager.entityHandler.registerEntity(ClientWorld::class.java)

        ClientGame.instance = ClientGame()
        ClientGame.instance.createWindow()
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