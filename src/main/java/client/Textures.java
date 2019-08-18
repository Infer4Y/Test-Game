package client;

import common.block.Block;
import common.block.BlockOre;
import common.item.IItem;
import common.item.Item;
import common.item.ItemBlock;
import common.item.ItemIngot;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Textures {
    private final HashMap<String, BufferedImage> textures4 = new HashMap<>();
    private final HashMap<String, BufferedImage> textures3 = new HashMap<>();
    private final HashMap<String, BufferedImage> textures2 = new HashMap<>();
    private final HashMap<String, BufferedImage> textures1 = new HashMap<>();

    private BufferedImage placeholder4;
    private BufferedImage placeholder3;
    private BufferedImage placeholder2;
    private BufferedImage placeholder1;

    public static BufferedImage slot;



    public void init(HashMap<String, Item> items, HashMap<String, Block> blocks){
        try {
            placeholder4 = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 4.0);
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        } try {
            placeholder3 = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 3.0);
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        } try {
            placeholder2 = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 2.0);
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        } try {
            placeholder1 = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 1.0);
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
        try {
            slot = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/slot.png")), 1.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Item i: items.values()) {
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

    public BufferedImage getTexture1(String name){
        return textures1.getOrDefault(name, placeholder1);
    }
    public BufferedImage getTexture2(String name){
        return textures2.getOrDefault(name, placeholder2);
    }
    public BufferedImage getTexture3(String name){
        return textures3.getOrDefault(name, placeholder3);
    }
    public BufferedImage getTexture4(String name){
        return textures4.getOrDefault(name, placeholder4);
    }

    private void register4(Block block){
        try {
            if (block instanceof BlockOre){
                textures4.put(block.getName(),  FileUtils.scale1(FileUtils.joinBufferedImage(ImageIO.read(
                        this.getClass().getClassLoader().getResource("tex/blocks/stone.png")), FileUtils.dye(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/ore_overlay.png")), ((BlockOre) block).getColor())),4.0
                ));
            } else {
                textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png")), 4.0));
            }
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
    }

    private void register4(Block... block){
        for (Block b : block) {
            try {
                textures4.put(b.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/"+b.getName()+".png")), 4.0));
            } catch (NullPointerException|IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void register3(Block block){
        try {
            if (block instanceof BlockOre){
                textures3.put(block.getName(),  FileUtils.scale1(FileUtils.joinBufferedImage(ImageIO.read(
                        this.getClass().getClassLoader().getResource("tex/blocks/stone.png")), FileUtils.dye(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/ore_overlay.png")), ((BlockOre) block).getColor())),3.0
                ));
            } else {
                textures3.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png")), 3.0));
            }
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
    }

    private void register3(Block... block){
        for (Block b : block) {
            try {
                if (b instanceof BlockOre){
                    textures3.put(b.getName(),  FileUtils.scale1(FileUtils.joinBufferedImage(ImageIO.read(
                            this.getClass().getClassLoader().getResource("tex/blocks/stone.png")), FileUtils.dye(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/ore_overlay.png")), ((BlockOre) b).getColor())),3.0
                    ));
                } else {
                    textures3.put(b.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/" + b.getName() + ".png")), 3.0));
                }
            } catch (NullPointerException|IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void register2(Block block){
        try {
            if (block instanceof BlockOre){
                textures2.put(block.getName(),  FileUtils.scale1(FileUtils.joinBufferedImage(ImageIO.read(
                        this.getClass().getClassLoader().getResource("tex/blocks/stone.png")), FileUtils.dye(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/ore_overlay.png")), ((BlockOre) block).getColor())),2.0
                ));
            } else {
                textures2.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png")), 2.0));
            }
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
    }

    private void register2(Block... blocks){
        for (Block block : blocks) {
            register2(block);
        }
    }

    private void register1(Block block){
        if (block instanceof BlockOre){
            try {
                textures1.put(block.getName(),  FileUtils.scale1(FileUtils.joinBufferedImage(ImageIO.read(
                        this.getClass().getClassLoader().getResource("tex/blocks/stone.png")), FileUtils.dye(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/ore_overlay.png")), ((BlockOre) block).getColor())),1.0
                ));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                textures1.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png")), 1.0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void register1(Block... block){
        for (Block b : block) {
            try {
                textures1.put(b.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/"+b.getName()+".png")), 1.0));
            } catch (NullPointerException|IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void register4(Item block){
        try {
            if (block instanceof ItemBlock){
                //textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png"))), 4.0));
            } else if (block instanceof ItemIngot){
                //textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png"))), 4.0));
            } else {
                textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/items/" + block.getName() + ".png")), 4.0));
            }
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
    }

    private void register4(Item... blocks){
        for (Item block : blocks) {
            if (block instanceof ItemBlock){
            } else {
                try {
                    textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/items/" + block.getName() + ".png")), 4.0));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void register3(Item block){
        try {
            if (block instanceof ItemBlock){
                //textures3.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png"))), 3.0));
            } else {
                textures3.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/items/" + block.getName() + ".png")), 3.0));
            }
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
    }

    private void register3(Item... blocks){
        for (Item block : blocks) {
            if (block instanceof ItemBlock){
            } else {
                try {
                    textures3.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/items/" + block.getName() + ".png")), 3.0));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void register2(Item block){
        try {
            if (block instanceof ItemBlock){
                //textures2.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png"))), 2.0));
            } else {
                textures2.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/items/" + block.getName() + ".png")), 2.0));
            }
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
    }

    private void register2(Item... blocks){
        for (Item block : blocks) {
            if (block instanceof ItemBlock){
            } else {
                try {
                    textures2.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/items/" + block.getName() + ".png")), 2.0));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void register1(Item block){
        try {
            if (block instanceof ItemBlock){
                //textures1.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png"))), 1.0));
            } else {
                textures1.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/items/" + block.getName() + ".png")), 1.0));
            }
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
    }

    private void register1(Item... blocks) {
        for (Item block : blocks) {
            if (block instanceof ItemBlock) {
            } else {
                try {
                    textures1.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/items/" + block.getName() + ".png")), 1.0));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
