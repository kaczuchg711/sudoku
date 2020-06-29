package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;

public class NumberField extends JTextField
{
    public NumberField()
    {
        super();
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setNumber(int number)
    {
        this.setEditable(false);
        setText(Integer.toString(number));
    }
}
