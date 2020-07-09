package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.util.Objects;

public class NumberField extends JTextField
{
    final int xx;
    final int yy;

    public NumberField(int nr, int xx, int yy)
    {
        super();
        this.xx = xx;
        this.yy = yy;
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setText(Integer.toString(nr));
    }

    public NumberField(int xx, int yy)
    {
        super();
        this.xx = xx;
        this.yy = yy;
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setNumber(int number)
    {
        this.setEditable(false);
        setText(Integer.toString(number));
    }

    public int getXX()
    {
        return xx;
    }

    public int getYY()
    {
        return yy;
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
