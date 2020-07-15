package pl.c0.kaczuch.sudoku.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuModel
{


    public int[][] create_sudoku()
    {
        int[][] numbers = {
                {3, 0, 1, 0, 0, 0, 7, 0, 5},
                {5, 4, 0, 0, 3, 7, 1, 2, 6},
                {0, 8, 2, 6, 5, 1, 4, 0, 3},
                {2, 5, 0, 3, 0, 0, 6, 0, 0},
                {4, 9, 0, 5, 7, 6, 0, 0, 0},
                {0, 0, 6, 2, 8, 0, 5, 3, 0},
                {0, 0, 0, 0, 9, 5, 0, 4, 8},
                {0, 0, 0, 7, 0, 3, 9, 5, 1},
                {0, 0, 5, 0, 2, 0, 0, 6, 0}
        };
        return numbers;
    }
    }