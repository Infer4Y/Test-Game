package inferno.client.resources.textures;

import inferno.client.resources.ResourceLocation;
import inferno.common.entities.Entity;
import inferno.common.item.Item;
import inferno.common.item.ItemBlock;
import inferno.common.item.ItemIngot;
import inferno.common.registries.Entities;
import inferno.common.registries.Items;
import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.tiles.TileOre;

import java.util.HashMap;

public class Textures {
    private final HashMap<String, Texture> textures = new HashMap<>();

    private Texture placeholder;

    public static Texture slot;
    public static Texture loading;
    public static Texture background;


    public void init(){
        placeholder = new Texture(new ResourceLocation("tex/placeholder.png"));
        slot = new Texture(new ResourceLocation("tex/slot.png"));
        loading = new Texture(new ResourceLocation("tex/loading.png"));
        background = new Texture(new ResourceLocation("tex/background.png"));

        for (Item i: Items.ITEM_MAP.values()) {
            register(i);
        }
        for (Tile i: Tiles.TILE_MAP.values()) {
            register(i);
        }
        for (Entity e : Entities.ENTITY_MAP.values()) {
            register(e);
        }
    }

    public Texture getTexture(String name){
        return textures.getOrDefault(name, placeholder);
    }

    private void register(Entity entity){
        textures.put(entity.getName(), new Texture(new ResourceLocation("tex/entities/" + entity.getName() + ".png")));
    }

    private void register(Tile block){
        if (block instanceof TileOre){
            //textures.put(block.getName(),  FileUtils.scale1(
            //        FileUtils.joinBufferedImage(ImageIO.read(
            //        this.getClass().getClassLoader().getResource(new ResourceLocation("tex/tiles/stone.png").toString())),
            //                FileUtils.dye(ImageIO.read(this.getClass().getClassLoader().getResource(new ResourceLocation("tex/tiles/ore_overlay.png").toString())),
            //                        ((TileOre) block).getColor())),
            //                scale
            //));
        } else {
            textures.put(block.getName(), new Texture(new ResourceLocation("tex/tiles/" + block.getName() + ".png")));
        }
    }

    private void register(Item block){
        if (block instanceof ItemBlock){
        } else if (block instanceof ItemIngot){
            //textures.put(block.getName(),  FileUtils.scale1(
            //        FileUtils.joinBufferedImage(
            //                FileUtils.dye(ImageIO.read(this.getClass().getClassLoader().getResource(new ResourceLocation("tex/items/ingot.png").toString())),((ItemIngot) block).getColor()),
            //                ImageIO.read(this.getClass().getClassLoader().getResource(new ResourceLocation("tex/items/ingot_1.png").toString()))
            //        ), scale
            //));
        } else {
            textures.put(block.getName(), new Texture(new ResourceLocation("tex/items/" + block.getName() + ".png")));
        }

    }

    public void dispose(){
        for (Texture texture: textures.values()) {
            texture.dispose();
        }
    }

}
