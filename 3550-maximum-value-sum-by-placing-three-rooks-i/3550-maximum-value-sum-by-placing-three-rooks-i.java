import java.util.PriorityQueue;

class Solution {
    public long maximumValueSum(int[][] board) {
        long max = Long.MIN_VALUE;
        Node[][] oned = new Node[board.length][3];

        // Step 1: 对于每一行，找到三个最大值的节点
        for (int i = 0; i < board.length; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> (Integer.compare(n1.value, n2.value)));
            for (int j = 0; j < board[0].length; j++) {
                pq.add(new Node(board[i][j], i, j));
                if (pq.size() > 3) {
                    pq.poll();  // 保持pq中只有3个元素
                }
            }
            for (int j = 2; j >= 0; j--) { // 反向取出元素
                oned[i][j] = pq.poll();
            }
        }

        // Step 2: 使用排列来选出三个不同的Node
        for (int i = 0; i < oned.length; i++) {
            for (int j = i + 1; j < oned.length; j++) {
                if (i == j) continue;
                for (int k = j + 1; k < oned.length; k++) {
                    if (k == i || k == j) continue;
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            for (int c = 0; c < 3; c++) {
                                if (oned[i][a].j != oned[j][b].j && oned[i][a].j != oned[k][c].j && oned[j][b].j != oned[k][c].j) {
                                    long tempSum = (long)oned[i][a].value + (long)oned[j][b].value + (long)oned[k][c].value;
                                    max = Math.max(max, tempSum);
                                }
                            }
                        }
                    }
                }
            }
        }

        return max;
    }

    class Node {
        int value;
        int i;
        int j;

        public Node(int value, int i, int j) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}
