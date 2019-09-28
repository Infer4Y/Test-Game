package client;

import kotlin.Unit;
import talaria.client.TalariaClientManager;

public class ClientLaunch {

    public static void main(String[] args) {
        TalariaClientManager clientManager = new TalariaClientManager(new TalariaClientManager.Properties());

        Game.instance = new Game();
        clientManager.setWhileRunning(running -> {
            Game.instance.update();
            return Unit.INSTANCE;
        });

        clientManager.start();
    }
}