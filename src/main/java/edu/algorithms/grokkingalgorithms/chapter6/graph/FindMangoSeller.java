package edu.algorithms.grokkingalgorithms.chapter6.graph;

import com.sun.istack.internal.NotNull;
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
        populateGraphOfFriends2(g);

        System.out.println(getMangoSeller(g, "me"));
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

    private static void populateGraphOfFriends1(FindMangoSeller g) {
        g.friendsGraph.put("me", new String[]{"Bob"});
        g.friendsGraph.put("Bob", new String[]{"me"});
    }

    private static void populateGraphOfFriends2(FindMangoSeller g) {
        g.friendsGraph.put("me", new String[]{"Bob"});
        g.friendsGraph.put("Bob", new String[]{"Tom"});
        g.friendsGraph.put("Tom", new String[]{"Joe"});
    }

    @Nullable
    private static String getMangoSeller(FindMangoSeller g, @NotNull String yourName) {
        g.queue.add(yourName);
        while (g.queue.peek() != null){
            String currentPerson = g.queue.poll();
            if (g.alreadyCheckedFriends.get(currentPerson) != null){
                continue;
            }

            if (isMangoSeller(currentPerson)){
                return currentPerson;
            } else {
                g.alreadyCheckedFriends.put(currentPerson, currentPerson);
                addFriendsArrayToCheckingQueue(g, g.friendsGraph.get(currentPerson));
            }
        }

        return null;
    }

    private static void addFriendsArrayToCheckingQueue(FindMangoSeller g, String[] firstName) {
        for (int i = 0; i < firstName.length; i++) {
            g.queue.add(firstName[i]);
        }
    }

}
