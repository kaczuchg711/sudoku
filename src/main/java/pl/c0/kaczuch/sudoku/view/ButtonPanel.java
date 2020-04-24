package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel
{
    private JButton[] buttons;

    public ButtonPanel(int n)
    {
        this.buttons = new JButton[n];

        for (int i = 0; i < n; i++)
        {
            this.buttons[i] = new JButton();
        }

        this.setLayout(new GridLayout(n, 1));

        setMinimumSize(new Dimension(WIDTH, HEIGHT));

        for (JButton a : buttons)
        {
            this.add(a);
        }
        this.setVisible(true);
    }

    public ButtonPanel(String... texts)
    {
        this.buttons = new JButton[texts.length];

        for (int i = 0; i < texts.length; i++)
        {
            this.buttons[i] = new JButton(texts[i]);
        }

        this.setLayout(new GridLayout(texts.length, 1));

        setMinimumSize(new Dimension(WIDTH, HEIGHT));

        for (JButton a : buttons)
        {
            this.add(a);
        }
        this.setVisible(true);
    }
}