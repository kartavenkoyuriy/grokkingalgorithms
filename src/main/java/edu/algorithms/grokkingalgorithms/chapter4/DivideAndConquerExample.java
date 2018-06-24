package edu.algorithms.grokkingalgorithms.chapter4;

import java.util.Arrays;

public class DivideAndConquerExample {

    public static void main(String[] args) {
//        System.out.println(maxSquareField_InCaseLengthBigger(1680, 640));
//        System.out.println(maxSquareField_NoMatterWhichIsBigger(640, 1680));

//        int[] array02 = new int[]{1, 2, 3, 4, 5};
//        System.out.println(arraySum_byLoop(array02));
//        System.out.println(arraySum_byRecursion_divideAndConquer(array02));

//        int[] array03 = new int[]{1, 2, 3, 4, 5};
//        System.out.println(arrayLength_byLoop(array03));
//        System.out.println(arrayLength_byRecursion_divideAndConquer(array03));

//        int[] unsortedArray01 = new int[]{4, -1, 99, 35, -100, -100, 26, 19, 99, -100, 200};
//        System.out.println(maxFromArray_byLoop(unsortedArray01));
//        System.out.println(maxFromArray_byRecursion_divideAndConquer(unsortedArray01));

        int[] ints03 = new int[]{1,3,5,7,9,11,13,11};
        System.out.println(binarySearch_byLoop(ints03, 9));
    }

    public static int maxSquareField_InCaseLengthBigger(int length, int width) {
        if (length % width == 0) {
            return width;
        }

        return maxSquareField_InCaseLengthBigger(width, length % width);
    }

    // in this case the order doesn't matter(640 % 1680 = 640)
    public static int maxSquareField_NoMatterWhichIsBigger(int length, int width) {
        if (length % width == 0) {
            return width;
        }

        return maxSquareField_NoMatterWhichIsBigger(width, length % width);
    }

//    4.1
    public static int arraySum_byLoop(int[] array) {
        int sum = array[0];

        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }

    public static int arraySum_byRecursion_divideAndConquer(int[] array) {
        if (array.length == 1) {
            return array[0];
        } else {
            return array[0] + arraySum_byRecursion_divideAndConquer(Arrays.copyOfRange(array, 1, array.length));
        }
    }

//    4.2
    public static int arrayLength_byLoop(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum++;
        }

        return sum;
    }

    public static int arrayLength_byRecursion_divideAndConquer(int[] array) {
        if (array.length == 1) {
            return 1;
        } else {
            return 1 + arrayLength_byRecursion_divideAndConquer(Arrays.copyOfRange(array, 1, array.length));
        }
    }

//    4.3
    public static int maxFromArray_byLoop(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        return max;
    }

    public static int maxFromArray_byRecursion_divideAndConquer(int[] array) {
        if (array.length == 2) {
            return array[0] > array[1] ? array[0] : array[1];
        }
        int subMax = maxFromArray_byRecursion_divideAndConquer(Arrays.copyOfRange(array, 1, array.length));
        return subMax > array[0] ? subMax : array[0];
    }

//    4.4
    public static int binarySearch_byLoop(int[] array, int elem){
        int lo = 0;
        int hi = array.length - 1;

        while (lo < hi){
            int mid = (lo + hi) / 2;
            if (array[mid] > elem) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

}

