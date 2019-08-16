package client;

import java.awt.Dimension;

import javax.swing.*;

public class Window extends JApplet {
    public Window (int width, int height, String title, Game game) {
        game.setPreferredSize(new Dimension (width, height));
        game.setMaximumSize(new Dimension (width, height));
        game.setMinimumSize(new Dimension (width, height));
        addKeyListener(game);
        requestFocus();
        add(game);
        setVisible(true);
    }
}
