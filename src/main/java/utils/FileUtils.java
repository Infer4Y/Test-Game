package utils;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class FileUtils {
    public static File getFileFromResources(String fileName) {

        ClassLoader classLoader = FileUtils.class.getClass().getClassLoader();
        URL resource;
        try {
            resource = classLoader.getResource(fileName);
            if (resource == null) {
                throw new IllegalArgumentException("file is not found!");
            } else {
                return new File(resource.getFile());
            }
        } catch (Exception e){}

        return null;

    }

    public static File[] getResourceFolderFiles (String folder) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(folder);
        String path = url.getPath();
        return new File(path).listFiles();
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
}
