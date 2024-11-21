import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        // Collect all unique characters
        HashSet<Character> hs = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                hs.add(c);
            }
        }

        // Step 1: Build the graph
        HashMap<Character, HashSet<Character>> hm = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            String left = words[i - 1];
            String right = words[i];
            int digit = 0;
            boolean normal = false;
            while (digit < left.length() && digit < right.length()) {
                if (left.charAt(digit) == right.charAt(digit)) {
                    digit++;
                } else {
                    // Add dependency to the graph
                    HashSet<Character> tempSet = hm.getOrDefault(left.charAt(digit), new HashSet<>());
                    tempSet.add(right.charAt(digit));
                    hm.put(left.charAt(digit), tempSet);
                    normal = true;
                    break;
                }
            }
            // If the second word is a prefix of the first word, it's invalid
            if (!normal && right.length() < left.length()) {
                return "";
            }
        }

        // Step 2: Topological sort using DFS
        boolean[] visited = new boolean[26];
        boolean[] visiting = new boolean[26]; // To detect cycles
        List<Character> path = new ArrayList<>();

        for (Character c : hs) {
            if (!visited[c - 'a']) {
                if (!dfs(c, visited, visiting, path, hm)) {
                    return ""; // Cycle detected
                }
            }
        }

        // Reverse the path to get the correct order
        Collections.reverse(path);
        StringBuilder result = new StringBuilder();
        for (char c : path) {
            result.append(c);
        }

        return result.toString();
    }

    private boolean dfs(Character c, boolean[] visited, boolean[] visiting, List<Character> path, HashMap<Character, HashSet<Character>> hm) {
        if (visiting[c - 'a']) {
            return false; // Cycle detected
        }
        if (visited[c - 'a']) {
            return true; // Already processed
        }

        visiting[c - 'a'] = true; // Mark as visiting
        if (hm.containsKey(c)) {
            for (Character neighbor : hm.get(c)) {
                if (!dfs(neighbor, visited, visiting, path, hm)) {
                    return false; // Cycle detected in a neighbor
                }
            }
        }
        visiting[c - 'a'] = false; // Backtrack
        visited[c - 'a'] = true; // Mark as visited
        path.add(c); // Add to the result path

        return true;
    }
}
