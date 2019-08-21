package xavier.project_iodine.client;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{
    public Window (int width, int height, String title, Game game) {
        super(title);
        game.setPreferredSize(new Dimension (width, height));
        game.setMaximumSize(new Dimension (width, height));
        game.setMinimumSize(new Dimension (width, height));
        addKeyListener(game);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        requestFocus();
        add(game);
        pack();
        setLocationRelativeTo(null);
    }
}
