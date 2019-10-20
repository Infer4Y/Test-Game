package common.block

import common.Game
import common.registries.RegistryNameable
import common.registries.ResourceLocation
import common.world.World

abstract class Block(name: String, hardness: Float = 1.0f, blastResistance: Float = 1.0f, solid : Boolean = true, tickable:Boolean = false): RegistryNameable(name) {
    var name: String
        protected set
    private val hardness: Float
    private val blastResistance : Float
    private val solid : Boolean
    private val tickable : Boolean // Many for tiles that have special properties
    private val location : ResourceLocation

    init {
        this.name = name
        this.hardness = hardness
        this.blastResistance = blastResistance
        this.solid = solid
        this.tickable = tickable
        this.location = ResourceLocation(Game.DOMAIN, "tex/$name.png")
    }

    //TODO: Make this function work. Pass in the world, block state, and the player (only players can right click)
    open fun onBlockRightClick() {}

    //TODO: Make this function work. Pass in the world, block state, and the ENTITY (not player, because other entities can collide)
    open fun onBlockCollision() {}

    open fun onTick(world: World, x: Int, y: Int) {
        if (!tickable) {return}
    }

    open fun isSolid(): Boolean{
        return solid
    }

}
