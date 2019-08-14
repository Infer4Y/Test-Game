package common.world;

import client.Game;
import client.handlers.BlockHandler;
import client.renderables.BlockRender;
import client.renderables.EntityRenderer;
import common.block.Block;
import common.block.BlockOre;
import common.entities.Entity;
import common.entities.Player;
import common.registries.Blocks;
import common.world.gen.Tree;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class World {
    private String name;
    private BlockRender[][] mapR = null;
    private Tree tree = new Tree();
    private HashMap<Entity, EntityRenderer> entities = new HashMap<>();
    private int x, y;
    private int time;
    private Player player ;
    private Random r = new Random();
    private Block[][] ores = new Block[][]{
            {Blocks.stone, Blocks.ore_coal, Blocks.ore_copper, Blocks.ore_diamond, Blocks.ore_iron, Blocks.ore_gold, Blocks.ore_tin, Blocks.ore_silver, Blocks.ore_ruby},
            {Blocks.stone, Blocks.ore_coal, Blocks.ore_copper, Blocks.ore_diamond, Blocks.ore_iron, Blocks.ore_gold, Blocks.ore_tin, Blocks.ore_silver, Blocks.stone},
            {Blocks.stone, Blocks.ore_coal, Blocks.ore_copper, Blocks.ore_diamond, Blocks.ore_iron, Blocks.ore_gold, Blocks.ore_tin, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.ore_coal, Blocks.ore_copper, Blocks.ore_diamond, Blocks.ore_iron, Blocks.stone, Blocks.ore_tin, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.ore_coal, Blocks.ore_copper, Blocks.stone, Blocks.ore_iron, Blocks.stone, Blocks.ore_tin, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.ore_coal, Blocks.ore_copper, Blocks.stone, Blocks.ore_iron, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.ore_coal, Blocks.stone, Blocks.stone, Blocks.ore_iron, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.ore_coal, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone},
            {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone}
    };
    public int camX;
    public int camY;

    public World (String name, int x, int y){
        this.x = x;
        this.y = y;
        mapR = new BlockRender[y][x];
        for (int i = 0; i < y; i++) {
            if (i == y-40) {
                for (int j = 0; j < x; j++) {
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.grass, j * 64, i *64);
                }
            } else if (i == y-39){
                for (int j = 0; j < x; j++) {
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.dirt, j * 64, i *64);
                }
            } else if (i >= y-38  && i <= y-2){
                for (int j = 0; j < x; j++) {
                    int l1 = r.nextInt(ores.length-1);
                    int l2 = r.nextInt(ores[l1].length-1);
                    mapR[i][j] = BlockHandler.handleBlockRenderer(ores[l1][l2], j * 64, i *64);
                }
            } else if (i == y-1){
                for (int j = 0; j < x; j++) {
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.launcher, j * 64, i *64);
                }
            } else {
                for (int j = 0; j < x; j++) {
                    mapR[i][j] = BlockHandler.handleBlockRenderer(Blocks.air, j * 64, i *64);
                }
            }
        }

        for (int off = 0; off < this.getWidth()/5; off++) {
            Block[][] treeStruct = tree.getStruct();
            for (int i = 0; i < treeStruct.length; i++) {
                for (int j = 0; j < treeStruct[i].length; j++){
                    mapR[(y-45)+i][j+(off*5)] = BlockHandler.handleBlockRenderer(treeStruct[i][j], (j+(off*5)) * 64, ((y-45+i)) * 64);
                }
            }
        }

        player = new Player("player", 10,10);
        entities.put(player, new EntityRenderer(player, Game.WIDTH / 2, (y-50)*64, this));
        time = 1199;
    }

    public void draw(Graphics g){
        int offsetMaxX = this.getWidth()*64 - Game.WIDTH;
        int offsetMaxY = this.getHeight()*64 - Game.HEIGHT;
        int offsetMinX = 0;
        int offsetMinY = 0;
        camX = this.entities.get(player).getX() -  Game.WIDTH / 2;
        camY = this.entities.get(player).getY() - Game.HEIGHT / 2;
        if (camX > offsetMaxX) {
            camX = offsetMaxX;
        } else if (camX < offsetMinX) {
            camX = offsetMinX;
            if (camY > offsetMaxY) {
                camY = offsetMaxY;
            }
        } else if (camY < offsetMinY) {
            camY = offsetMinY;
        }
        g.translate(-camX, -camY);
        for (BlockRender[] r: mapR) {
            for (BlockRender r1: r) {
                if ((r1.x+r1.width >= camX-64 && r1.x+r1.width<= camX+1280+64) && (r1.y+r1.width >= camY-64 && r1.y+r1.width<= camY+640+64)) {
                    r1.draw(g);
                }
            }
        }

        if ((this.getTime() >= 1800 && this.getTime() <= 2400) || (this.getTime() >= 0 && this.getTime() <= 700)) {
            g.setColor(new Color(0x3F3D3DE2, true));
            //g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        } else {
            g.setColor(new Color(0x3FE2CF70, true));
            //g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        }


        for (EntityRenderer r : entities.values()){
            r.draw(g);
        }
        g.translate(camX, camY);
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
        for (BlockRender[] r: mapR) {
            for (BlockRender r1: r) {
                r1.tick();
            }
        }
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
        for (BlockRender[] r: mapR) {
            for (BlockRender r1: r) {
                r1.second();
            }
        }
        for (client.renderables.Entity e : entities.values()) {
            e.second ();
        }

    }

    public int getTime() {
        return time;
    }

    public void genTree(int x, int y) {
        Block[][] treeStruct = tree.getStruct();
        for (int i = 0; i < treeStruct.length; i++) {
            for (int j = 0; j < treeStruct[i].length; j++){
                try {
                    mapR[ y + i][x + j] = BlockHandler.handleBlockRenderer(treeStruct[i][j], (x + j) * 64, (y + i) * 64);
                } catch (ArrayIndexOutOfBoundsException e ){
                    e.printStackTrace();
                }
            }
        }
    }
}
