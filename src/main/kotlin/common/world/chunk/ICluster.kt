package common.world.chunk

interface ICluster {
    val id: Int
    fun getChunk(ID: Int): IChunk
}
