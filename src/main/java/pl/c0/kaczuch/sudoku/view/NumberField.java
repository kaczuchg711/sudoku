package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;

public class NumberField extends JTextField
{
    final int x;
    final int y;



    public NumberField(int nr,int x,int y)
    {
        super();
        this.x = x;
        this.y = y;
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setText(Integer.toString(nr));
    }

    public NumberField(int x,int y)
    {
        super();
        this.x = x;
        this.y = y;
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setNumber(int number)
    {
        this.setEditable(false);
        setText(Integer.toString(number));
    }


}
