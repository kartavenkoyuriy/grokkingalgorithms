package edu.algorithms.grokkingalgorithms.chapter1.binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchExampleTest {
    @Test
    public void shouldReturnFalseIfArrayIsEmpty() {
        assertEquals(-1, BinarySearchExample.binarySearch(new int[]{}, 1));
    }

    @Test
    public void shouldReturnFalseIfNotFoundInSortedOddArray() {
        assertEquals(-1,
                BinarySearchExample.binarySearch(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 9));
    }

    @Test
    public void shouldReturnFalseIfNotFoundInSortedEvenArray() {
        assertEquals(-1,
                BinarySearchExample.binarySearch(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18},
                        9));
    }

    @Test
    public void shouldReturnTrueIfFoundAsFirstInSortedArray() {
        assertEquals(0,
                BinarySearchExample.binarySearch(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 0));
    }

    @Test
    public void shouldReturnTrueIfFoundAtEndInSortedArray() {
        assertEquals(8,
                BinarySearchExample.binarySearch(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 16));
    }

    @Test
    public void shouldReturnTrueIfFoundInMiddleInSortedArray() {
        assertEquals(4,
                BinarySearchExample.binarySearch(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 8));
    }
}