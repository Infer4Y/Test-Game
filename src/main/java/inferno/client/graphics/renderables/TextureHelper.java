package inferno.client.graphics.renderables;

import inferno.client.resources.textures.Texture;

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

    public static void draw(Texture texture, float x, float y, float width, float height, float alpha){
        glLoadIdentity();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D); //likely redundant; will be removed upon migration to "modern GL"

        if ( texture == null) { return; }

        //bind the texture before rendering it
        texture.bind();

        //setup our texture coordinates
        //(u,v) is another common way of writing (s,t)
        float u = 0f;
        float v = 0f;
        float u2 = 1f;
        float v2 = 1f;

        //immediate mode is deprecated -- we are only using it for quick debugging
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
    }

    public static void drawFlippedX(Texture texture, float x, float y, float width, float height, float alpha){
        glLoadIdentity();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D); //likely redundant; will be removed upon migration to "modern GL"

        if ( texture == null) { return; }

        //bind the texture before rendering it
        texture.bind();

        //setup our texture coordinates
        //(u,v) is another common way of writing (s,t)
        float u = 0f;
        float v = 0f;
        float u2 = 1f;
        float v2 = 1f;

        //immediate mode is deprecated -- we are only using it for quick debugging
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
    }

    public static void drawFlippedY(Texture texture, float x, float y, float width, float height, float alpha){
        glLoadIdentity();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D); //likely redundant; will be removed upon migration to "modern GL"

        if ( texture == null) { return; }

        //bind the texture before rendering it
        texture.bind();

        //setup our texture coordinates
        //(u,v) is another common way of writing (s,t)
        float u = 0f;
        float v = 0f;
        float u2 = 1f;
        float v2 = 1f;

        //immediate mode is deprecated -- we are only using it for quick debugging
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
    }

    public static void drawFlipped(Texture texture, float x, float y, float width, float height, float alpha){
        glLoadIdentity();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D); //likely redundant; will be removed upon migration to "modern GL"

        if ( texture == null) { return; }

        //bind the texture before rendering it
        texture.bind();

        //setup our texture coordinates
        //(u,v) is another common way of writing (s,t)
        float u = 0f;
        float v = 0f;
        float u2 = 1f;
        float v2 = 1f;

        //immediate mode is deprecated -- we are only using it for quick debugging
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
    }


}
