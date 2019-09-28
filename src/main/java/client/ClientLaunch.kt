package client

import server.ServerLaunch
import talaria.client.TalariaClientManager

object ClientLaunch {

    @JvmStatic
    fun main(args: Array<String>) {

        // This will act as the internal server for the client.
        // When the client wants to host, this server will unbind and rebind to another address and port.
        ServerLaunch.launchServer()

        val clientManager = TalariaClientManager(TalariaClientManager.Properties())

        Game.instance = Game()
        clientManager.whileRunning = {
            Game.instance.update()
        }

        clientManager.start()
    }
}