package com.akp.gfg.practice.matrix;

public class SearchElementInRowWiseAndColumnWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        searchElement(array, 8);
        searchElement(array, 89);
    }

    /**
     * As we know that the matrix is sorted both row wise and column wise we'll start searching from top right element,
     * if the element is greater that the current elem then we'll move to next row else we'll search in the current row.
     *
     * @param array
     * @param element
     */
    private static void searchElement(int[][] array, int element) {
        int row = 0;
        int col = array.length - 1;

        while (row < array.length && col < array.length) {
            if (element == array[row][col]) {
                System.out.println("Element is found at : (" + row + ", " + col + ")");
                return;
            } else if (element > array[row][col]) {//move to next row
                row++;
            } else {//search in current row
                col--;
            }
        }
        System.out.println("Element is not found.");
    }
}
