package Graph.ReconstructItinerary;

import java.util.*;

public class Solution {
    public static List<String> findItinerary(String[][] tickets) {
        ArrayList<String> arrayList = new ArrayList<>();

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            if (map.containsKey(tickets[i][0])) {
                map.get(tickets[i][0]).add(tickets[i][1]);
            } else {
                PriorityQueue<String> temp = new PriorityQueue<>();
                temp.add(tickets[i][1]);
                map.put(tickets[i][0], temp);
            }
        }
        String start = "JFK";
        arrayList.add(start);
        while (map.containsKey(start) && !map.get(start).isEmpty()) {
            start = map.get(start).poll();
            arrayList.add(start);
        }
        System.out.println(arrayList);
        return arrayList;
    }

    public static void main(String[] args) {
        String[][] array = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        findItinerary(array);
    }
}
