package inferno.utils;

public class MathUtils {
    public static int round(double i, int v){
        return Math.toIntExact(Math.round(i / v) * v);
    }
}
