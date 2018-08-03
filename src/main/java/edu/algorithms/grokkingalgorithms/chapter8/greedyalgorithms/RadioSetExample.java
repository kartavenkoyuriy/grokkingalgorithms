package edu.algorithms.grokkingalgorithms.chapter8.greedyalgorithms;

import java.util.*;
import java.util.stream.Collectors;

public class RadioSetExample {
    private Set<String> states = new HashSet<>();
    private Map<String, Set<String>> statesToStationsMap = new HashMap<>();


    private void populate(){
        states.addAll(Arrays.stream(new String[]{"mt", "wa", "or", "id", "nv", "ut", "ca", "az"}).collect(Collectors.toSet()));

        statesToStationsMap.put("kone", Arrays.stream(new String[]{"id", "nv", "ut"}).collect(Collectors.toSet()));
        statesToStationsMap.put("ktwo", Arrays.stream(new String[]{"wa", "id", "mt"}).collect(Collectors.toSet()));
        statesToStationsMap.put("kthree", Arrays.stream(new String[]{"or", "nv", "ca"}).collect(Collectors.toSet()));
        statesToStationsMap.put("kfour", Arrays.stream(new String[]{"nv", "ut"}).collect(Collectors.toSet()));
        statesToStationsMap.put("kfive", Arrays.stream(new String[]{"ca", "az"}).collect(Collectors.toSet()));
    }


}
