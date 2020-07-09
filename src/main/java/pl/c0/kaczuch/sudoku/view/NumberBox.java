package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class NumberBox extends JComponent
{
    NumberField[][] nf;
    final int xx;
    final int yy;

    public NumberBox(int rows, int cols, int xx, int yy)
    {
        this.xx = xx;
        this.yy = yy;
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

    public int getXX()
    {
        return xx;
    }

    public int getYY()
    {
        return yy;
    }

    public NumberField[][] getNf()
    {
        return nf;
    }

    public void showNumberField()
    {
        for (int i = 0; i < nf.length; i++)
        {
            for (int j = 0; j < nf.length; j++)
            {
                System.out.printf("|%3s|",this.nf[i][j].getText());
            }
            System.out.println();
        }
        System.out.println();
    }


}