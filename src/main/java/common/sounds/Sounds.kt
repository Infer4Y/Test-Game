package common.sounds

import java.util.HashMap

object Sounds {
    private val sounds = HashMap<String, Sound>()
    var rain = Sound("raindrop")
    var block_break = Sound("block_break")

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
