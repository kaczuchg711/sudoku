package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel
{
    private NumberBox[][] numberBoxes;

    public BoardPanel(int rows, int cols)
    {
        GridLayout gl = new GridLayout(rows, cols);
        this.setLayout(new GridLayout(rows, cols, 3, 3));
        this.setBackground(new Color(0, 0, 0));
        this.numberBoxes = new NumberBox[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                this.numberBoxes[i][j] = new NumberBox(3, 3, i, j);
                this.add(this.numberBoxes[i][j]);
            }
        }
    }

    public NumberBox[][] getNumberBoxes()
    {
        return numberBoxes;
    }

    public void setNumberBoxes(NumberBox[][] numberBoxes)
    {
        this.numberBoxes = numberBoxes;
    }

    public void show_number_NumberBoxes()
    {
        for (NumberBox[] x : numberBoxes)
        {
            for (NumberBox y : x)
            {
                y.showNumberField();
            }
        }
        ;
    }
}


