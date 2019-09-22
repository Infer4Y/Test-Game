package common.world;

import common.block.Block;

public interface IChunk {
    Block getBlock(int ID);
    void setBlock(int ID);
    int getID();
}
