package xavier.project_iodine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import org.mini2Dx.core.assets.FallbackFileHandleResolver;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.ui.UiContainer;
import org.mini2Dx.ui.UiThemeLoader;
import org.mini2Dx.ui.element.Button;
import org.mini2Dx.ui.element.Label;
import org.mini2Dx.ui.element.TextButton;
import org.mini2Dx.ui.element.Visibility;
import org.mini2Dx.ui.event.ActionEvent;
import org.mini2Dx.ui.listener.ActionListener;
import org.mini2Dx.ui.style.UiTheme;
import xavier.project_iodine.client.BlockOreRenderer;
import xavier.project_iodine.common.block.BlockOre;
import xavier.project_iodine.common.registries.Blocks;
import xavier.project_iodine.common.world.World;

import java.util.Random;

public class MainMenu extends BasicGameScreen {
    public static final int ID = 0;

    private UiContainer container;
    private TextButton button;

    //private float loadingTime = 10;

    private Random r = new Random();

    float x, y, rot, cout;

    public BlockOreRenderer[] ore_renderer;
    public BlockOreRenderer[][] ore_renderer1 = new BlockOreRenderer[256][256];
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
    private AssetManager assetManager;

    @Override
    public void initialise(GameContainer gc) {
        FileHandleResolver fileHandleResolver = new FallbackFileHandleResolver(new ClasspathFileHandleResolver(), new InternalFileHandleResolver());
        assetManager = new AssetManager(fileHandleResolver);

        assetManager.setLoader(UiTheme.class, new UiThemeLoader(fileHandleResolver));

        assetManager.load(UiTheme.DEFAULT_THEME_FILENAME, UiTheme.class);

        container = new UiContainer(800,600, assetManager);
        container.set(220, 20, 800,600);
        container.setVisibility(Visibility.VISIBLE);
        ore_renderer = new BlockOreRenderer[ores.length];
        for (int i = 0; i < ores.length; i++) {
            ore_renderer[i] = new BlockOreRenderer(ores[i]);
        }
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                ore_renderer1[i][j] = ore_renderer[r.nextInt(ores.length)];
            }
        }
        x = y = 0;
        button = new TextButton(160,160,1280-320,80);
        button.setText("Start World");
        button.addActionListener(new ActionListener() {
            @Override
            public void onActionBegin(ActionEvent event) {
                Game.instance.enterGameScreen(World.ID, null, null);
            }

            @Override
            public void onActionEnd(ActionEvent event) {

            }
        });
        button.setEnabled(true);
        button.setVisibility(Visibility.VISIBLE);
        container.add(button);
        Gdx.input.setInputProcessor(container);
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
        //x++; y++;
        //rot+=0.003;
        if (x==256*64){
             x = y = 0;
        }
        if(!assetManager.update()) {
            //Wait for asset manager to finish loading assets
            return;
        }
        if(!UiContainer.isThemeApplied()) {
            UiContainer.setTheme(assetManager.get(UiTheme.DEFAULT_THEME_FILENAME, UiTheme.class));
        }
        container.update(delta);
    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {
        container.interpolate(alpha);
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
        container.render(g);
    }

    @Override
    public int getId() {
        return ID;
    }
}
