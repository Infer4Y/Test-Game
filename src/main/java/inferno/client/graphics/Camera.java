package inferno.client.graphics;

import inferno.common.entities.Entity;
import inferno.utils.Bounds;
import inferno.utils.Referance;
import org.joml.AABBf;
import org.joml.Vector2f;
import org.lwjgl.opengl.GL11;

public class Camera {
    private Vector2f location, force = new Vector2f(0,0);
    private Bounds boundingBox;

    public Camera(Vector2f location, Bounds boundingBox){
        this.location = location;
        this.boundingBox = boundingBox;
    }

    public Camera(Entity entity, Bounds boundingBox){
        this.location = entity.getLocation();
        this.boundingBox = boundingBox;
    }

    public void centerOnEntity(Entity entity) {
        this.location = new Vector2f( entity.getLocation().x - boundingBox.width/2f, entity.getLocation().y - boundingBox.height/2f);
    }

    public Vector2f getLocation() {
        return location;
    }

    public Bounds getBoundingBox() {
        return boundingBox;
    }

    public void translate() {
        GL11.glTranslatef(-Referance.TEXTURE_UNIT*location.x, -Referance.TEXTURE_UNIT*location.y, 0f);
    }

    public void unTranslate() {
        GL11.glTranslatef(Referance.TEXTURE_UNIT*location.x, Referance.TEXTURE_UNIT*location.y, 0f);
    }
}
