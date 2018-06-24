package edu.algorithms.grokkingalgorithms.chapter3.recursion;

//TODO leetcode only few tasks with mixed tags, so need to go back to them later
public class FactorialExample {
    public static void main(String[] args) {
        System.out.println(factorial(5));
//        countBack(5);
    }

    private static void countBack(int i){
        if(i != 0){
            System.out.println(i);
            countBack(i - 1);
        }
    }

    private static int factorial(int i) {
        //or 1 or <=1
        if(i == 0){
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }

    private static int factorial2(int i) {
        if(i != 1){
            return i * factorial2(i - 1);
        } else {
            return 1;
        }
    }
}
