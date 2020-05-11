package inferno.common.world;

import inferno.common.world.chunks.Chunk;

import java.util.ArrayList;

public class World {
    private ArrayList<Chunk> chunks = new ArrayList<>();
    private String name;
    private int x, y;

    public World (String name){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
