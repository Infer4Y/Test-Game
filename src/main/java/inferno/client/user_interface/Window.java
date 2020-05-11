package inferno.client.user_interface;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public Window(int width, int height, String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        requestFocus();
        pack();
        setLocationRelativeTo(null);
    }
}
