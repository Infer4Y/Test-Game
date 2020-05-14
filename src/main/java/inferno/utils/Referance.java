package inferno.utils;

import org.joml.Vector2f;
import org.joml.Vector2fc;

import java.util.Random;

public class Referance {
    public static final String NAME =    "Test-Game";
    public static final String VERSION =    "1.0.0a";

    public static final Random RANDOM = new Random();

    public static final int CHUNKWIDTH = 16;
    public static final int CHUNKHEIGHT = 16;
    public static final Vector2f GRAVITY = new Vector2f(0, .5f);
}
