package server;

import kotlin.Unit;
import talaria.server.TalariaServerManager;

public class ServerLaunch {

    public static void main(String[] args) {
        TalariaServerManager serverManager = new TalariaServerManager(new TalariaServerManager.Properties());

        ServerGame.instance = new ServerGame();
        serverManager.setWhileRunning(running -> {
            ServerGame.instance.update();
            return Unit.INSTANCE;
        });

        serverManager.start();
    }
}