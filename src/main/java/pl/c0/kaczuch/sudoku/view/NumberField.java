package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;

public class NumberField extends JTextField
{
    NumberBox parrent;

    public NumberField(NumberBox nb)
    {
        super();
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setNumber(int number)
    {
        this.setEditable(false);
        setText(Integer.toString(number));
    }

//    public NumberBox getParrent()
//    {
//        return parrent;
//    }
}
