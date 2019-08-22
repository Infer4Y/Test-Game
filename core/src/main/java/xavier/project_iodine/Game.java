package xavier.project_iodine;

import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.core.graphics.Graphics;
import xavier.project_iodine.client.Sounds;
import xavier.project_iodine.client.Textures;
import xavier.project_iodine.common.registries.Blocks;
import xavier.project_iodine.common.registries.Items;
import xavier.project_iodine.common.registries.Recipes;
import xavier.project_iodine.common.world.World;

public class Game extends ScreenBasedGame {
	public static final String GAME_IDENTIFIER = "xavier.project-iodine";

    public static World world;

    float ballY = 0f, max = 0f, ballX = 0f;
    float tileSize = 64f;
    private float direction = 1f;



    @Override
    public void initialise() {
        Sounds.init();
        Blocks.init();
        Items.init();
        Recipes.init();
        Textures.init(Items.ITEM_MAP, Blocks.BLOCK_MAP);
    }

    @Override
    public int getInitialScreenId() {
        return 0;
    }

    @Override
    public void update(float delta) {
    
    }
    
    @Override
    public void interpolate(float alpha) {
    
    }
    
    @Override
    public void render(Graphics g) {
        for (int i = 0; i < 20; i++) {
            g.drawTexture(Textures.getTexture("launcher"), i * tileSize ,640f-tileSize, tileSize ,tileSize);
        }

        g.drawTexture(Textures.ball, ballX ,ballY, tileSize ,tileSize);
        ballY+=((9.85f)*direction);
        if (ballY >= 640f-tileSize*2){
            direction = -0.5f;
        }

        direction+=0.003f;
        ballX+=0.75f;

        if (ballX >= 1280f+tileSize){
            ballX=(-tileSize)+1;
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        Textures.dispose();
    }
}
