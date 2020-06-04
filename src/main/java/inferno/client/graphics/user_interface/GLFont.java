package inferno.client.graphics.user_interface;

import inferno.client.resources.ResourceLocation;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11C.GL_TEXTURE_2D;

public class GLFont {
    private final Map<Integer,String> CHARS = new HashMap<Integer,String>() {{
        put(0, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        put(1, "abcdefghijklmnopqrstuvwxyz");
        put(2, "0123456789");
        put(3, "ÄÖÜäöüß");
        put(4, " $+-*/=%\"'#@&_(),.;:?!\\|<>[]§`^~");
    }};

    //Variables
    private Font font;
    private FontMetrics fontMetrics;
    private BufferedImage bufferedImage;
    private int fontTextureId;

    public GLFont(ResourceLocation path, float size) {
        try {
            this.font = Font.createFont(Font.TRUETYPE_FONT, GLFont.class.getClassLoader().getResourceAsStream(path.toString())).deriveFont(size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        Graphics2D graphics = gc.createCompatibleImage(1, 1, Transparency.TRANSLUCENT).createGraphics();
        graphics.setFont(font);

        fontMetrics = graphics.getFontMetrics();
        bufferedImage = graphics.getDeviceConfiguration().createCompatibleImage((int) getFontImageWidth(),(int) getFontImageHeight(),Transparency.TRANSLUCENT);

        fontTextureId = glGenTextures();
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, fontTextureId);

        glTexParameteri(GL11.GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
        glTexParameteri(GL11.GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);

        //Setup texture scaling filtering
        glTexParameteri(GL11.GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL11.GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA,(int) getFontImageWidth(),(int) getFontImageHeight(),0, GL_RGBA, GL_UNSIGNED_BYTE, asByteBuffer());
    }

    public void drawText(String text, int x, int y, Vector3f color) {
        glColor3f(color.x, color.y, color.z);
        drawText(text, x, y);
        glColor3f(1,1,1);
    }

    public void drawText(String text, float x, float y) {
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, this.fontTextureId);
        glBegin(GL_QUADS);

        float xTmp = x;
        for (char c : text.toCharArray()) {
            float width = getCharWidth(c);
            float height = getCharHeight();
            float cw = 1f / getFontImageWidth() * width;
            float ch = 1f / getFontImageHeight() * height;
            float cx = 1f / getFontImageWidth() * getCharX(c);
            float cy = 1f / getFontImageHeight() * getCharY(c);

            glTexCoord2f(cx, cy);
            glVertex3f(xTmp, y, 0);

            glTexCoord2f(cx + cw, cy);
            glVertex3f(xTmp + width, y, 0);

            glTexCoord2f(cx + cw, cy + ch);
            glVertex3f(xTmp + width, y + height, 0);

            glTexCoord2f(cx, cy + ch);
            glVertex3f(xTmp, y + height, 0);

            xTmp += width;
        }

        glEnd();
    }

    public ByteBuffer asByteBuffer() {

        ByteBuffer byteBuffer;

        Graphics2D imageGraphics = (Graphics2D) bufferedImage.getGraphics();
        imageGraphics.setFont(font);
        imageGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        imageGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        imageGraphics.setColor(Color.WHITE);
        CHARS.keySet().stream().forEach(i -> imageGraphics.drawString(CHARS.get(i), 0, fontMetrics.getMaxAscent() + (this.getCharHeight() * i)));

        int[] pixels = new int[bufferedImage.getWidth() * bufferedImage.getHeight()];
        bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), pixels, 0, bufferedImage.getWidth());
        byteBuffer = ByteBuffer.allocateDirect((bufferedImage.getWidth() * bufferedImage.getHeight() * 4));

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                int pixel = pixels[y * bufferedImage.getWidth() + x];
                byteBuffer.put((byte) ((pixel >> 16) & 0xFF));   // Red component
                byteBuffer.put((byte) ((pixel >> 8) & 0xFF));    // Green component
                byteBuffer.put((byte) (pixel & 0xFF));           // Blue component
                byteBuffer.put((byte) ((pixel >> 24) & 0xFF));   // Alpha component. Only for RGBA
            }
        }

        byteBuffer.flip();

        return byteBuffer;
    }

    public float getFontImageWidth() {
        return (float) CHARS.values().stream().mapToDouble(e -> fontMetrics.getStringBounds(e, null).getWidth()).max().getAsDouble();
    }
    public float getFontImageHeight() {
        return (float) CHARS.keySet().size() * (this.getCharHeight());
    }
    public float getCharX(char c) {
        String originStr = CHARS.values().stream().filter(e -> e.contains("" + c)).findFirst().orElse("" + c);
        return (float) fontMetrics.getStringBounds(originStr.substring(0, originStr.indexOf(c)), null).getWidth();
    }
    public float getCharY(char c) {
        float lineId = (float) CHARS.keySet().stream().filter(i -> CHARS.get(i).contains("" + c)).findFirst().orElse(0);
        return this.getCharHeight() * lineId;
    }
    public float getCharWidth(char c) {
        return fontMetrics.charWidth(c);
    }
    public float getCharHeight() {
        return (float) (fontMetrics.getMaxAscent() + fontMetrics.getMaxDescent());
    }

    public void dispose() {
        glDeleteTextures(this.fontTextureId);
        fontTextureId = 0;
    }
}
