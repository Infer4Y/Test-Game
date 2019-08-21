package xavier.project_iodine.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Sprite;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.net.URL;
import java.util.Random;

public class FileUtils {
    static Random r = new Random();

    public static Texture dye(Texture image, int color) {
        int w = image.getWidth();
        int h = image.getHeight();
        Sprite sprite = new Sprite(image);
        sprite.setColor(new Color(color));
        Texture dyed = sprite.getTexture();
        return dyed;
    }

    public static Texture joinBufferedImage(Texture img1, Texture img2) {
        int width = img1.getWidth();
        int height = img1.getHeight();
        Texture newImage = new Texture(width, height,
                Pixmap.Format.Alpha);
        img1.getTextureData().prepare();
        img2.getTextureData().prepare();
        newImage.draw(img1.getTextureData().consumePixmap(), 0, 0);
        newImage.draw(img2.getTextureData().consumePixmap(), 0, 0);
        img1.dispose();
        img2.dispose();
        return newImage;
    }

}
