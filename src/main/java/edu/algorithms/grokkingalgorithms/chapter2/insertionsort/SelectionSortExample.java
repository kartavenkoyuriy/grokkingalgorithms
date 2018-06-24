package edu.algorithms.grokkingalgorithms.chapter2.insertionsort;

//TODO implement other sorts
public class SelectionSortExample {

    public static void main(String[] args) {
        int[] unsortedArray01 = new int[]{4, -1, 99, 35, -100, -100, 26, 19, 99, -100};

        int[] result = selectionSort(unsortedArray01);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            stringBuilder
                    .append(result[i])
                    .append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder.toString());
    }

    public static int[] selectionSort(int[] unsortedArray){
        for (int i = 0; i < unsortedArray.length; i++) {
            int indexOfMin = findIndexOfMin(unsortedArray, i);
            swapIntInArray(unsortedArray, i, indexOfMin);
        }
        return unsortedArray;
    }

    private static int findIndexOfMin(int[] array, int start){
        int min = start;
        for (int i = start + 1; i < array.length; i++) {
            if(array[min] > array[i]){
                min = i;
            }
        }
        return min;
    }

    private static void swapIntInArray(int[] array, int indexOne, int indexTwo){
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

}
