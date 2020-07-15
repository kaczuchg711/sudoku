package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.EventListener;

public class SudokuView extends JFrame
{
    private BoardPanel boardPanel;
    private ButtonPanel buttonPanel;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public SudokuView()
    {
        this.buttonPanel = new ButtonPanel(make_vertical("START"));
        this.boardPanel = new BoardPanel(3, 3);

        this.setLayout(new GridLayout(1, 2));

        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Sudoku");
        this.getContentPane().setBackground(new Color(255, 0, 0));


        this.add(this.boardPanel);
        this.add(this.buttonPanel);

        this.pack();
    }

    public void addStatementListener(ActionListener listenForGen)
    {
        this.getButtonPanel().getButtons()[0].addActionListener(listenForGen);
    }

    public void addNumberInListener(EventListener[][] lisnerForNF)
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    for (int l = 0; l < 3; l++)
                    {
                        this.boardPanel.getNumberBoxes()[i][j].getNf()[k][l].addFocusListener((FocusListener) lisnerForNF[j + i * 3][l + k * 3]);
                    }
    }

    public ButtonPanel getButtonPanel()
    {
        return buttonPanel;
    }

    public BoardPanel getBoardPanel()
    {
        return boardPanel;
    }

    public void setNumbers(int[][] numbers)
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int ii = 0; ii < 3; ii++)
                    for (int jj = 0; jj < 3; jj++)
                    {
                        if (numbers[ii + i * 3][jj + j * 3] == 0)
                            continue;
                        this.boardPanel.getNumberBoxes()[i][j].getNf()[ii][jj].setNumber(numbers[ii + i * 3][jj + j * 3]);
                    }
    }

    public static String make_vertical(String s)
    {
        StringBuilder sb = new StringBuilder("<html></html>");
        int i = 6;
        for (char c: s.toCharArray())
        {
            sb.insert(i,c + "<br>");
            i+=5;
        }

        return sb.toString();
    }


}
