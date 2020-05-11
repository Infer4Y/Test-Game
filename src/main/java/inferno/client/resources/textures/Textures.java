package inferno.client.resources.textures;

import inferno.client.resources.ResourceLocation;
import inferno.common.item.Item;
import inferno.common.item.ItemBlock;
import inferno.common.item.ItemIngot;
import inferno.common.tiles.Tile;
import inferno.common.tiles.TileOre;
import inferno.utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

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



    public void init(HashMap<String, Item> items, HashMap<String, Tile> tiles){
        try {
            placeholder4 = FileUtils.scale1(ImageIO.read(Textures.class.getClassLoader().getResource("assets/test_game/tex/placeholder.png")), 4.0);
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        } try {
            placeholder3 = FileUtils.scale1(ImageIO.read(Textures.class.getClassLoader().getResource("assets/test_game/tex/placeholder.png")), 3.0);
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        } try {
            placeholder2 = FileUtils.scale1(ImageIO.read(Textures.class.getClassLoader().getResource("assets/test_game/tex/placeholder.png")), 2.0);
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        } try {
            placeholder1 = FileUtils.scale1(ImageIO.read(Textures.class.getClassLoader().getResource("assets/test_game/tex/placeholder.png")), 1.0);
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
        try {
            slot = FileUtils.scale1(ImageIO.read(Textures.class.getClassLoader().getResource("assets/test_game/tex/slot.png")), 1.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Item i: items.values()) {
            register(i, 1, textures1);
            register(i, 2, textures1);
            register(i, 3, textures1);
            register(i, 4, textures1);
        }
        for (Tile i: tiles.values()) {
            register(i, 1, textures1);
            register(i, 2, textures1);
            register(i, 3, textures1);
            register(i, 4, textures1);
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

    private void register(Tile block, int scale, HashMap<String, BufferedImage> textures){
        try {
            if (block instanceof TileOre){
                textures.put(block.getName(),  FileUtils.scale1(
                        FileUtils.joinBufferedImage(ImageIO.read(
                        this.getClass().getClassLoader().getResource(new ResourceLocation("tex/tiles/stone.png").toString())),
                                FileUtils.dye(ImageIO.read(this.getClass().getClassLoader().getResource(new ResourceLocation("tex/tiles/ore_overlay.png").toString())),
                                        ((TileOre) block).getColor())),
                                scale
                ));
            } else {
                textures.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource(new ResourceLocation("tex/tiles/" + block.getName() + ".png").toString())), scale));
            }
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
    }

    private void register(Item block, int scale, HashMap<String, BufferedImage> textures){
        try {
            if (block instanceof ItemBlock){
                //textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/tiles/" + block.getName() + ".png"))), 4.0));
            } else if (block instanceof ItemIngot){
                textures.put(block.getName(),  FileUtils.scale1(
                        FileUtils.joinBufferedImage(
                                FileUtils.dye(ImageIO.read(this.getClass().getClassLoader().getResource(new ResourceLocation("tex/items/ingot.png").toString())),((ItemIngot) block).getColor()),
                                ImageIO.read(this.getClass().getClassLoader().getResource(new ResourceLocation("tex/items/ingot_1.png").toString()))
                        ), scale
                ));
            } else {
                textures.put(block.getName(), FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource(new ResourceLocation("tex/items/" + block.getName() + ".png").toString())), scale));
            }
        } catch (NullPointerException|IOException e) {
            e.printStackTrace();
        }
    }

}
