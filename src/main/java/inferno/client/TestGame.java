package inferno.client;

public class TestGame {
    private static GameEngine engine;
    private static boolean debug;

    public static void main(String[] args){
        if (args != null){
            for (String arg : args){
                if (arg.equalsIgnoreCase("debug")){
                    debug = true;
                }
            }
        }
        engine = new GameEngine();
        engine.begin();
    }

    public static GameEngine getEngine() {
        return engine;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        TestGame.debug = debug;
    }
}
