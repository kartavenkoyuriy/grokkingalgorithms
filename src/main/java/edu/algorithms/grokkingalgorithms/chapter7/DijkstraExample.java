package edu.algorithms.grokkingalgorithms.chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DijkstraExample {


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

    //TODO method to summ way

    private Map<String, Map<String, Integer>> graph = new HashMap<>();

    public String findTheShortest(Map<String, Map<String, Integer>> initialGraph) {
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

        currentNodeName = findTheLightestNodeName(costs, processed);
        currentNode = initialGraph.get(currentNodeName);
        while (currentNode != null) {
            for (Entry<String, Integer> stringIntegerEntry : currentNode.entrySet()) {
                if(costs.get(stringIntegerEntry.getKey()) == null){
                    costs.put(stringIntegerEntry.getKey(), costs.get(currentNodeName) + stringIntegerEntry.getValue());
                    parents.put(stringIntegerEntry.getKey(), null);
                }

                int newWayToNeighbourNodeThroughCurrentNode = costs.get(currentNodeName) + stringIntegerEntry.getValue();
                if (costs.get(stringIntegerEntry.getKey()) != null && newWayToNeighbourNodeThroughCurrentNode < costs.get(stringIntegerEntry.getKey())){
                    costs.put(stringIntegerEntry.getKey(), newWayToNeighbourNodeThroughCurrentNode);
                    parents.put(stringIntegerEntry.getKey(), currentNodeName);
                }
            }
            processed.add(currentNodeName);
            currentNodeName = findTheLightestNodeName(costs, processed);
            currentNode = initialGraph.get(currentNodeName);
        }

        return getWayFromParentsTable(parents);
    }

    private String getWayFromParentsTable(Map<String, String> parents) {
        if (parents.get("end") == null){
            //TODO need2sink maybe it's ok(when one node)
            //TODO message
            throw new IllegalArgumentException("");
        }

        StringBuilder parentResultBuilder = new StringBuilder();
        parentResultBuilder.append("end");

        String currentNode = "end";
        while (currentNode != null){
            String nextCurrentNode = parents.get(currentNode);
            if(nextCurrentNode != null){
                parentResultBuilder.append("|").append(nextCurrentNode);
            }
            currentNode = nextCurrentNode;
        }
        return parentResultBuilder.toString();
    }

    String findTheLightestNodeName(Map<String, Integer> costs, List<String> processed) {
        String node = null;
        int nodeWeight = 0;

        for (Map.Entry<String, Integer> stringIntegerEntry : costs.entrySet()) {
            if (node == null
                    && !processed.contains(stringIntegerEntry.getKey())
                    && stringIntegerEntry.getValue() != null) {
                node = stringIntegerEntry.getKey();
                nodeWeight = stringIntegerEntry.getValue();
            } else if (!processed.contains(stringIntegerEntry.getKey())) {
                if (stringIntegerEntry.getValue() != null //what if END?
                        && (stringIntegerEntry.getValue() < nodeWeight)) {
                    node = stringIntegerEntry.getKey();
                    nodeWeight = stringIntegerEntry.getValue();
                }
            } else {
                //continue;
            }
        }

        return node;
    }

    public static void main(String[] args) {
//        System.out.println(new Double(Double.POSITIVE_INFINITY).intValue());

        DijkstraExample dijkstraExample = new DijkstraExample();
        dijkstraExample.populate();
        System.out.println(dijkstraExample.findTheShortest(dijkstraExample.getGraph()));

    }

}
