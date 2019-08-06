package common.world;

import client.handlers.BlockHandler;
import client.renderables.BlockRender;
import client.renderables.EntityRenderer;
import common.block.Block;
import common.entities.Entity;
import common.entities.Player;
import common.registries.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class World {
    private String name;

    private Block[][] map = null;
    private BlockRender[][] mapR = null;
    private HashMap<Entity, EntityRenderer> entities = new HashMap<>();
    private int x, y;
    private int time;

    public World (String name, int x, int y){
        this.x = x;
        this.y = y;
        map = new Block[y][x];
        mapR = new BlockRender[y][x];
        for (int i = 0; i < y; i++) {
            if (i == y-4) {
                for (int j = 0; j < x; j++) {
                    map[i][j] = Blocks.grass;
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.grass, j * 64, i *64);
                }
            } else if (i == y-3){
                for (int j = 0; j < x; j++) {
                    map[i][j] = Blocks.dirt;
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.dirt, j * 64, i *64);
                }
            } else if (i == y-2){
                for (int j = 0; j < x; j++) {
                    map[i][j] = Blocks.stone;
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.stone, j * 64, i *64);
                }
            } else if (i == y-1){
                for (int j = 0; j < x; j++) {
                    map[i][j] = Blocks.stone;
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.stone, j * 64, i *64);
                }
            } else {
                for (int j = 0; j < x; j++) {
                    map[i][j] = Blocks.air;
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.air, j * 64, i *64);
                }
            }
        }
        Player player = new Player("player", 10,10);
        entities.put(player, new EntityRenderer(player, (x/2)*32, (y-6)*64, this));
        time = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Block[][] getMap() {
        return map;
    }

    public void setMap(Block[][] map) {
        this.map = map;
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
}
