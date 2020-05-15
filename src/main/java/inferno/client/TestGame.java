package inferno.client;

public class TestGame {
    private static GameEngine engine;

    public static void main(String[] args){
        engine = new GameEngine();
        engine.begin();
    }
}
