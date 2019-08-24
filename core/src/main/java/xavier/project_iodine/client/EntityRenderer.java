package xavier.project_iodine.client;

import org.mini2Dx.core.graphics.Graphics;
import xavier.project_iodine.common.entities.Entity;

public class EntityRenderer extends Renderer{
    private Entity entity;

    public EntityRenderer(int layer, Entity entity) {
        super(layer);
        this.entity = entity;
    }

    public EntityRenderer(Entity entity) {
        super(2);
        this.entity = entity;
    }

    @Override
    public void draw(Graphics g, float x, float y) {
        //g.drawRect(x,y,entity.getAABB(), entity.getAABB());
    }
}
