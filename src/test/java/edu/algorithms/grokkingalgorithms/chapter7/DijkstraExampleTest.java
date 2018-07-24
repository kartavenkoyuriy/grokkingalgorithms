package edu.algorithms.grokkingalgorithms.chapter7;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

//TODO Redo with mockito
public class DijkstraExampleTest {

    private DijkstraExample dijkstraExample = new DijkstraExample();
    private Map<String, Map<String, Integer>> graph = new HashMap<>();


    @Before
    public void clearResources(){
        graph.clear();
    }

    @Ignore
    @Test
    public void shouldReturn2TwoNodes(){
        //arrange
        Map<String, Integer> startSubMap = new HashMap<>();
        startSubMap.put("end", 2);
        graph.put("start", startSubMap);

        //act
        String theShortest = dijkstraExample.findTheShortest(graph);

        //assert
        assertEquals("the way should be 'end|start'", "end|start", theShortest);
    }


    //TODO test with one node
    @Test
    public void shouldReturnBWhenProcessedListIsEmpty(){
        //arrange
        Map<String, Integer> costs = initializeThreeNodesCosts();
        List<String> processed = new ArrayList<>();

        //act
        String theLightestNodeName = dijkstraExample.findTheLightestNodeName(costs, processed);

        //assert
        assertEquals("the shortest from {A=6,B=2,end=null} should be 'B'", "B", theLightestNodeName);
    }

    @Test
    public void shouldReturnAWhenBIsInProcessedList(){
        //arrange
        Map<String, Integer> costs = initializeThreeNodesCosts();
        List<String> processed = new ArrayList<>();
        processed.add("B");

        //act
        String theLightestNodeName = dijkstraExample.findTheLightestNodeName(costs, processed);

        //assert
        assertEquals("the shortest from {A=6,B=2,end=null} and if 'B' in 'processed' - should be 'A'", "A", theLightestNodeName);
    }

    @Test
    public void shouldReturnNullWhenAAndBIsInProcessedList(){
        //arrange
        Map<String, Integer> costs = initializeThreeNodesCosts();
        List<String> processed = new ArrayList<>();
        processed.add("A");
        processed.add("B");

        //act
        String theLightestNodeName = dijkstraExample.findTheLightestNodeName(costs, processed);

        //assert
        assertNull(theLightestNodeName);
    }

    private Map<String, Integer> initializeThreeNodesCosts() {
        Map<String,Integer> costs = new HashMap<>();
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put("end", null);
        return costs;
    }

}