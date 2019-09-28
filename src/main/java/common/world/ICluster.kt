package common.world

interface ICluster {
    val id: Int
    fun getChunk(ID: Int): IChunk
}
