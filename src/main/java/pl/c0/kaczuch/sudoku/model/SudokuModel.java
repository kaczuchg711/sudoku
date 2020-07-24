package pl.c0.kaczuch.sudoku.model;

import pl.c0.kaczuch.sudoku.view.NumberBox;
import pl.c0.kaczuch.sudoku.view.NumberField;

public class SudokuModel
{
    int[][] numbers;

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

        this.numbers = numbers;

        return numbers;
    }

    public void update_model(NumberField numberField)
    {
        NumberBox parentNumberBox = (NumberBox) numberField.getParent();

        int parenX = parentNumberBox.getxCorInBoard();
        int parenY = parentNumberBox.getyCorInBoard();

        int kidX = numberField.getxCorInBox();
        int kidY = numberField.getyCorInBox();

        this.numbers[parenX*3+kidX][parenY*3 + kidY] = numberField.getValue();
    }

    public int[][] getNumbers()
    {
        return numbers;
    }
}