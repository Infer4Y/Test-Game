package xavier.project_iodine.common.world;

import com.badlogic.gdx.graphics.Color;
import org.mini2Dx.core.graphics.Graphics;

public class World {
    private String name;
    private int x, y;
    private int time;



    public World (String name, int x, int y){
        this.x = x;
        this.y = y;
        this.name = name;
        time = 1199;
    }

    public void draw(Graphics g){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return x;
    }

    public int getHeight(){
        return y;
    }

    public void update() {
    }

    public void updatePerSecond () {
        if (time == 2400){
            time = 0;
        } else {
            time++;
        }

    }

    public int getTime() {
        return time;
    }

}
