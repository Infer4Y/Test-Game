package xavier.project_iodine.common.world;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.viewport.FillViewport;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import xavier.project_iodine.common.block.Block;
import xavier.project_iodine.common.registries.Blocks;
import xavier.project_iodine.utils.Logger;

public class World extends BasicGameScreen {
    private Block[][] layer0, layer1, layer2;
    public static final int ID = 1;
    private String name;
    private int x, y, xOff, yOff;
    private int time;
    private FillViewport viewport;

    public World (String name, int x, int y){
        this.x = x;
        this.y = y;
        this.name = name;
        time = 1199;

        yOff = (256*64)/2;
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
        yOff--; xOff++;
        if (yOff <= 0){
            yOff = 256*64;
        }
        if (xOff >= 256*64){
            xOff = 0;
        }
    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {

    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        //g.fillRect(0,0, 1280, 640);
        g.enableBlending();
        for (int i = 0; i < layer2.length; i++) {
            for (int j = 0; j < layer2[i].length; j++) {
                if ((i * 64 - xOff >= -128 && i * 64 - xOff <= gc.getWidth() +128) && (j * 64 - yOff >= -128 && j * 64 - yOff <= gc.getHeight() +128) && layer1[i][j] != null) {
                    layer1[i][j].draw(g, i * 64 - xOff, j * 64 - yOff);
                }
                if ((i * 64 - xOff >= -128 && i * 64 - xOff <= gc.getWidth() +128) && (j * 64 - yOff >= -128 && j * 64 - yOff <= gc.getHeight() +128) && layer2[i][j] != null) {
                    layer2[i][j].draw(g, i * 64 - xOff, j * 64 - yOff);
                }
            }
        }
    }

    @Override
    public int getId() {
        return ID;
    }

    public void generate() {
        layer2 = new Block[y][x]; layer1 = new Block[y][x]; layer0 = new Block[y][x];
        for (int i = 0; i < layer1.length; i++) {
            for (int j = 0; j < layer1[i].length; j++) {
                layer1[i][j] = Blocks.dirt;
            }
        }
        for (int i = 0; i < layer2.length; i++) {
            for (int j = 0; j < layer2[i].length; j++) {
                if (i % 2 == 0) {
                    layer2[i][j] = Blocks.air;
                } else {
                    layer2[i][j] = Blocks.air;
                }
            }
        }
    }
}
