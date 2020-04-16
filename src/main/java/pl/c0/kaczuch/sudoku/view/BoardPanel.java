package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel
{
    private TextField[][] numberBoxes;

    public BoardPanel(int rows,int cols)
    {
        GridLayout gl = new GridLayout(rows,cols);
        this.setLayout(new GridLayout(rows,cols));
        numberBoxes = new TextField[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                this.numberBoxes[i][j] = new TextField("1");
            }
        }

    }
}

class NumberBox extends JComponent
{
    NumberField[][] nf;
    public NumberBox(int rows,int cols)
    {
        this.setLayout(new GridLayout(rows,cols));
        nf = new NumberField[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                nf[i][j] = new NumberField();
                this.add(nf[i][j]);
            }
        }
    }
}
