package edu.algorithms.grokkingalgorithms.chapter5.hashtable;

public class HashTableExample {
    public static void main(String[] args) {
        simplifiedStringExample();
    }

    private static void simplifiedStringExample() {
        System.out.println("asd".hashCode());
        System.out.println("qwe".hashCode());

        System.out.println(new SimplifiedStringWithTenBasedHashcode("asd").hashCode());
        System.out.println(new SimplifiedStringWithTenBasedHashcode("qwe").hashCode());
    }
}
