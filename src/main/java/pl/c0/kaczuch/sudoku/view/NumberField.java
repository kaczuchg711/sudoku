package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;

public class NumberField extends JTextField
{
    public NumberField()
    {
        super();
    }

    public void setNumber(int number)
    {
        setText(Integer.toString(number));
    }
}
