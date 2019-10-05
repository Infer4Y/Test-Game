package common

import talaria.common.utils.Version

abstract class Game {
    // TODO: Base game stuff that is shared between the client and the server should be shared here.
    // TODO: Additionally, Game (the other class) should be renamed to ClientGame.
    // If your game had a name, these 3 classes would be renamed respectfully to the game title.

    abstract fun update()

    companion object {
        @JvmStatic
        var NANOSECOND: Long = 1000000000
        @JvmStatic
        var OPTIMAL_TICKS = 50.0
        @JvmStatic
        val OPTIMAL_TIME = NANOSECOND / OPTIMAL_TICKS
        @JvmStatic
        val NAME: String = "iodine"
        @JvmStatic
        val VERSION: Version = Version("0.0.0.PA")
        val DOMAIN: String = "iodine"
    }

}