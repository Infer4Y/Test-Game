package client;

import common.registries.ResourceLocation;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Texture {
    private Image scale1;
    private Image scale2;
    private Image scale3;
    private Image scale4;

    private ResourceLocation location;

    private String name;


    public Texture(String name, ResourceLocation location) {
        this.name = name;
        this.location = location;
        try {
            scale1 = ImageIO.read(location.getInputStream());
            scale2 = FileUtils.scale1((BufferedImage) scale1, 2.0f);
            scale3 = FileUtils.scale1((BufferedImage) scale1, 3.0f);
            scale4 = FileUtils.scale1((BufferedImage) scale1, 4.0f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getScale1() {
        return scale1;
    }

    public Image getScale2() {
        return scale2;
    }

    public Image getScale3() {
        return scale3;
    }

    public Image getScale4() {
        return scale4;
    }

    public String getName() {
        return name;
    }
}
