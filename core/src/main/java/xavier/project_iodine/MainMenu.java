package xavier.project_iodine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.ui.style.UiTheme;
import xavier.project_iodine.common.block.BlockOre;
import xavier.project_iodine.common.registries.Blocks;
import xavier.project_iodine.common.world.World;

import java.util.Random;

public class MainMenu extends BasicGameScreen {
    public static final int ID = 0;

    private FitViewport viewport;
    private Stage stage;
    private TextButton button, button1, button2, button3;
    private UiTheme theme = new UiTheme();

    //private float loadingTime = 10;

    private Random r = new Random();

    float x, y, rot, cout;

    public BlockOre[][] ore_renderer1 = new BlockOre[256][256];
    public static BlockOre[] ores =
            {
                    Blocks.ore_coal,
                    Blocks.ore_copper,
                    Blocks.ore_diamond,
                    Blocks.ore_iron,
                    Blocks.ore_gold,
                    Blocks.ore_tin,
                    Blocks.ore_silver,
                    Blocks.ore_ruby
            };
    private Skin skin;

    @Override
    public void initialise(GameContainer gc) {
        viewport = new FitViewport(gc.getWidth(), gc.getHeight());
        stage = new Stage();
        stage.setViewport(viewport);
        viewport.getCamera().translate(new Vector3(640, 320,0));
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                ore_renderer1[i][j] = ores[r.nextInt(ores.length)];
            }
        }
        x = y = 0;
        button = new TextButton("Start World",skin);
        button.setBounds(240, 320, 800, 80);
        button.setColor(Color.CHARTREUSE);
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Game.world.generate();
                Game.instance.enterGameScreen(World.ID, null, null);
            }
        });
        button1 = new TextButton("Options",skin);
        button1.setBounds(240, 220, 390, 80);
        button1.setColor(Color.GOLDENROD);
        button1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
            }
        });
        button2 = new TextButton("Credits",skin);
        button2.setBounds(650, 220, 390, 80);
        button2.setColor(Color.TAN);
        button2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
            }
        });

        button3 = new TextButton("Exit",skin);
        button3.setBounds(240, 120, 800, 80);
        button3.setColor(Color.RED);
        button3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });
        stage.addActor(button);
        stage.addActor(button1);
        stage.addActor(button2);
        stage.addActor(button3);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
        x++; y++;
        //rot+=0.003;
        if (x==256*64){
             x = y = 0;
        }
        viewport.update(gc.getWidth(), gc.getHeight());
    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        g.rotate(-rot, 640, 320);
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                if ((i * 64 - x >= -128 && i * 64 - x <= gc.getWidth() +128) && (j * 64 - y >= -128 && j * 64 - y <= gc.getHeight() +128)) {
                    ore_renderer1[i][j].draw(g, i * 64 - x, j * 64 - y);
                }
            }
        }
        g.rotate(rot, 640, 320);
        stage.draw();
    }

    @Override
    public int getId() {
        return ID;
    }
}
