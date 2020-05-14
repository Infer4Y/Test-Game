package inferno.common.world;

import inferno.common.entities.Entity;
import inferno.common.entities.Player;
import inferno.utils.Referance;
import org.joml.Vector2f;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {
    private World testingWorld = new World("Test");

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void update() {
        Player testingPlayer = new Player("testplayer",1,1);
        testingPlayer.setLocation(new Vector2f(0,0));
        Player testingPlayer2 = new Player("testplayer2",1,1);
        testingPlayer2.setLocation(new Vector2f(0,100));
        Player testingPlayer3 = new Player("testplayer3",1,1);
        testingPlayer3.setLocation(new Vector2f(0,-100));
        for (int i = 0; i < 100; i++) {
            Entity temp = new Entity("test"+i,1,1);
            temp.setLocation(new Vector2f(Referance.RANDOM.nextInt(200) - 100, Referance.RANDOM.nextInt(200) - 100));
            testingWorld.addEntity(temp);
        }

        testingWorld.addEntity(testingPlayer);
        testingWorld.addEntity(testingPlayer2);
        testingWorld.addEntity(testingPlayer3);
        testingWorld.update();
    }
}