package edu.algorithms.grokkingalgorithms.chapter6.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphWayExample {
    //TODO is there a way
    //TODO shortest way
    //TODO how many steps

    HashMap<String, String[]> graph = new HashMap<>();

    HashMap<String, Integer> nodeStepsMap = new HashMap<>();

    public static void main(String[] args) {
        GraphWayExample g = new GraphWayExample();

        populateGraph(g);
        System.out.println(g.isThereAWay("me", "Anuj"));
        g.clearCollections();

        populateGraph(g);
        System.out.println(g.theShortestWayImproved("me", "Anuj"));
        g.clearCollections();

//        populateGraph(g);
//        System.out.println(g.theShortestWay("me","Tom"));
//        g.clearCollections();
//
//        populateGraph(g);
//        System.out.println(g.theShortestWay("me","Claude"));
//        g.clearCollections();
    }

    private void clearCollections() {
        graph.clear();
    }

    //TODO null checks
    boolean isThereAWay(String start, String end) {
        Queue<String> queue = new LinkedBlockingQueue<>();
        HashMap<String, String> alreadyCheckedNodes = new HashMap<>();

        queue.add(start);
        while (queue.peek() != null) {
            String currentNode = queue.poll();
            if (alreadyCheckedNodes.get(currentNode) != null) {
                continue;
            }

            if (currentNode.equals(end)) {
                return true;
            } else {
                String[] neighbourNodes = graph.get(currentNode);
                queue.addAll(Arrays.asList(neighbourNodes));
                alreadyCheckedNodes.put(currentNode, currentNode);
            }
        }

        return false;
    }


    String theShortestWayImproved(String start, String end) {
        if (!isThereAWay(start, end)){
            return null;
        }

        Queue<String> queue = new LinkedBlockingQueue<>();
        HashMap<String, String> alreadyCheckedNodes = new HashMap<>();
        Map<String, String> childParentMap = new HashMap<>();

        queue.add(start);
        childParentMap.put(start, null);
        while (queue.peek() != null) {
            String currentNode = queue.poll();
            if (alreadyCheckedNodes.get(currentNode) != null) {
                continue;
            }

            if (currentNode.equals(end)) {
                StringBuilder resultSb = new StringBuilder();
                resultSb.append(end);
                String parentName = childParentMap.get(end);
                while (parentName != null){
                    resultSb
                            .append("|")
                            .append(parentName);
                    parentName = childParentMap.get(parentName);
                }
                return resultSb.toString();
            } else {
                String[] neighbourNodes = graph.get(currentNode);
                for (int i = 0; i < neighbourNodes.length; i++) {
                    queue.add(neighbourNodes[i]);
                    childParentMap.put(neighbourNodes[i], currentNode);
                    alreadyCheckedNodes.put(currentNode, currentNode);
                }
            }
        }

        return null;
    }


        private static void populateGraph(GraphWayExample g) {
        g.graph.put("me", new String[]{"Bob", "Alice", "Claire"});
        g.graph.put("Bob", new String[]{"Anuj", "Peggy", "Claire"});
        g.graph.put("Alice", new String[]{"Peggy"});
        g.graph.put("Claire", new String[]{"Tom", "Johny"});
        g.graph.put("Anuj", new String[]{});
        g.graph.put("Peggy", new String[]{});
        g.graph.put("Tom", new String[]{"Claude"});
        g.graph.put("Johny", new String[]{});
        g.graph.put("Claude", new String[]{});


    }

    void fillNumberTable(GraphWayExample g, String startName){
        int count = 0;

        g.nodeStepsMap.put(startName, 0);
        while(true){
            count++;
            String[] neighbourNodes = g.graph.get(startName);
            putNodesWithNumber(nodeStepsMap, neighbourNodes, count);

            break;
        }
    }

    private void putNodesWithNumber (
            HashMap<String, Integer> nodeStepsMap, String[] neighbourNodes, int number) {
        for (int i = 0; i < neighbourNodes.length; i++) {
            nodeStepsMap.put(neighbourNodes[i],number);
        }
    }


    private static void populateGraph1(GraphWayExample g) {
        g.graph.put("me", new String[]{"Bob"});
        g.graph.put("Bob", new String[]{"me"});
    }

    private static void populateGraph2(GraphWayExample g) {
        g.graph.put("me", new String[]{"Bob"});
        g.graph.put("Bob", new String[]{"Tom"});
        g.graph.put("Tom", new String[]{"Joe"});
    }
}
