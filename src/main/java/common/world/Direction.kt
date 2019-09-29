package common.world

/** Two enums doesn't really warrant an enum class. Perhaps consider using a boolean instead? isLeft or isRight for ex.  */
// Will help if we get vehicles that move up, down, left, and right. (Ex. Spacecraft that can point in any angle in between and or equal 0 to 360.
@Deprecated("")
enum class Direction {
    LEFT, RIGHT, UP, DOWN
}
