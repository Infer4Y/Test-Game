package client;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
    private JFrame frame;
    public Window (int width, int height, String title, Game game) {
        game.setPreferredSize(new Dimension (width, height));
        game.setMaximumSize(new Dimension (width, height));
        game.setMinimumSize(new Dimension (width, height));

        frame = new JFrame (title);
        frame.addKeyListener(game);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setResizable (false);
        frame.setVisible (true);
        frame.requestFocus();
        frame.add (game);
        frame.pack ();
        frame.setLocationRelativeTo (null);
    }
}
