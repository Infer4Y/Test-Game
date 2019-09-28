package common.world;

public interface ICluster {
    IChunk getChunk(int ID);
    int getID();
}
