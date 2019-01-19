package me.heng.struct;

import com.alibaba.fastjson.JSON;

/**
 *  graph below actangle
 *  * X X X X
 *  * X O O X
 *  * X X O X
 *  * X O X X
 * AUTHOR: wangdi
 * DATE: 2019-01-03
 * TIME: 15:54
 */
public class Board2D {




    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        System.out.println(board[0][3]);
        System.out.println(JSON.toJSONString(board));
    }
}
