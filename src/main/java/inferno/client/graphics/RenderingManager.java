package inferno.client.graphics;

import inferno.client.graphics.renderables.EntityRenderer;
import inferno.client.graphics.renderables.TileRender;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import inferno.utils.Referance;
import org.joml.Vector2f;

public class RenderingManager {
    public TileRender tileRender = new TileRender();
    public EntityRenderer entityRender = new EntityRenderer();


    public void render(World world) {
        Chunk render = world.getChunkFromPos(new Vector2f(0,0));
        if (render == null) {return;}

        for (int y = 0; y < Referance.CHUNKHEIGHT; y++){
            for (int x = 0; x < Referance.CHUNKWIDTH; x++) {
                tileRender.setTile(render.getTile(x, y));
                tileRender.draw((render.getOffset().x + x) * Referance.TEXTURE_UNIT, (render.getOffset().y + y) * Referance.TEXTURE_UNIT);
            }
        }
    }
}
