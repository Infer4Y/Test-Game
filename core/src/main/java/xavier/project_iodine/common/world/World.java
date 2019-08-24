package xavier.project_iodine.common.world;

import com.badlogic.gdx.graphics.Color;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.viewport.FillViewport;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;

public class World extends BasicGameScreen {
    public static final int ID = 1;
    private String name;
    private int x, y;
    private int time;
    private FillViewport viewport;

    public World (String name, int x, int y){
        this.x = x;
        this.y = y;
        this.name = name;
        time = 1199;
    }

    public void draw(Graphics g){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return x;
    }

    public int getHeight(){
        return y;
    }

    public int getTime() {
        return time;
    }

    @Override
    public void initialise(GameContainer gc) {
        viewport = new FillViewport(gc.getWidth(), gc.getHeight());
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {

    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {

    }

    @Override
    public void render(GameContainer gc, Graphics g) {

    }

    @Override
    public int getId() {
        return ID;
    }
}
