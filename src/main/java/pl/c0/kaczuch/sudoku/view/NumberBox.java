package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;

public class NumberBox extends JComponent
{
    NumberField[][] numberFields;
    final int xCorInBoard;
    final int yCorInBoard;

    public NumberBox(int rows, int cols, int xCorInBoard, int yCorInBoard)
    {
        this.xCorInBoard = xCorInBoard;
        this.yCorInBoard = yCorInBoard;
        this.setLayout(new GridLayout(rows, cols,1,1));
        this.setBackground(Color.BLACK);
        numberFields = new NumberField[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                numberFields[i][j] = new NumberField(i,j);
                this.add(numberFields[i][j]);
            }
        }
    }

    public int getxCorInBoard()
    {
        return xCorInBoard;
    }

    public int getyCorInBoard()
    {
        return yCorInBoard;
    }

    public NumberField[][] getNumberFields()
    {
        return numberFields;
    }

    public void setNumberFields(NumberField[][] numberFields)
    {
        this.numberFields = numberFields;
    }

    public void setNumberFields(int[][] numberFields)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                this.numberFields[i][j].setNumber(numberFields[i][j]);
            }
        }
    }

    public void showNumberField()
    {
        for (int i = 0; i < numberFields.length; i++)
        {
            for (int j = 0; j < numberFields.length; j++)
            {
                System.out.printf("|%3s|",this.numberFields[i][j].getText());
            }
            System.out.println();
        }
        System.out.println();
    }


}