package inferno.client.states;

public interface State {
    void render();
    void update();

    boolean requestShutdown();
}
