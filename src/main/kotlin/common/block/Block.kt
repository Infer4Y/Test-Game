package common.block

import common.registries.RegistryNameable
import common.world.World

abstract class Block(name: String): RegistryNameable(name) {
    var name: String
        protected set
    private val hardness: Float = 0.toFloat()
    private val blastResistance = 1.0f
    private val solid = true

    init {
        this.name = name
    }

    //TODO: Make this function work. Pass in the world, block state, and the player (only players can right click)
    open fun onBlockRightClick() {}

    //TODO: Make this function work. Pass in the world, block state, and the ENTITY (not player, because other entities can collide)
    open fun onBlockCollision() {}

    @Deprecated("All blocks should NOT tick!!! This will lag your game immensely.")
    open fun onTick(world: World, x: Int, y: Int) {}
}
