package edu.algorithms.grokkingalgorithms.chapter1.binarysearch;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 5, 7, 9};
        int[] ints1 = new int[]{3, 5, 7, 9};

//        System.out.println(binarySearch(ints, 1));
//        System.out.println(binarySearch(ints, 5));
//        System.out.println(binarySearch(ints1, 5));
//        System.out.println(binarySearch(ints1, 2));
//        System.out.println(binarySearch(ints1, 9));
    }

    static int binarySearch(int[] array, int elem) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int middle = (end + start) / 2;
            if (array[middle] == elem) {
                return middle;
            } else if (array[middle] > elem) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
