package inferno.client.graphics;

import inferno.common.entities.Entity;
import inferno.utils.Bounds;
import org.joml.AABBf;
import org.joml.Vector2f;

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
        this.location = entity.getLocation();
    }



    public Vector2f getLocation() {
        return location;
    }

    public Bounds getBoundingBox() {
        return boundingBox;
    }
}
