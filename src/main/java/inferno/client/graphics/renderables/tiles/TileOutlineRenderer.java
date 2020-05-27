package inferno.client.graphics.renderables.tiles;

import inferno.client.graphics.renderables.Drawable;
import inferno.utils.Referance;
import org.joml.Vector2f;
import org.lwjgl.opengl.GL11;

public class TileOutlineRenderer implements Drawable {
    private Vector2f location = new Vector2f();

    public TileOutlineRenderer ( Vector2f location){
        this.location = location;
    }

    private void glDraw(float x, float y) {
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(1,location.x/16f,location.y/16f);
        GL11.glLineWidth(4f);

        GL11.glRectf(location.x* Referance.TEXTURE_UNIT,location.y*Referance.TEXTURE_UNIT, Referance.TEXTURE_UNIT, Referance.TEXTURE_UNIT);
    }

    public void setLocation(Vector2f location) {
        this.location = location;
    }

    @Override
    public void draw(float x, float y) {
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(1,location.x/16f,0);
        GL11.glLineWidth(4f);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f(location.x*Referance.TEXTURE_UNIT, location.y*Referance.TEXTURE_UNIT);
        GL11.glVertex2f(location.x*Referance.TEXTURE_UNIT, (location.y)*Referance.TEXTURE_UNIT+Referance.TEXTURE_UNIT);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f((location.x)*Referance.TEXTURE_UNIT+Referance.TEXTURE_UNIT, (location.y)*Referance.TEXTURE_UNIT);
        GL11.glVertex2f((location.x)*Referance.TEXTURE_UNIT+Referance.TEXTURE_UNIT, (location.y)*Referance.TEXTURE_UNIT+Referance.TEXTURE_UNIT);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f((location.x)*Referance.TEXTURE_UNIT+Referance.TEXTURE_UNIT, (location.y)*Referance.TEXTURE_UNIT+Referance.TEXTURE_UNIT);
        GL11.glVertex2f(location.x*Referance.TEXTURE_UNIT, (location.y)*Referance.TEXTURE_UNIT+Referance.TEXTURE_UNIT);
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f((location.x)*Referance.TEXTURE_UNIT+Referance.TEXTURE_UNIT, (location.y)*Referance.TEXTURE_UNIT);
        GL11.glVertex2f(location.x*Referance.TEXTURE_UNIT, (location.y)*Referance.TEXTURE_UNIT);
        GL11.glEnd();
    }
}
