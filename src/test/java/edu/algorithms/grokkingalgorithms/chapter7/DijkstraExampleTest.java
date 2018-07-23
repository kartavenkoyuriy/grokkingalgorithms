package edu.algorithms.grokkingalgorithms.chapter7;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

//Redo on mockito
public class DijkstraExampleTest {

    private DijkstraExample dijkstraExample = new DijkstraExample();
    private Map<String, Map<String, Integer>> graph = new HashMap<>();


    @Before
    public void clearResources(){
        graph.clear();
    }

    @Test
    public void shouldReturn2TwoNodes(){
        //arrange
        Map<String, Integer> startSubMap = new HashMap<>();
        startSubMap.put("end", 2);
        graph.put("start", startSubMap);

        //act
        String theShortest = DijkstraExample.findTheShortest(graph);

        //assert
        assertEquals("the way should be 'end|start'", "end|start", theShortest);
    }

}