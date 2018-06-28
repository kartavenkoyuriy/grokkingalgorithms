package edu.algorithms.grokkingalgorithms.chapter5.hashtable;

import edu.algorithms.grokkingalgorithms.chapter5.hashtable.hashcodebased.TenBased;

import java.util.LinkedList;
import java.util.List;

public class SimplifiedTenBasedHashMap<T extends TenBased> {
    private T item;
    int[] keysArray = new int[10];
    int[] valuesArray = new int[10];

    List<T> items = new LinkedList<>();

    public void put(T item){
        int position = item.hashCode();
    }
}
