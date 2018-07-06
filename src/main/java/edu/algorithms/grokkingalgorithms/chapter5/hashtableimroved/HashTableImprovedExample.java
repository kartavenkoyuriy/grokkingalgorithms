package edu.algorithms.grokkingalgorithms.chapter5.hashtableimroved;

import java.util.Arrays;
import java.util.HashMap;

class Node<K, V> {

    final int hash;
    final K key;
    V value;
    Node<K, V> next;

    //TODO implement getters/setters
    public Node(int hash, K key, V value,
            Node<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return key + "." + value;
    }
}

public class HashTableImprovedExample<K, V> {

//TODO implement load factor
//TODO improve hash function


    @SuppressWarnings("unchecked")
    Node<K, V>[] keys = (Node<K, V>[]) new Node[10];

    public V put(K key, V value) {
        final int hash = hash(key);

        if (keys[hash] == null) {
            @SuppressWarnings({"unchecked", "rawtypes"})
            Node<K, V> createdNode = (Node<K, V>) new Node(hash, key, value, null);
            keys[hash] = createdNode;
            return null;
        } else {
            Node<K, V> fetchedNode = keys[hash];
            while (fetchedNode != null) {
                if (fetchedNode.key.equals(key)) {
                    V previousValue = fetchedNode.value;
                    fetchedNode.value = value;
                    return previousValue;
                } else {
                    fetchedNode = fetchedNode.next;
                }
            }
            @SuppressWarnings({"unchecked", "rawtypes"})
            Node<K, V> createdNode = (Node<K, V>) new Node(hash, key, value, null);
            keys[hash] = createdNode;
            return null;
        }
    }

    //TODO null checking
    public V get(K key) {
        final int hash = hash(key);
        Node<K, V> fetchedNode = keys[hash];
        if (fetchedNode.value == null) {
            return null;
        } else {
            while (fetchedNode != null) {
                if (fetchedNode.key.equals(key)) {
                    return fetchedNode.value;
                }
                fetchedNode = fetchedNode.next;
            }
        }
        return null;
    }

    private int hash(K key) {
        return key.hashCode() % 10;
    }

    @Override
    public String toString() {
        return "HashTableImprovedExample{" +
                "keys=" + Arrays.toString(keys) +
                '}';
    }

    public static void main(String[] args) {
        HashTableImprovedExample<String, String> map = new HashTableImprovedExample<>();
        map.put("asd", "1");
        map.put("asd", "2");
        System.out.println(map);

    }

    private static void hashInvestigation() {
        System.out.println("abc".hashCode());//96354
        System.out.println("qwe".hashCode());//112383
        final HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("abc", "qwe");
    }
}
