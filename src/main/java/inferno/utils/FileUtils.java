package inferno.utils;

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

    public static BufferedImage dye(BufferedImage image, Color color) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage dyed = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = dyed.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.setComposite(AlphaComposite.SrcAtop);
        g.setColor(color);
        g.fillRect(0, 0, w, h);
        g.dispose();
        return dyed;
    }

    public static BufferedImage joinBufferedImage(BufferedImage img1, BufferedImage img2) {
        int width = img1.getWidth();
        int height = img1.getHeight();
        BufferedImage newImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, 0, 0);
        g2.dispose();
        return newImage;
    }

    public static BufferedImage scale1(BufferedImage before, double scale) {
        int w = before.getWidth();
        int h = before.getHeight();
        // Create a new image of the proper size
        int w2 = (int) (w * scale);
        int h2 = (int) (h * scale);
        BufferedImage after = new BufferedImage(w2, h2, BufferedImage.TYPE_INT_ARGB);
        AffineTransform scaleInstance = AffineTransform.getScaleInstance(scale, scale);
        AffineTransformOp scaleOp
                = new AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

        scaleOp.filter(before, after);
        return after;
    }

    public static BufferedImage rotateClockwise90(BufferedImage src) {
        int width = src.getWidth();
        int height = src.getHeight();

        BufferedImage dest = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = dest.createGraphics();
        graphics2D.translate((height - width) / 2, (height - width) / 2);
        graphics2D.rotate(Math.PI / 2, height / 2, width / 2);
        graphics2D.drawRenderedImage(src, null);

        return dest;
    }
    public static BufferedImage rotateClockwise(BufferedImage src) {
        int width = src.getWidth();
        int height = src.getHeight();
        BufferedImage dest = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = dest.createGraphics();
        AffineTransform transform = new AffineTransform();
        transform.setToTranslation((height - width) / 2,
                (height - width) / 2);

        transform.rotate(Math.toRadians(1), width / 2,
                height / 2);
        graphics2D.setTransform(transform);
        graphics2D.drawRenderedImage(src, null);

        return dest;
    }

    public static BufferedImage colorImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                if (!(pixels[0] <= 0)) {
                    pixels[0]-= r.nextInt(5);
                    if (pixels[0] <= 0) {
                        pixels[0] = 255;
                    }
                } else {
                    pixels[0] = 255;
                }
                if (!(pixels[1] <= 0)) {
                    pixels[1]-= r.nextInt(5);
                    if (pixels[1] <= 0) {
                        pixels[1] = 255;
                    }
                } else {
                    pixels[1] = 255;
                }
                if (!(pixels[2] <= 0)) {
                    pixels[2]-= r.nextInt(5);
                    if (pixels[2] <= 0) {
                        pixels[2] = 255;
                    }
                } else {
                    pixels[2] = 255;
                }
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }

    public static BufferedImage verticalFlip(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage flippedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = flippedImage.createGraphics();
        g.drawImage(img, 0, 0, w, h, 0, h, w, 0, null);
        g.dispose();
        return flippedImage;
    }

    public static BufferedImage horizontalFlip(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage flippedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = flippedImage.createGraphics();
        g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
        g.dispose();
        return flippedImage;
    }
}