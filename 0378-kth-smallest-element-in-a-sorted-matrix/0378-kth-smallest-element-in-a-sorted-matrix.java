class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<Node>  pq = new PriorityQueue<>((Node n1, Node n2)->(Integer.compare(n1.val, n2.val)));
        int size = 0;
        int res = matrix[0][0];
        pq.add(new Node(0,0,matrix[0][0]));
        while(size<k){
            Node temp = pq.poll();
            int tempx = temp.x;
            int tempy = temp.y;
            int tempval = temp.val;
            res = tempval;
            if(tempx+1<matrix.length&&!visited[tempx+1][tempy]){
                pq.add(new Node(tempx+1,tempy,matrix[tempx+1][tempy]));
                visited[tempx+1][tempy] = true;
            }

            if(tempy+1<matrix[0].length&&!visited[tempx][tempy+1]){
                pq.add(new Node(tempx,tempy+1,matrix[tempx][tempy+1]));
                visited[tempx][tempy+1] = true;
            }
            size++;
        }
        return res;

    }
    
    class Node{
        int x;
        int y;
        int val;
        public Node(int x,int y,int val){
            this.x =x;
            this.y=y;
            this.val = val;
        }
    }
}