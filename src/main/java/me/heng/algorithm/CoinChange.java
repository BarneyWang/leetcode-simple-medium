package me.heng.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2: coins = [2], amount = 3 return -1.
 * 
 * Note: You may assume that you have an infinite number of each kind of coin.
 * AUTHOR: wangdi DATE: 2019-01-09 TIME: 21:23
 */
public class CoinChange {

    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 0; i < amount; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] < dp[i]) {
                    dp[i] = dp[i - coins[j]] + 1;
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = { 1, 2, 5 };
        int aomount = 11;
        List<Integer> coinList = new ArrayList<Integer>(coins.length);
        coinList.addAll(Arrays.asList(5, 2, 1));
        // System.out.print(coinChange(coins, 11));
        System.out.print(coinChange2(coins, 11));
    }
}
