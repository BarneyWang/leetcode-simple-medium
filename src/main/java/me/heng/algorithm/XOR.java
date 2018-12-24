package me.heng.algorithm;

/**
 * AUTHOR: wangdi
 * DATE: 2018-12-23
 * TIME: 17:40
 */
public class XOR {


    public static void main(String[] args) {
        int i = 15, j = 2,z=9,x=15,y=2;
        i ^=j;
        System.out.println("i ^ j = " + i);
        i ^= z;
        System.out.println("i ^ j = " + i);
        i ^= x;
        System.out.println("i ^ j = " + i);
        i ^= y;
        System.out.println("i ^ j = " + i);
    }
}
