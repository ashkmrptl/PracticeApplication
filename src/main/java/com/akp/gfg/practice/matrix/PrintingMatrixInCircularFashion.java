package com.akp.gfg.practice.matrix;

public class PrintingMatrixInCircularFashion {
    public static void main(String[] args) {
        int row = 3;
        int col = 6;
        int[][] array = {{1, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18}};
        printCircular(array, row, col);
    }

    private static void printCircular(int[][] array, int row, int col) {
        int i = 0;
        int rowIndex = 0;
        int colIndex = 0;

        while (rowIndex < row && colIndex < col) {
            //Printing the first row from left to right
            for (i = colIndex; i < col; i++) {
                System.out.print(array[rowIndex][i] + " ");
            }
            rowIndex++;//Moving to next row

            //Printing last column from remaining column
            for (i = rowIndex; i < row; i++) {
                System.out.print(array[i][col - 1] + " ");
            }
            col--;

            //Printing last row from remaining row
            if (rowIndex < row) {
                for (i = col - 1; i >= colIndex; i--) {
                    System.out.print(array[row - 1][i] + " ");
                }
                row--;
            }

            //Printing first column from the remaining column
            if (colIndex < col) {
                for (i = row - 1; i >= rowIndex; i--) {
                    System.out.print(array[i][colIndex] + " ");
                }
                colIndex++;
            }
        }

    }

}
