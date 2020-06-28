package pl.c0.kaczuch.sudoku.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuModelTest
{

    @org.junit.jupiter.api.Test
    void get_numbers_from_file()
    {
        SudokuModel sm = new SudokuModel();

        assertTrue(sm.get_numbers_from_file()[0][0] == 0);
    }
}