package inferno.client.graphics.renderables;

import inferno.client.resources.textures.Texture;
import org.joml.Vector3f;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11C.GL_TEXTURE_2D;

public class TextureHelper {
    public static void draw(Texture texture, float x, float y, float width, float height){
        draw(texture, x, y, width, height, 1f);
    }

    public static void drawFlippedX(Texture texture, float x, float y, float width, float height){
        drawFlippedX(texture, x, y, width, height, 1f);
    }

    public static void drawFlippedY(Texture texture, float x, float y, float width, float height){
        drawFlippedY(texture, x, y, width, height, 1f);
    }

    public static void drawFlipped(Texture texture, float x, float y, float width, float height){
        drawFlipped(texture, x, y, width, height, 1f);
    }

    public static void draw(Texture texture, float x, float y, float width, float height, float alpha, Vector3f color){
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D); //likely redundant; will be removed upon migration to "modern GL"

        if ( texture == null) { return; }

        texture.bind();

        float u = 0f;
        float v = 0f;
        float u2 = 1f;
        float v2 = 1f;

        glColor4f(color.x, color.y, color.z, alpha);
        glBegin(GL_QUADS);
        glTexCoord2f(u, v);
        glVertex2f(x, y);
        glTexCoord2f(u, v2);
        glVertex2f(x, y + height);
        glTexCoord2f(u2, v2);
        glVertex2f(x + width, y + height);
        glTexCoord2f(u2, v);
        glVertex2f(x + width, y);
        glEnd();
        glDisable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);

        texture.unbind();
        glColor4f(1f, 1f, 1f, 1f);
    }

    public static void draw(Texture texture, float x, float y, float width, float height, float alpha){
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D); //likely redundant; will be removed upon migration to "modern GL"

        if ( texture == null) { return; }

        texture.bind();

        float u = 0f;
        float v = 0f;
        float u2 = 1f;
        float v2 = 1f;

        glColor4f(1f, 1f, 1f, alpha);
        glBegin(GL_QUADS);
        glTexCoord2f(u, v);
        glVertex2f(x, y);
        glTexCoord2f(u, v2);
        glVertex2f(x, y + height);
        glTexCoord2f(u2, v2);
        glVertex2f(x + width, y + height);
        glTexCoord2f(u2, v);
        glVertex2f(x + width, y);
        glEnd();

        texture.unbind();
        glDisable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);
        glColor4f(1f, 1f, 1f, 1f);
    }

    public static void drawFlippedX(Texture texture, float x, float y, float width, float height, float alpha){
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D); //likely redundant; will be removed upon migration to "modern GL"

        if ( texture == null) { return; }

        texture.bind();

        float u = 0f;
        float v = 0f;
        float u2 = 1f;
        float v2 = 1f;

        glColor4f(1f, 1f, 1f, alpha);
        glBegin(GL_QUADS);
        glTexCoord2f(u2, v);
        glVertex2f(x, y);
        glTexCoord2f(u2, v2);
        glVertex2f(x, y + height);
        glTexCoord2f(u, v2);
        glVertex2f(x + width, y + height);
        glTexCoord2f(u, v);
        glVertex2f(x + width, y);
        glEnd();

        texture.unbind();
        glDisable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);

        glColor4f(1f, 1f, 1f, 1f);
    }

    public static void drawFlippedY(Texture texture, float x, float y, float width, float height, float alpha){
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D); //likely redundant; will be removed upon migration to "modern GL"

        if ( texture == null) { return; }

        texture.bind();

        float u = 0f;
        float v = 0f;
        float u2 = 1f;
        float v2 = 1f;

        glColor4f(1f, 1f, 1f, alpha);
        glBegin(GL_QUADS);
        glTexCoord2f(u, v2);
        glVertex2f(x, y);
        glTexCoord2f(u, v);
        glVertex2f(x, y + height);
        glTexCoord2f(u2, v);
        glVertex2f(x + width, y + height);
        glTexCoord2f(u2, v2);
        glVertex2f(x + width, y);
        glEnd();

        texture.unbind();
        glDisable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);

        glColor4f(1f, 1f, 1f, 1f);
    }

    public static void drawFlipped(Texture texture, float x, float y, float width, float height, float alpha){
        //glLoadIdentity();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D); //likely redundant; will be removed upon migration to "modern GL"

        if ( texture == null) { return; }

        texture.bind();

        float u = 0f;
        float v = 0f;
        float u2 = 1f;
        float v2 = 1f;

        glColor4f(1f, 1f, 1f, alpha);
        glBegin(GL_QUADS);
        glTexCoord2f(u2, v2);
        glVertex2f(x, y);
        glTexCoord2f(u2, v);
        glVertex2f(x, y + height);
        glTexCoord2f(u, v);
        glVertex2f(x + width, y + height);
        glTexCoord2f(u, v2);
        glVertex2f(x + width, y);
        glEnd();

        texture.unbind();
        glDisable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);

        glColor4f(1f, 1f, 1f, 1f);
    }
}
