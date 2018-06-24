package edu.algorithms.grokkingalgorithms.chapter1.binarysearch.leetcode;

public class PeakIndexInAMountainArray852 {
    public static void main(String[] args) {
        int[] ints01 = new int[]{0,1,0};
        int[] ints02 = new int[]{0,2,1,0};
        int[] ints03 = new int[]{1,3,5,7,9,11,13,11};

//        int[] intsMax = new int[350_000_000];
//        for (int i = 0; i < 350_000_000 - 1; i++) {
//            intsMax[i]=i;
//        }

        long start = System.currentTimeMillis();
        System.out.println("result:" + peakIndexInMountainArrayByBinarySearch(ints03));
        System.out.println("time:" + (System.currentTimeMillis()-start));



//        System.out.println(peakIndexInMountainArray(ints01));
//        System.out.println(peakIndexInMountainArray(ints02));
    }

//    1
    public static int peakIndexInMountainArrayLinear(int[] A) {
        int max = 0;
        if(A[max] > A[1]){
            return max;
        } else {
            max = 1;
        }
        for (int i = 1; i <= A.length - 2; i++){
            if(A[max] > A[i-1] && A[max] > A[i+1]){
                return max;
            } else {
                max = i+1;
            }
        }
        return max+1;
    }

//    2
    public static int peakIndexInMountainArrayLinearRefactored(int[] A){
        int i = 0;
        while(A[i] < A[i+1]){
            i++;
        }
        return i;
    }

//    3
    public static int peakIndexInMountainArrayByBinarySearch(int[] A) {
        int start = 0;
        int end = A.length - 1;

        int middle = 0;
        while(start <= end){
            middle = (end + start) / 2;
            if(A[middle] > A[middle-1] && A[middle] > A[middle+1]){
                return middle;
            } else if(A[middle] < A[middle-1]){
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return middle;
    }

//    4
    public static int peakIndexInMountainArrayByBinarySearchRefactored(int[] A){
       int lo = 0;
       int hi = A.length - 1;

       while (lo < hi){
           int mid = (lo + hi) / 2;
           if (A[mid] > A[mid + 1]){
               hi = mid;
           } else {
               lo = mid + 1;
           }
       }
       return lo;
    }
}
