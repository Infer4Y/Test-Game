package xavier.project_iodine.client;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import xavier.project_iodine.common.block.Block;
import xavier.project_iodine.common.block.BlockOre;
import xavier.project_iodine.common.item.Item;
import xavier.project_iodine.common.item.ItemBlock;
import xavier.project_iodine.common.item.ItemIngot;
import xavier.project_iodine.utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Textures {
    private static final HashMap<String, Texture> textures = new HashMap<>();
    public static Texture ball = new Texture(Gdx.files.internal("tex/entities/ball.png"));

    private static Texture placeholder;

    public static Texture slot;



    public static void init(HashMap<String, Item> items, HashMap<String, Block> blocks){
        placeholder = new Texture(Gdx.files.internal("tex/placeholder.png"));
        slot = new Texture(Gdx.files.internal("tex/slot.png"));
        for (Item i: items.values()) {
            register(i);
        }
        for (Block i: blocks.values()) {
            register(i);
        }
    }

    private static void register(Block block){
        if (block instanceof BlockOre){
            textures.put(block.getName(),  FileUtils.dye(new Texture(Gdx.files.internal("tex/blocks/ore_overlay.png")), ((BlockOre) block).getColor()));
        } else {
            textures.put(block.getName(), new Texture(Gdx.files.internal("tex/blocks/" + block.getName() + ".png")));
        }
    }

    private static void register(Block... block){
        for (Block b : block) {
            register(b);
        }
    }

    private static void register(Item block){
        if (block instanceof ItemBlock){
            //textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png"))), 4.0));
        } else if (block instanceof ItemIngot){
            textures.put(block.getName(),
                    FileUtils.joinBufferedImage(
                            FileUtils.dye(new Texture(Gdx.files.internal("tex/items/ingot.png")),((ItemIngot) block).getColor()),
                            new Texture(Gdx.files.internal("tex/items/ingot_1.png"))
            ));
        } else {
            textures.put(block.getName(), new Texture(Gdx.files.internal("tex/items/" + block.getName() + ".png")));
        }
    }

    private static void register(Item... blocks){
        for (Item block : blocks) {
            if (block instanceof ItemBlock){
            } else {
                register(block);
            }
        }
    }

    public static Texture getTexture(String name) {
        if (textures.containsKey(name)) {
            return textures.get(name);
        }
        return placeholder;
    }

    public static void dispose() {
        for (Texture tex : textures.values()) {
            tex.dispose();
        }
        placeholder.dispose();
        slot.dispose();
    }
}
