package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SudokuView extends JFrame
{
    private BoardPanel boardPanel;
    private ButtonPanel buttonPanel;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;



    public SudokuView()
    {
        this.buttonPanel = new ButtonPanel("gen","cos1","cos2");
        this.boardPanel = new BoardPanel(3,3);

        this.setLayout(new GridLayout(1,2));

        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Sudoku");
        this.getContentPane().setBackground(new Color(255,0,0));

        this.add(this.boardPanel);
        this.add(this.buttonPanel);
        this.setVisible(true);
        this.pack();
    }

    public void addStatementListener(ActionListener listenForGen)
    {
        this.getButtonPanel().getButton("gen").addActionListener(listenForGen);
    }

    public ButtonPanel getButtonPanel()
    {
        return buttonPanel;
    }

    public void genNumbers(int[][] numbers)
    {
        for (int i = 0; i < numbers.length ; i++)
        {
            for (int j = 0; j < numbers.length; j++)
            {
                this.boardPanel.getNumberBoxes()[i%3][0].getNf()[0][0].setNumber(numbers[i][j]);
                System.out.println("["+(i%3)   +"]"+"["+0+"]"+        "["+0+"]"+"["+0+"]");
//           1.                                    0  0          0  0
//                                                 0  0          0  1
//                                                 0  0          0  2
//                                                 0  1          0  0
//                                                 0  1          0  0
//                                                 0  1          0  0
//                                                 1  0          0  0
//                                                 1  0          0  0
//                                                 1  0          0  0
//                                                 1  1          0  0


            }
        }
    }
}
