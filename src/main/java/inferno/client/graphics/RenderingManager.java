package inferno.client.graphics;

import inferno.client.GameEngine;
import inferno.client.TestGame;
import inferno.client.graphics.renderables.Drawable;
import inferno.client.graphics.renderables.entities.EntityRenderer;
import inferno.client.graphics.renderables.TextureHelper;
import inferno.client.graphics.renderables.tiles.TileRender;
import inferno.client.graphics.user_interface.HeadsUpDisplay;
import inferno.client.states.ClientGame;
import inferno.common.entities.Entity;
import inferno.common.world.World;
import inferno.utils.Bounds;
import inferno.utils.Referance;
import org.joml.Vector2f;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class RenderingManager {
    public TileRender tileRender = new TileRender();
    public EntityRenderer entityRender = new EntityRenderer();

    public Camera camera = new Camera(new Vector2f(7,-4), new Bounds(0,0, 20, 10));

    public ArrayList<Drawable> drawables = new ArrayList<>();

    private HeadsUpDisplay headsUpDisplay = new HeadsUpDisplay();


    public void render(World world) {
        camera.centerOnEntity(GameEngine.userInstance);

        TextureHelper.draw(ClientGame.textures.background, 0,0, Referance.WIDTH, Referance.HEIGHT);

        camera.translate();

        for (Entity entity : world.getEntities()){
            entityRender.setEntity(entity);
            entityRender.draw(entity.getLocation().x* Referance.TEXTURE_UNIT, entity.getLocation().y* Referance.TEXTURE_UNIT);
            if (TestGame.isDebug()){
                debugEntity(entity);
            }
        }

        for (Drawable draw : drawables) {
            draw.draw(0,0);
        }

        drawables.clear();

        camera.unTranslate();

        headsUpDisplay.draw(0,0);
    }

    private void debugEntity(Entity entity){
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(1,entity.getLocation().x/16f,0);
        GL11.glLineWidth(4f);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f(entity.getLocation().x*Referance.TEXTURE_UNIT, entity.getLocation().y*Referance.TEXTURE_UNIT-Referance.TEXTURE_UNIT);
        GL11.glVertex2f(entity.getLocation().x*Referance.TEXTURE_UNIT, (entity.getLocation().y + entity.getBounds().height)*Referance.TEXTURE_UNIT-Referance.TEXTURE_UNIT);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f((entity.getLocation().x+ entity.getBounds().width)*Referance.TEXTURE_UNIT, (entity.getLocation().y)*Referance.TEXTURE_UNIT-Referance.TEXTURE_UNIT);
        GL11.glVertex2f((entity.getLocation().x+ entity.getBounds().width)*Referance.TEXTURE_UNIT, (entity.getLocation().y + entity.getBounds().height)*Referance.TEXTURE_UNIT-Referance.TEXTURE_UNIT);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f((entity.getLocation().x+ entity.getBounds().width)*Referance.TEXTURE_UNIT, (entity.getLocation().y + entity.getBounds().height)*Referance.TEXTURE_UNIT-Referance.TEXTURE_UNIT);
        GL11.glVertex2f(entity.getLocation().x*Referance.TEXTURE_UNIT, (entity.getLocation().y + entity.getBounds().height)*Referance.TEXTURE_UNIT-Referance.TEXTURE_UNIT);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f((entity.getLocation().x+ entity.getBounds().width)*Referance.TEXTURE_UNIT, (entity.getLocation().y)*Referance.TEXTURE_UNIT-Referance.TEXTURE_UNIT);
        GL11.glVertex2f(entity.getLocation().x*Referance.TEXTURE_UNIT, (entity.getLocation().y)*Referance.TEXTURE_UNIT-Referance.TEXTURE_UNIT);
        GL11.glEnd();
    }

}
