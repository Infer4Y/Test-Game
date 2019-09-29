package common.sounds

import common.registries.RegistryNameable
import java.io.File

class Sound(val name: String): RegistryNameable(name) {
    private var audioFile: File? = null

    init {

        this.javaClass.classLoader.getResource("sounds/$name.wav")?.let {
            this.audioFile = File(it.file)
        } // TODO: Logger warn here if null.
    }

    fun play() {}
}
