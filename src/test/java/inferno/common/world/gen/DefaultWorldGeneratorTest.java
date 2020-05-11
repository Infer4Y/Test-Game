package inferno.common.world.gen;

import inferno.utils.Referance;
import org.joml.SimplexNoise;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultWorldGeneratorTest {
    class DataPos {
        int x, y;
        float data;

        public DataPos(int x, int y, float data) {
            this.x = x;
            this.y = y;
            this.data = data;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public float getData() {
            return data;
        }
    }

    @Test
    public void generate() {
        DataPos[] dataPos = new DataPos[Referance.CHUNKWIDTH*Referance.CHUNKHEIGHT];
        for (int y = 0; y < Referance.CHUNKHEIGHT ; y++) {
            for (int x = 0; x < Referance.CHUNKWIDTH; x++) {
                float result = SimplexNoise.noise(x, x == 0 ? y : dataPos[(x-1)*Referance.CHUNKWIDTH+y].getData());

                System.out.println(result);

                dataPos[x*Referance.CHUNKWIDTH+y] = new DataPos(x, y, result);
            }
        }
    }
}