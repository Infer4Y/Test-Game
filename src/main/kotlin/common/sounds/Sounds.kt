package common.sounds

import common.Game
import java.util.HashMap

object Sounds {
    private val sounds = HashMap<String, Sound>()
    var rain = Sound("raindrop", Game.DOMAIN)
    var block_break = Sound("block_break", Game.DOMAIN)

    fun init() {
        register(rain)
        register(block_break)
    }

    private fun register(sound: Sound) {
        sounds[sound.name] = sound
    }

    fun playSound(name: String) {
        sounds[name]?.play()
    }
}
