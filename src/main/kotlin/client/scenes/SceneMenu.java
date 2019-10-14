package client.scenes;

import client.ClientGame;
import client.ui.Button;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseEvent;

public class SceneMenu extends Scene {
    private Button start = new Button( 64, 1112, 64, 64, ( ) -> { }) {
        @Override
        public void draw(Graphics g){
            g.setColor(Color.green);
            g.fillRect(this.x, this.y, this.xBound, this.yBound);
            g.setColor(Color.white);
            g.drawString("Start!", x + (this.xBound-128+g.getFont().getSize())/2, y+16);
        }
    };
    private Button exit = new Button( 64, 1112, 256, 64, ( ) -> {
        ClientGame.getInstance().dispose();
        System.exit(0);
    }) {
        @Override
        public void draw(Graphics g){
            g.setColor(Color.RED);
            g.fillRect(this.x, this.y, this.xBound, this.yBound);
            g.setColor(Color.white);
            g.drawString("Exit", x + (this.xBound-128+g.getFont().getSize())/2, y+16);
        }
    };

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw(Graphics g){
        start.draw(g);
        exit.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        start.onClick(e.getX(), e.getY());
        exit.onClick(e.getX(), e.getY());
    }
}
