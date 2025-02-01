import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 使用 Map 记录每个机场的出发目的地，并用 PriorityQueue 维护字典序最小的目的地
        Map<String, PriorityQueue<String>> flightMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            flightMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flightMap.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", flightMap, route);
        return route;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> flightMap, LinkedList<String> route) {
        // 继续访问当前机场的所有目的地，按字典序
        while (flightMap.containsKey(airport) && !flightMap.get(airport).isEmpty()) {
            String nextAirport = flightMap.get(airport).poll(); // 取出字典序最小的目的地
            dfs(nextAirport, flightMap, route);
        }
        // 逆序插入行程（因为是 post-order DFS）
        route.addFirst(airport);
    }
}
