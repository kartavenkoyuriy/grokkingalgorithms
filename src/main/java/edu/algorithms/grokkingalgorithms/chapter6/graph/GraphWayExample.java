package edu.algorithms.grokkingalgorithms.chapter6.graph;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphWayExample {
    //TODO is there a way
    //TODO shortest way

    HashMap<String, String[]> graph = new HashMap<>();
    HashMap<String, String> alreadyCheckedNodes = new HashMap<>();
    Queue<String> queue = new LinkedBlockingQueue<>();
    HashMap<String, Integer> nodeStepsMap = new HashMap<>();


    public static void main(String[] args) {
        GraphWayExample g = new GraphWayExample();

//        populateGraph(g);
//        System.out.println(g.isThereAWay("me", "Anuj"));
//        g.clearCollections();

        populateGraph(g);
        System.out.println(g.theShortestWay("me","Tom"));
        g.clearCollections();

        populateGraph(g);
        System.out.println(g.theShortestWay("me","Claude"));
        g.clearCollections();
    }

    private void clearCollections() {
        graph.clear();
        alreadyCheckedNodes.clear();
        queue.clear();
    }

    boolean isThereAWay(String start, String end) {
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
                addArrayToCheckingQueue(queue, neighbourNodes);
                alreadyCheckedNodes.put(currentNode, currentNode);
            }
        }

        return false;
    }

    Integer theShortestWay(String start, String end) {
//        int countSteps = 0;

        queue.add(start);
//        nodeStepsMap.put(start, countSteps);
        nodeStepsMap.put(start, 0);
        while(queue.peek() != null){
            String currentNode = queue.poll();
            if(currentNode.equals(end)){
                return nodeStepsMap.get(currentNode);
            } else {

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

    private static void addArrayToCheckingQueue(Queue<String> queue, String[] firstName) {
        for (int i = 0; i < firstName.length; i++) {
            queue.add(firstName[i]);
        }
    }

}
