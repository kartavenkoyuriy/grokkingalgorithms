package edu.algorithms.grokkingalgorithms.chapter5.hashtable;

import edu.algorithms.grokkingalgorithms.chapter5.hashtable.hashcodebased.TenBased;

import java.util.LinkedList;

public class SimplifiedTenBasedHashMap<T extends TenBased> {

    private LinkedList<T>[] valuesArray = new LinkedList[10];

    public void put(T item){
        int position = item.hashCode();
        valuesArray[position].add(item);
    }

    public boolean contains(T item){
        int position = item.hashCode();
        return valuesArray[position].contains(item);
    }

    public T get(int hash){
        int position = hash % 10;
        return valuesArray[position].get(0);
    }


}


