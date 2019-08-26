package xavier.project_iodine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.mini2Dx.core.assets.FallbackFileHandleResolver;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.ui.UiContainer;
import org.mini2Dx.ui.UiThemeLoader;
import org.mini2Dx.ui.element.TextButton;
import org.mini2Dx.ui.element.Visibility;
import org.mini2Dx.ui.event.ActionEvent;
import org.mini2Dx.ui.event.EventTrigger;
import org.mini2Dx.ui.layout.HorizontalAlignment;
import org.mini2Dx.ui.listener.ActionListener;
import org.mini2Dx.ui.style.UiTheme;
import xavier.project_iodine.common.block.BlockOre;
import xavier.project_iodine.common.registries.Blocks;
import xavier.project_iodine.common.world.World;

import java.util.Random;

public class MainMenu extends BasicGameScreen {
    public static final int ID = 0;
    private UiContainer container;
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
    private AssetManager assetManager;

    @Override
    public void initialise(GameContainer gc) {

        FileHandleResolver fileHandleResolver = new FallbackFileHandleResolver(new ClasspathFileHandleResolver(), new InternalFileHandleResolver());
        assetManager = new AssetManager(fileHandleResolver);

        assetManager.setLoader(UiTheme.class, new UiThemeLoader(fileHandleResolver));

        assetManager.load(UiTheme.DEFAULT_THEME_FILENAME, UiTheme.class);

        container = new UiContainer(800,600,assetManager);
        container.set(220, 20, 800,600);
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                ore_renderer1[i][j] = ores[r.nextInt(ores.length)];
            }
        }
        x = y = 0;
        button = new TextButton();
        button.setText("Start World");
        button.set(240, 260, 800, 80);
        button.getLabel().set(0, 0, 800, 80);
        button.getLabel().setColor(Color.VIOLET);
        button.getLabel().setResponsive(true);
        button.setTextAlignment(HorizontalAlignment.CENTER);
        button.addActionListener(new ActionListener() {
            @Override
            public void onActionEnd(ActionEvent event) {
            }

            @Override
            public void onActionBegin(ActionEvent event) {
                if (event.getEventTrigger().equals(EventTrigger.LEFT_MOUSE_CLICK)) {
                    Game.world.generate();
                    Game.instance.enterGameScreen(World.ID, null, null);
                }
            }
        });
        button1 = new TextButton();
        button1.setText("Options");
        button1.set(240, 360, 390, 80);
        button1.getLabel().set(0, 0, 800, 80);
        button1.getLabel().setColor(Color.VIOLET);
        button1.getLabel().setResponsive(true);
        button1.setTextAlignment(HorizontalAlignment.CENTER);
        button1.addActionListener(new ActionListener() {
            @Override
            public void onActionEnd(ActionEvent event) {
            }

            @Override
            public void onActionBegin(ActionEvent event) {
                if (event.getEventTrigger().equals(EventTrigger.LEFT_MOUSE_CLICK)) {
                }
            }
        });
        button2 = new TextButton();
        button2.setText("Credits");
        button2.set(650, 360, 390, 80);
        button2.getLabel().set(0, 0, 800, 80);
        button2.getLabel().setColor(Color.VIOLET);
        button2.getLabel().setResponsive(true);
        button2.setTextAlignment(HorizontalAlignment.CENTER);
        button2.addActionListener(new ActionListener() {
            @Override
            public void onActionEnd(ActionEvent event) {
            }

            @Override
            public void onActionBegin(ActionEvent event) {
                if (event.getEventTrigger().equals(EventTrigger.LEFT_MOUSE_CLICK)) {
                }
            }
        });

        button3 = new TextButton();
        button3.setText("Exit");
        button3.set(240, 460, 800, 80);
        button3.getLabel().set(0, 0, 800, 80);
        button3.getLabel().setColor(Color.SCARLET);
        button3.getLabel().setResponsive(true);
        button3.setTextAlignment(HorizontalAlignment.CENTER);
        button3.addActionListener(new ActionListener() {
            @Override
            public void onActionEnd(ActionEvent event) {
            }

            @Override
            public void onActionBegin(ActionEvent event) {
                if (event.getEventTrigger().equals(EventTrigger.LEFT_MOUSE_CLICK)) {
                    Gdx.app.exit();
                }
            }
        });
        button.setEnabled(true);
        button.setVisibility(Visibility.VISIBLE);

        button1.setEnabled(true);
        button1.setVisibility(Visibility.VISIBLE);

        button2.setEnabled(true);
        button2.setVisibility(Visibility.VISIBLE);

        button3.setEnabled(true);
        button3.setVisibility(Visibility.VISIBLE);

        container.add(button);
        container.add(button1);
        container.add(button2);
        container.add(button3);

        container.setVisibility(Visibility.VISIBLE);
        Gdx.input.setInputProcessor(container);
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
        x++; y++;
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
