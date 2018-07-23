package edu.algorithms.grokkingalgorithms.chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraExample {

    private Map<String, Map<String, Integer>> graph = new HashMap<>();

    public Map<String, Map<String, Integer>> getGraph() {
        return graph;
    }

    private void populate() {
        Map<String, Integer> subMapfromStart = new HashMap<>();
        subMapfromStart.put("A", 6);
        subMapfromStart.put("B", 2);
        graph.put("start", subMapfromStart);
        Map<String, Integer> subMapfromA = new HashMap<>();
        subMapfromA.put("end", 1);
        graph.put("A", subMapfromA);
        Map<String, Integer> subMapfromB = new HashMap<>();
        subMapfromB.put("A", 3);
        subMapfromB.put("end", 5);
        graph.put("B", subMapfromB);
        graph.put("end", null);
    }

    public static String findTheShortest(Map<String, Map<String, Integer>> initialGraph) {
        //TODO need2sink whether infinity is a Integer.MAX_VALUE or null
//        int infinity = Integer.MAX_VALUE;

        if (initialGraph == null) {
            throw new IllegalArgumentException("graph should not be null");
        }

        String currentNodeName = "start";
        Map<String, Integer> currentNode = initialGraph.get(currentNodeName);
        if (currentNode == null) {
            throw new IllegalArgumentException("graph should contains start node");
        }

        //TODO: need to think whether it populate now or in runtime
        Map<String, String> parents = new HashMap<>();
        Map<String, Integer> costs = new HashMap<>();
        List<String> processed = new ArrayList<>();

        parents.put(currentNodeName, null);
        for (Map.Entry<String, Integer> stringIntegerEntry : currentNode.entrySet()) {
            costs.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            parents.put(stringIntegerEntry.getKey(), currentNodeName);
        }
        processed.add(currentNodeName);

        while (currentNode != null) {
            currentNodeName = findTheLightestNodeName(costs, processed);

            break;
        }


        return null;
    }

    private static String findTheLightestNodeName(Map<String, Integer> costs, List<String> processed) {
        String node = null;
        int nodeWeight = 0;

        for (Map.Entry<String, Integer> stringIntegerEntry : costs.entrySet()) {
            if (node == null && !processed.contains(stringIntegerEntry.getKey())) {
                node = stringIntegerEntry.getKey();
                nodeWeight = stringIntegerEntry.getValue();
            } else if (!processed.contains(stringIntegerEntry.getKey())){
                if (stringIntegerEntry.getValue() != null //what if END?
                        && (stringIntegerEntry.getValue() < nodeWeight)){
                    node = stringIntegerEntry.getKey();
                    nodeWeight = stringIntegerEntry.getValue();
                }
            } else {
                //continue;
            }
        }

        return node;
    }

}
