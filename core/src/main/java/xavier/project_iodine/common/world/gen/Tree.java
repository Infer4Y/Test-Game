package xavier.project_iodine.common.world.gen;


import xavier.project_iodine.common.block.Block;
import xavier.project_iodine.common.registries.Blocks;

import java.util.Random;

public class Tree {
    private Block[] blocks = {
            Blocks.air,
            Blocks.leaf,
            Blocks.log
    };
    private int[][][] struct = {
            {
                {0,1,1,1,0},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {0,0,2,0,0},
                {0,0,2,0,0}
            },
            {
                {0,0,1,0,0},
                {0,1,1,1,0},
                {0,1,1,1,0},
                {0,0,2,0,0},
                {0,0,2,0,0}
            },
            {
                {0,0,1,0,0},
                {0,1,1,1,0},
                {1,1,1,1,1},
                {0,0,2,0,0},
                {0,0,2,0,0}
            },
            {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,2,0,0}
            }
    };

    public Block[][] getStruct() {
        Block[][] structBlock = new Block[5][5];
        Random r = new Random();
        int c = r.nextInt(struct.length);
        for (int i = 0; i < struct[c].length; i++) {
            for (int j = 0; j < struct[c][i].length; j++) {
                System.out.print(struct[c][j][i] + " ");
                structBlock[j][i] = blocks[struct[c][j][i]];
            }

            System.out.print("\n");
        }
        return structBlock;
    }
}
