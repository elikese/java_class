package com.study._15_Method;

public class Parameter {

    public static void greeting(String username) {
        System.out.println("hello~ " + username);
    }

    public static void printAddValue(int num1, int num2) {
        System.out.println("두 수의 합: " + (num1 + num2));
    }

    public static void main(String[] args) {
        String name = "java";
        greeting(name);

        int a = 10, b = 20;
        printAddValue(a, b);
    }

}
