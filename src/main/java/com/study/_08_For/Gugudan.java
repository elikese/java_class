package com.study._08_For;

public class Gugudan {
    public static void main(String[] args) {

        /*
        [2단]
        2 x 1 = 2
        2 x 2 = 4
        ...
        2 x 9 = 18

        ...

        [9단]
        9 x 1 = 9
        ...
        9 x 9 = 81
         */


        System.out.println("[구구단]");

        for(int dan = 2; dan <= 9; dan++) {
            System.out.println("[" + dan + "단]");
            for(int num = 1; num <= 9; num++) {
                System.out.println(dan + " x " + num + " = " + (dan * num));
            }
            System.out.println();
        }

    }
}
