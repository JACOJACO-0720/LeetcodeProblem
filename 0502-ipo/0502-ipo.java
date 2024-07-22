import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min-heap for projects based on required capital
        PriorityQueue<Node> minCapitalPQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n1.capital, n2.capital);
            }
        });

        // Max-heap for projects based on profit
        PriorityQueue<Node> maxProfitPQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n2.profit, n1.profit);
            }
        });

        // Add all projects to the min-heap based on capital requirements
        for (int i = 0; i < profits.length; i++) {
            minCapitalPQ.add(new Node(profits[i], capital[i]));
        }

        int currentCapital = w;

        // Select up to k projects
        for (int i = 0; i < k; i++) {
            // Move all projects that can be started with current capital to the max-heap
            while (!minCapitalPQ.isEmpty() && minCapitalPQ.peek().capital <= currentCapital) {
                maxProfitPQ.add(minCapitalPQ.poll());
            }

            // If there are no available projects, break
            if (maxProfitPQ.isEmpty()) {
                break;
            }

            // Select the project with the highest profit
            currentCapital += maxProfitPQ.poll().profit;
        }

        return currentCapital;
    }

    // Static nested Node class
    static class Node {
        int profit;
        int capital;

        public Node(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] capital = {0, 1, 1};
        int[] profit = {1, 2, 3};
        System.out.println(solution.findMaximizedCapital(2, 0, profit, capital)); // Output should be the maximum capital after selecting up to k projects
    }
}
