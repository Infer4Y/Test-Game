package inferno.client;

import inferno.client.states.ClientGame;
import inferno.client.states.MenuState;
import inferno.client.states.State;
import inferno.client.user_interface.GLFWWindow;
import inferno.client.user_interface.KeyboardInput;
import inferno.client.user_interface.MouseInput;
import inferno.common.entities.Entity;
import inferno.common.entities.Player;
import inferno.common.registries.Entities;
import inferno.common.registries.Items;
import inferno.common.registries.Tiles;
import inferno.utils.Referance;
import org.joml.Vector2f;

import static inferno.client.states.ClientGame.textures;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class GameEngine {

    protected Timer timer;

    private GLFWWindow window;
    private ClientGame clientGame;
    public static Player userInstance;
    private KeyboardInput keyboardInput;
    private MouseInput mouseInput;

    private State currentState;
    private MenuState menuState;
    private boolean running;

    public GameEngine() {
        this.timer = new Timer();
    }

    public void begin(){
        window = new GLFWWindow(Referance.WIDTH, Referance.HEIGHT, Referance.NAME+" | "+Referance.VERSION) {
            @Override
            protected void render() {
                if (currentState != null) {
                    currentState.render();
                }
            }
        };


        Tiles.init();
        Items.init();
        Entities.init();

        textures.init();

        userInstance = Entities.cloneEntity(Entities.player);
        userInstance.setDisplayName("Test Player!");
        userInstance.setLocation(new Vector2f(7,4f));


        this.keyboardInput = new KeyboardInput(window.getWindowId());
        this.mouseInput = new MouseInput(window.getWindowId());

        this.menuState = new MenuState();
        this.clientGame = new ClientGame();

        this.currentState = menuState;

        this.clientGame.getWorld().addEntity(userInstance);

        setRunning(true);

        loop();
    }

    private void loop(){
        while (this.isRunning()) {
            float delta = timer.getDelta();

            if (currentState != null) {
                currentState.update();
            }

            window.update();

            if (glfwWindowShouldClose(window.getWindowId())) {
                setRunning(currentState.requestShutdown());
            }
        }
    }

    private void update(){
        clientGame.update();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public KeyboardInput getKeyboardInput() {
        return keyboardInput;
    }

    public MouseInput getMouseInput() {
        return mouseInput;
    }

    public void startGame() {
        currentState = clientGame;
    }
}
