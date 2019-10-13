package client.scenes;

import client.ClientGame;
import client.ui.Button;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseEvent;

public class SceneMenu extends Scene {
    private Button start = new Button( 64, 1112, 64, 256, ( ) -> { }) {
        @Override
        public void draw(Graphics g){
            g.setColor(Color.green);
            g.drawRect(this.x, this.y, this.xBound, this.yBound);
            g.setColor(Color.white);
            g.drawString("Start!", x + (1112+g.getFont().getSize())/2, y+16);
        }
    };
    private Button exit = new Button( 64, 1112, 64, 256, ( ) -> {
        ClientGame.getInstance().dispose();
    }) {
        @Override
        public void draw(Graphics g){
            g.setColor(Color.RED);
            g.drawRect(this.x, this.y, this.xBound, this.yBound);
            g.setColor(Color.white);
            g.drawString("Exit", x + (1112+g.getFont().getSize())/2, y+16);
        }
    };

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
    }
}
