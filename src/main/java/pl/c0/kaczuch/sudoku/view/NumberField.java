package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;

public class NumberField extends JTextField
{
    final int xCorInBox;
    final int yCorInBox;

    public NumberField(int nr, int xCorInBox, int yCorInBox)
    {
        super();
        this.xCorInBox = xCorInBox;
        this.yCorInBox = yCorInBox;
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setText(Integer.toString(nr));
    }

    public NumberField(int xx, int yCorInBox)
    {
        super();
        this.xCorInBox = xx;
        this.yCorInBox = yCorInBox;
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setNumber(int number)
    {
        this.setEditable(false);
        setText(Integer.toString(number));
    }

    public int getxCorInBox()
    {
        return xCorInBox;
    }

    public int getyCorInBox()
    {
        return yCorInBox;
    }

    public int getValue()
    {
        int res;
        try
        {
            res = Integer.parseInt(this.getText());
        }
        catch (NumberFormatException e)
        {
            res = 0;
        }
        return res;
    }
}
