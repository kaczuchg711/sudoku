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
        this.buttonPanel = new ButtonPanel("gen", "cos1", "cos2");
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
        this.getButtonPanel().getButton("gen").addActionListener(listenForGen);
    }

    public void addNumberInListener(EventListener[][] lisnerForNF)
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    for (int l = 0; l < 3; l++)
                    {
                        this.boardPanel.getNumberBoxes()[i][j].getNf()[k][l].getDocument().addDocumentListener((DocumentListener) lisnerForNF[j + i * 3][l + k * 3]);
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

    public void genNumbers(int[][] numbers)
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

}
