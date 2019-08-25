package xavier.project_iodine.common.world;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.viewport.FillViewport;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import xavier.project_iodine.common.block.Block;
import xavier.project_iodine.common.registries.Blocks;

public class World extends BasicGameScreen {
    private Block[][] layer0, layer1, layer2;
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
        for (int i = 0; i < layer1.length; i++) {
            for (int j = 0; j < layer1[i].length; j++) {
                if ((i * 64 - x >= -128 && i * 64 - x <= gc.getWidth() +128) && (j * 64 - y >= -128 && j * 64 - y <= gc.getHeight() +128)) {
                    layer1[i][j].draw(g, i * 64 - x, j * 64 - y);
                }
            }
        }
        for (int i = 0; i < layer2.length; i++) {
            for (int j = 0; j < layer2[i].length; j++) {
                if ((i * 64 - x >= -128 && i * 64 - x <= gc.getWidth() +128) && (j * 64 - y >= -128 && j * 64 - y <= gc.getHeight() +128)) {
                    layer2[i][j].draw(g, i * 64 - x, j * 64 - y);
                }
            }
        }
    }

    @Override
    public int getId() {
        return ID;
    }

    public void generate() {
        layer2 = layer1 = layer0 = new Block[y][x];
        for (int i = 0; i < layer1.length; i++) {
            for (int j = 0; j < layer1[i].length; j++) {
                layer1[i][j] = Blocks.air;
            }
        }
        for (int i = 0; i < layer2.length; i++) {
            for (int j = 0; j < layer2[i].length; j++) {
                layer2[i][j] = Blocks.air;
            }
        }
    }
}
