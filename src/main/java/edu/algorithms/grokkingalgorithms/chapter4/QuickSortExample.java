package edu.algorithms.grokkingalgorithms.chapter4;

import java.util.Arrays;

public class QuickSortExample {
    public static void main(String[] args) {
//        int[] ints = concatenateForQuickSort(new int[]{1, 2, 3}, 4, new int[]{5, 6, 7});
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }

//        int[] greater = getGreater(new int[]{1, 3, 5, 9, 27, 2, 4, 6}, 5);
//        for (int i = 0; i < greater.length; i++) {
//            System.out.println(greater[i]);
//        }

//        int[] less = getLess(new int[]{1, 3, 5, 9, 27, 2, 4, 6}, 5);
//        for (int i = 0; i < less.length; i++) {
//            System.out.println(less[i]);
//        }

        int[] sorted = quickSortExample(new int[]{1, 3, 5, 9, 27, 2, 4, 6});
//        int[] sorted = quickSortExample(new int[]{3,2,4});
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }

    }

    public static int[] quickSortExample(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int pivot = array[0];
        int[] greater = getGreater(array, pivot);
        int[] less = getLess(array, pivot);

        int[] lessSorted = quickSortExample(less);
        int[] greaterSorted = quickSortExample(greater);
        return concatenateForQuickSort(lessSorted, pivot, greaterSorted);

    }

    private static int[] getLess(int[] array, int pivot) {
        int[] resultLessArray = new int[array.length];

        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if(array[i] <= pivot){
                resultLessArray[count] = array[i];
                count++;
            }
        }

        return Arrays.copyOfRange(resultLessArray, 0, count);
    }

    private static int[] getGreater(int[] array, int pivot) {
        int[] resultGreaterArray = new int[array.length];

        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if(array[i] > pivot){
                resultGreaterArray[count] = array[i];
                count++;
            }
        }

        return Arrays.copyOfRange(resultGreaterArray, 0, count);
    }

    private static int[] concatenateForQuickSort(int[] lessSorted, int pivot, int[] greaterSorted) {
        int[] resultArray = new int[lessSorted.length + 1 + greaterSorted.length];

        System.arraycopy(lessSorted, 0, resultArray, 0, lessSorted.length);
        resultArray[lessSorted.length] = pivot;
        System.arraycopy(greaterSorted, 0, resultArray, lessSorted.length + 1, greaterSorted.length);

        return resultArray;
    }
}
