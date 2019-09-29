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

    /** These two functions will CRASH the server because they will be calling client code server side, when that
     * Client code won't exist server side!
     *
     * Additionally, they need to pass the actual block with the actual positions.
     */
    @Deprecated("")
    abstract fun onBlockRightClick()

    @Deprecated("")
    abstract fun onBlockCollision()

    abstract fun onTick(world: World, x: Int, y: Int)
}
