package inferno.client.graphics;

import org.joml.AABBf;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class PhysicsObject implements UpdateableObject {
    private Vector2f location, force;
    private AABBf boundingBox;

    public PhysicsObject(Vector2f location, AABBf boundingBox) {
        this.location = location;
        this.force = new Vector2f();
        this.boundingBox = boundingBox;
    }

    public PhysicsObject(Vector2f location) {
        this.location = location;
        this.force = new Vector2f();
        this.boundingBox = new AABBf(new Vector3f(0,0,0), new Vector3f(0,0,0));
    }



    @Override
    public void tick() {

    }

    @Override
    public void second() {

    }
}
