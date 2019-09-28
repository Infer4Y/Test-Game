package client

import java.io.*

class Sound(val name: String) {
    private var audioFile: File? = null

    init {

        this.javaClass.classLoader.getResource("sounds/$name.wav")?.let {
            this.audioFile = File(it.file)
        } // TODO: Logger warn here if null.
    }

    fun play() {}
}
