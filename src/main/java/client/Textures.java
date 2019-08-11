package client;

import common.block.Block;
import common.item.IItem;
import common.item.Item;
import common.item.ItemBlock;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class Textures {
    private static final HashMap<String, BufferedImage> textures4 = new HashMap<>();
    private static final HashMap<String, BufferedImage> textures3 = new HashMap<>();
    private static final HashMap<String, BufferedImage> textures2 = new HashMap<>();
    private static final HashMap<String, BufferedImage> textures1 = new HashMap<>();

    private static BufferedImage placeholder4;
    private static BufferedImage placeholder3;
    private static BufferedImage placeholder2;
    private static BufferedImage placeholder1;

    static {
        try {
            placeholder4 = FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/placeholder.png")), 4.0);
            placeholder3 = FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/placeholder.png")), 3.0);
            placeholder2 = FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/placeholder.png")), 2.0);
            placeholder1 = FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/placeholder.png")), 1.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void init(HashMap<String, IItem> items, HashMap<String, Block> blocks){
        for (IItem i: items.values()) {
            register1(i);
            register2(i);
            register3(i);
            register4(i);
        }
        for (Block i: blocks.values()) {
            register1(i);
            register2(i);
            register3(i);
            register4(i);
        }
    }

    public static BufferedImage getTexture1(String name){
        return textures1.getOrDefault(name, placeholder1);
    }
    public static BufferedImage getTexture2(String name){
        return textures2.getOrDefault(name, placeholder2);
    }
    public static BufferedImage getTexture3(String name){
        return textures3.getOrDefault(name, placeholder3);
    }
    public static BufferedImage getTexture4(String name){
        return textures4.getOrDefault(name, placeholder4);
    }




    private static void register4(Block block){
        try {
            textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/blocks/"+block.getName()+".png")),4.0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register4(Block... block){
        for (Block b : block) {
            try {
                textures4.put(b.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/blocks/"+b.getName()+".png")), 4.0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void register3(Block block){
        try {
            textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/blocks/"+block.getName()+".png")),3.0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register3(Block... block){
        for (Block b : block) {
            try {
                textures4.put(b.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/blocks/"+b.getName()+".png")), 3.0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void register2(Block block){
        try {
            textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/blocks/"+block.getName()+".png")),2.0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register2(Block... block){
        for (Block b : block) {
            try {
                textures4.put(b.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/blocks/"+b.getName()+".png")), 2.0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void register1(Block block){
        try {
            textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/blocks/"+block.getName()+".png")),1.0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register1(Block... block){
        for (Block b : block) {
            try {
                textures4.put(b.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/blocks/"+b.getName()+".png")), 1.0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void register4(IItem block){
        try {
            if (block instanceof ItemBlock){

            } else {
                textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/items/" + block.getName() + ".png")), 4.0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register4(IItem... block){
        for (IItem b : block) {
            try {
                textures4.put(b.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/items/"+b.getName()+".png")), 4.0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void register3(IItem block){
        try {
            textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/items/"+block.getName()+".png")),3.0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register3(IItem... block){
        for (IItem b : block) {
            try {
                textures4.put(b.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/items/"+b.getName()+".png")), 3.0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void register2(IItem block){
        try {
            textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/items/"+block.getName()+".png")),2.0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register2(IItem... block){
        for (IItem b : block) {
            try {
                textures4.put(b.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/items/"+b.getName()+".png")), 2.0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void register1(IItem block){
        try {
            textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/items/"+block.getName()+".png")),1.0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register1(IItem... block){
        for (IItem b : block) {
            try {
                textures4.put(b.getName(), FileUtils.scale1(ImageIO.read(Textures.class.getClass().getClassLoader().getResource("tex/items/"+b.getName()+".png")), 1.0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
