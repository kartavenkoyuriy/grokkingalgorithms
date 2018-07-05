package edu.algorithms.grokkingalgorithms.chapter5.hashtableimroved;

import java.util.HashMap;

class Node<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

    public Node(int hash, K key, V value,
            Node<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
public class HashTableImprovedExample<K,V> {
//    HashMap
//String
    Node<K,V>[] keys;

//    public HashTableImprovedExample() {
//        keys = new Node<K, V>[50];
//    }

    public static void main(String[] args) {
        System.out.println("abc".hashCode());//96354
        System.out.println("qwe".hashCode());//112383
        final HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("abc", "qwe");

    }
}
