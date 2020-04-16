package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.awt.*;

public class NumberField extends JTextField
{
    public NumberField()
    {
        super();
        this.setMinimumSize(new Dimension(10,10));
    }
}
