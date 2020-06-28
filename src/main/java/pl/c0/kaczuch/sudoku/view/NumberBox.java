package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;

class NumberBox extends JComponent
{
    NumberField[][] nf;

    public NumberBox(int rows, int cols)
    {
        this.setLayout(new GridLayout(rows, cols,1,1));
        this.setBackground(Color.BLACK);
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

    public NumberField[][] getNf()
    {
        return nf;
    }
}