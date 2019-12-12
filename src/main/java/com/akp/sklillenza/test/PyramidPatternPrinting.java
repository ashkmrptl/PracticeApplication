package com.akp.sklillenza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPatternPrinting {
    static int count = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                String[] arr = br.readLine().split("\\s");
                int h = Integer.parseInt(arr[1]);
                char[] array = arr[0].toCharArray();
                int u = Integer.parseInt(arr[2]);

                count = 0;
                int height = 1;
                if (u == 1) {
                    for (int i = 1; i <= h; i++) {
                        for (int k = 1; k <= h - i; k++) {
                            System.out.print(" ");
                        }
                        if (height % 2 != 0) {//left to right
                            for (int j = 0; j < noOfElementsInGivenLevel(i); j++) {
                                System.out.print(getCharToPrint(array));
                                count++;
                            }
                        } else {
                            StringBuffer sb = new StringBuffer();
                            for (int j = noOfElementsInGivenLevel(i) - 1; j >= 0; j--) {
                                sb.append(getCharToPrint(array));
                                //System.out.print(getCharToPrint(array));
                                count++;
                            }
                            System.out.print(sb.reverse());
                        }
                        height++;
                        System.out.println();
                    }
                } else {
                    for (int i = h; i >= 1; i--) {
                        for (int k = 1; k <= h - i; k++) {
                            System.out.print(" ");
                        }
                        if (height % 2 != 0) {//left to right
                            for (int j = 0; j < noOfElementsInGivenLevel(i); j++) {
                                System.out.print(getCharToPrint(array));
                                count++;
                            }
                        } else {
                            StringBuffer sb = new StringBuffer();
                            for (int j = noOfElementsInGivenLevel(i) - 1; j >= 0; j--) {
                                sb.append(getCharToPrint(array));
                                count++;
                            }
                            System.out.print(sb.reverse());
                        }
                        height++;
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static char getCharToPrint(char[] array) {
        int index = count > array.length - 1 ? 0 : count;
        count = index;

        return array[count];
    }

    private static int noOfElementsInGivenLevel(int level) {
        return 2 * level - 1;
    }
}
