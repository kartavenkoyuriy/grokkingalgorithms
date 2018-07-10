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
    Node<K, V>[] nodes = (Node<K, V>[]) new Node[10];

    public V put(K key, V value) {
        final int hash = hash(key);

        @SuppressWarnings({"unchecked", "rawtypes"})
        Node<K, V> createdNode = (Node<K, V>) new Node(hash, key, value, null);

        if (nodes[hash] == null) {
            nodes[hash] = createdNode;
            return null;
        } else {
            Node<K, V> fetchedNode = nodes[hash];
            while (fetchedNode != null) {
                if (fetchedNode.key.equals(key)) {
                    V previousValue = fetchedNode.value;
                    fetchedNode.value = value;
                    return previousValue;
                }

                if (fetchedNode.next == null) {
                    fetchedNode.next = createdNode;
                    return null;
                } else {
                    fetchedNode = fetchedNode.next;
                }

            }
        }
        return null;
    }

    //TODO null checking
    public V get(K key) {
        final int hash = hash(key);
        Node<K, V> fetchedNode = nodes[hash];
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

        StringBuilder arrayToString = new StringBuilder();
        arrayToString.append("{");
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                arrayToString.append("null").append(",");
            } else {
                arrayToString.append("|");
                Node<K, V> node = nodes[i];
                while (node != null) {
                    arrayToString.append(node).append(",");
                    node = node.next;
                }
                arrayToString.append("|");
            }
        }
        arrayToString.append("}");

        return "HashTableImprovedExample{" +
                "nodes=" + arrayToString.toString() +
                '}';
    }

    public static void main(String[] args) {
        HashTableImprovedExample<String, String> map = new HashTableImprovedExample<>();
        System.out.println("asd".hashCode());
        System.out.println("asn".hashCode());
        map.put("asd", "1");
        map.put("asd", "2");
        map.put("asn", "3");
        System.out.println(map);
        System.out.println(map.get("asd"));
        System.out.println(map.get("asn"));

    }

    private static void hashInvestigation() {
        System.out.println("abc".hashCode());//96354
        System.out.println("qwe".hashCode());//112383
        final HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("abc", "qwe");
    }
}
