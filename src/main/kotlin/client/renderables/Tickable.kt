package client.renderables


abstract class Tickable {
    abstract fun onTick()
    @Deprecated("Really for the fps counter. Other than that we would use ticks.")
    abstract fun second()
}