package xavier.project_iodine.common.world.chunk;

import xavier.project_iodine.common.block.Block;

public interface IChunk {
    Block getBlock(int x, int y);
    int getChunkID();
    void setBlock(int x, int y);
}
