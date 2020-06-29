package pl.c0.kaczuch.sudoku.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuModel
{
    public int[][] get_numbers_from_file()
    {
        File f = new File(System.getProperty("user.dir") + "/src/main/java/pl/c0/kaczuch/sudoku/model/numbers.txt");
        int[][] numbers = new int[9][9];
        try
        {
            Scanner s = new Scanner(f);
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    numbers[i][j] = s.nextInt();
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return numbers;
    }
}