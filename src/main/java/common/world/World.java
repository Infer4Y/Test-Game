package common.world;

import client.handlers.BlockHandler;
import client.renderables.BlockRender;
import client.renderables.EntityRenderer;
import common.block.Block;
import common.entities.Entity;
import common.entities.Player;
import common.registries.Blocks;
import common.world.gen.Tree;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class World {
    private String name;
    private BlockRender[][] mapR = null;
    private Tree tree = new Tree();
    private HashMap<Entity, EntityRenderer> entities = new HashMap<>();
    private int x, y;
    private int time;
    private int offsetX, offsetY;;

    public World (String name, int x, int y){
        this.x = x;
        this.y = y;
        mapR = new BlockRender[y][x];
        for (int i = 0; i < y; i++) {
            if (i == y-5) {
                for (int j = 0; j < x; j++) {
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.grass, j * 64, i *64);
                }
            } else if (i == y-4){
                for (int j = 0; j < x; j++) {
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.dirt, j * 64, i *64);
                }
            } else if (i == y-3){
                for (int j = 0; j < x; j++) {
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.stone, j * 64, i *64);
                }
            } else if (i == y-2){
                for (int j = 0; j < x; j++) {
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.stone, j * 64, i *64);
                }
            }else if (i == y-1){
                for (int j = 0; j < x; j++) {
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.launcher, j * 64, i *64);
                }
            } else {
                for (int j = 0; j < x; j++) {
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.air, j * 64, i *64);
                }
            }
        }
        Block[][] treeStruct = tree.getStruct();
        for (int i = 0; i < treeStruct.length; i++) {
            for (int j = 0; j < treeStruct[i].length; j++){
                mapR[i+1][j] = BlockHandler.handleBlockRenderer(treeStruct[i][j], (j) * 64, (i+1) * 64);
            }
        }
        treeStruct = tree.getStruct();
        for (int i = 0; i < treeStruct.length; i++) {
            for (int j = 0; j < treeStruct[i].length; j++){
                mapR[i+1][j+5] = BlockHandler.handleBlockRenderer(treeStruct[i][j], (j+5) * 64, (i+1) * 64);
            }
        }
        treeStruct = tree.getStruct();
        for (int i = 0; i < treeStruct.length; i++) {
            for (int j = 0; j < treeStruct[i].length; j++){
                mapR[i+1][j+10] = BlockHandler.handleBlockRenderer(treeStruct[i][j], (j+10) * 64, (i+1) * 64);
            }
        }
        treeStruct = tree.getStruct();
        for (int i = 0; i < treeStruct.length; i++) {
            for (int j = 0; j < treeStruct[i].length; j++){
                mapR[i+1][j+15] = BlockHandler.handleBlockRenderer(treeStruct[i][j], (j+15) * 64, (i+1) * 64);
            }
        }
        Player player = new Player("player", 10,10);
        entities.put(player, new EntityRenderer(player, (x/2)*32, (y-6)*64, this));
        time = 1199;
    }

    public void draw(Graphics g){
        g.translate(offsetX, offsetY);
        for (BlockRender[] r: mapR) {
            for (BlockRender r1: r) {
                r1.draw(g);
            }
        }

        g.translate(-offsetX, -offsetY);
        for (EntityRenderer r : entities.values()){
            r.draw(g);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BlockRender[][] getMapR() {
        return mapR;
    }

    public void setMapR(BlockRender[][] mapR) {
        this.mapR = mapR;
    }

    public int getWidth() {
        return x;
    }

    public int getHeight(){
        return y;
    }

    public HashMap<Entity, EntityRenderer> getEntities() {
        return entities;
    }

    public void update() {
        for (client.renderables.Entity e : entities.values()) {
            e.tick ();
        }
    }

    public void updatePerSecond () {
        if (time == 2400){
            time = 0;
        } else {
            time++;
        }
        for (client.renderables.Entity e : entities.values()) {
            e.second ();
        }

    }

    public int getTime() {
        return time;
    }

    public void transition(int x, int y){
        this.offsetX = this.offsetX+x;
        this.offsetY = this.offsetY+y;
    }
}
