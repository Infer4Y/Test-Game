package client.renderables;

import common.block.Block;
import common.registries.Blocks;
import org.w3c.dom.events.MouseEvent;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CurrentlySelected implements Drawable, Entity, MouseWheelListener, KeyListener{
    public Block selected=Blocks.grass;

    @Override
    public void draw(Graphics g) {
        BufferedImage texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
        try {
            texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/"+selected.getName()+".png")), 2.0);
        } catch (IOException | NullPointerException e1) {
            try {
                texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 2.0);
            } catch (IOException ex) {
                texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                ex.printStackTrace();
            }
            e1.printStackTrace();
        }
        g.drawImage(texture, 16,16 , null);
    }

    @Override
    public void tick() {

    }

    @Override
    public void second() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_1:
                selected = Blocks.grass;
                break;
            case KeyEvent.VK_2:
                selected = Blocks.dirt;
                break;
            case KeyEvent.VK_3:
                selected = Blocks.stone;
                break;
            default:
                 break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
    }
}
