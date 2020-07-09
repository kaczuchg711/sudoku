package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;

public class NumberBox extends JComponent
{
    NumberField[][] nf;
    final int x;
    final int y;

    public NumberBox(int rows, int cols, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.setLayout(new GridLayout(rows, cols,1,1));
        this.setBackground(Color.BLACK);
        nf = new NumberField[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                nf[i][j] = new NumberField(i,j);
                this.add(nf[i][j]);
            }
        }
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public NumberField[][] getNf()
    {
        return nf;
    }
}