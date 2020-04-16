package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SudokuView extends JFrame
{
    private BoardPanel panel;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    public SudokuView()
    {
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        this.panel = new BoardPanel(3,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Sudoku");
        this.getContentPane().setBackground(new Color(50,50,50));
        this.add(this.panel);
        this.pack();
    }


}
