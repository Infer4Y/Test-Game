package client;

import kotlin.Unit;
import server.ServerLaunch;
import talaria.client.TalariaClientManager;

public class ClientLaunch {

    public static void main(String[] args) {

        // This will act as the internal server for the client.
        // When the client wants to host, this server will unbind and rebind to another address and port.
        ServerLaunch.INSTANCE.launchServer();

        TalariaClientManager clientManager = new TalariaClientManager(new TalariaClientManager.Properties());

        Game.instance = new Game();
        clientManager.setWhileRunning(running -> {
            Game.instance.update();
            return Unit.INSTANCE;
        });

        clientManager.start();
    }
}