package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;

public class ButtonWindow extends JFrame
{
    private static final int WIDTH = 200;
    private static final int HEIGHT = 600;

    private JButton[] buttons;

    public ButtonWindow(int n)
    {
        this.buttons = new JButton[n];

        this.buttons[0] = new JButton("generuj");
        this.buttons[1] = new JButton("cos1");
        this.buttons[2] = new JButton("cos2");
        this.buttons[3] = new JButton("cos3");
        this.buttons[4] = new JButton("cos4");

        this.setLayout(new GridLayout(n,1));


        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Przyciski");
        this.getContentPane().setBackground(new Color(50,50,50));

        for (JButton a: buttons)
        {
            this.add(a);
        }
        this.setVisible(true);
        this.pack();
    }
}