package com.akp.gfg.company.goldmansachs;

import java.util.ArrayList;
import java.util.List;

public class GameOfBookCricket {
    static List<String> list;
    public static void printCoinChangingSolution(int total, int coins[]) {
        String result = "";
        list = new ArrayList<>();
        printActualSolution(result, total, coins);
        System.out.println(list.size());
    }

    private static void printActualSolution(String result, int total, int[] array) {
        if (total == 0) {
            list.add(result);
            return;
        }
        if (total < 0) {
            return;
        }

        for (int coin : array) {
            if (coin <= total) {
                printActualSolution(coin + " " + result, total - coin, array);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 6};
        int k = 6;

        printCoinChangingSolution(k, arr);
    }
}
