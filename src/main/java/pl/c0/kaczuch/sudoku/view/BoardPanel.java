package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel
{

    private NumberField[][] numberFieldTab;

    public BoardPanel()
    {

        this.setLayout(new GridLayout(9,9));

        numberFieldTab = new NumberField[9][9];
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                numberFieldTab[i][j] = new NumberField();
                this.add(numberFieldTab[i][j]);
            }
        }


    }
}
