package edu.algorithms.grokkingalgorithms.chapter6.graph;

import com.sun.istack.internal.Nullable;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class FindMangoSeller {

    HashMap<String, String[]> friendsGraph = new HashMap<>();
    HashMap<String, String> alreadyCheckedFriends = new HashMap<>();

    Queue<String> queue = new LinkedBlockingQueue<>();


    static boolean isMangoSeller(@Nullable String name) {
        if (name == null){
            return false;
        }
        return name.startsWith("J");
    }

    public static void main(String[] args) {
        FindMangoSeller g = new FindMangoSeller();
        //graph of friends
        populateGraphOfFriends(g);

        String[] first = g.friendsGraph.get("me");

    }

    private static void populateGraphOfFriends(FindMangoSeller g) {
        g.friendsGraph.put("me", new String[]{"Bob", "Alice", "Claire"});
        g.friendsGraph.put("Bob", new String[]{"Anuj", "Peggy"});
        g.friendsGraph.put("Alice", new String[]{"Peggy"});
        g.friendsGraph.put("Claire", new String[]{"Tom", "Johny"});
        g.friendsGraph.put("Anuj", new String[]{});
        g.friendsGraph.put("Peggy", new String[]{});
        g.friendsGraph.put("Tom", new String[]{});
        g.friendsGraph.put("Johny", new String[]{});
    }

    @Nullable
    private static String getMangoSeller(FindMangoSeller g, String yourName) {
        if (isMangoSeller(yourName)){
            return yourName;
        }

        String[] firstName = g.friendsGraph.get(yourName);
        if (firstName == null) {
            return null;
        }

        addFriendsArrayToCheckingQueue(g, firstName);


        return null;
    }

    private static void addFriendsArrayToCheckingQueue(FindMangoSeller g, String[] firstName) {
        for (int i = 0; i < firstName.length; i++) {
            g.queue.add(firstName[i]);
        }
    }

}
