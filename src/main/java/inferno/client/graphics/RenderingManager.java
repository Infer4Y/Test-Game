package inferno.client.graphics;

import inferno.client.GameEngine;
import inferno.client.TestGame;
import inferno.client.graphics.renderables.EntityRenderer;
import inferno.client.graphics.renderables.TextureHelper;
import inferno.client.graphics.renderables.TileRender;
import inferno.client.states.ClientGame;
import inferno.common.entities.Entity;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import inferno.utils.Bounds;
import inferno.utils.Referance;
import org.joml.Vector2f;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class RenderingManager {
    public TileRender tileRender = new TileRender();
    public EntityRenderer entityRender = new EntityRenderer();

    public Camera camera = new Camera(new Vector2f(7,-4), new Bounds(0,0, 20, 10));


    public void render(World world) {
        camera.centerOnEntity(GameEngine.userInstance);

        ArrayList<Chunk> chunksToRender = new ArrayList<>();
        chunksToRender.add(world.getChunkFromPos(GameEngine.userInstance.getLocation()));
        chunksToRender.add(world.getChunkFromPos(GameEngine.userInstance.getLocation().add(Referance.CHUNKWIDTH, 0)));
        chunksToRender.add(world.getChunkFromPos(GameEngine.userInstance.getLocation().add(-Referance.CHUNKWIDTH, 0)));
        chunksToRender.add(world.getChunkFromPos(GameEngine.userInstance.getLocation().add(0, Referance.CHUNKHEIGHT)));
        chunksToRender.add(world.getChunkFromPos(GameEngine.userInstance.getLocation().add(0, -Referance.CHUNKHEIGHT)));
        chunksToRender.add(world.getChunkFromPos(GameEngine.userInstance.getLocation().add(Referance.CHUNKWIDTH, -Referance.CHUNKHEIGHT)));
        chunksToRender.add(world.getChunkFromPos(GameEngine.userInstance.getLocation().add(-Referance.CHUNKWIDTH, -Referance.CHUNKHEIGHT)));
        chunksToRender.add(world.getChunkFromPos(GameEngine.userInstance.getLocation().add(-Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT)));
        chunksToRender.add(world.getChunkFromPos(GameEngine.userInstance.getLocation().add(Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT)));

        TextureHelper.draw(ClientGame.textures.background, 0,0, Referance.WIDTH, Referance.HEIGHT);

        camera.translate();

        for ( Chunk chunkToRender : chunksToRender) {
            if (chunkToRender != null) {
                for (int y = 0; y < Referance.CHUNKHEIGHT; y++) {
                    for (int x = 0; x < Referance.CHUNKWIDTH; x++) {
                        tileRender.setTile(chunkToRender.getTile(x, y));
                        tileRender.draw((chunkToRender.getOffset().x*Referance.CHUNKWIDTH + x) * Referance.TEXTURE_UNIT, (chunkToRender.getOffset().y*Referance.CHUNKHEIGHT + y) * Referance.TEXTURE_UNIT);
                    }
                }
                if (TestGame.isDebug()){
                    debugChunkLines(chunkToRender);
                }
            }
        }

        for (Entity entity : world.getEntities()){
            entityRender.setEntity(entity);
            entityRender.draw(entity.getLocation().x* Referance.TEXTURE_UNIT, entity.getLocation().y* Referance.TEXTURE_UNIT);
        }

        camera.unTranslate();
    }

    private void debugChunkLines(Chunk chunkToRender){
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(1,chunkToRender.getOffset().x/256f,0);
        GL11.glLineWidth(4f);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f(chunkToRender.getOffset().x*Referance.CHUNKWIDTH*Referance.TEXTURE_UNIT, chunkToRender.getOffset().y*Referance.CHUNKWIDTH*Referance.TEXTURE_UNIT);
        GL11.glVertex2f((chunkToRender.getOffset().x*Referance.CHUNKWIDTH)*Referance.TEXTURE_UNIT, (chunkToRender.getOffset().y*Referance.CHUNKWIDTH + Referance.CHUNKHEIGHT)*Referance.TEXTURE_UNIT);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f((chunkToRender.getOffset().x*Referance.CHUNKWIDTH+ Referance.CHUNKWIDTH)*Referance.TEXTURE_UNIT, chunkToRender.getOffset().y*Referance.CHUNKWIDTH*Referance.TEXTURE_UNIT);
        GL11.glVertex2f((chunkToRender.getOffset().x*Referance.CHUNKWIDTH+ Referance.CHUNKWIDTH)*Referance.TEXTURE_UNIT, (chunkToRender.getOffset().y*Referance.CHUNKWIDTH + Referance.CHUNKHEIGHT)*Referance.TEXTURE_UNIT);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f(chunkToRender.getOffset().x*Referance.CHUNKWIDTH*Referance.TEXTURE_UNIT, (chunkToRender.getOffset().y*Referance.CHUNKWIDTH + Referance.CHUNKHEIGHT)*Referance.TEXTURE_UNIT);
        GL11.glVertex2f((chunkToRender.getOffset().x*Referance.CHUNKWIDTH+ Referance.CHUNKWIDTH)*Referance.TEXTURE_UNIT, (chunkToRender.getOffset().y*Referance.CHUNKWIDTH + Referance.CHUNKHEIGHT)*Referance.TEXTURE_UNIT);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f((chunkToRender.getOffset().x*Referance.CHUNKWIDTH)*Referance.TEXTURE_UNIT, chunkToRender.getOffset().y*Referance.TEXTURE_UNIT);
        GL11.glVertex2f((chunkToRender.getOffset().x*Referance.CHUNKWIDTH + Referance.CHUNKWIDTH)*Referance.TEXTURE_UNIT, (chunkToRender.getOffset().y*Referance.CHUNKWIDTH)*Referance.TEXTURE_UNIT);
        GL11.glEnd();
    }
}
