import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int cur = nums[0];
        int curnum = 1;
        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1,Node n2)->(Integer.compare(n1.num, n2.num)));
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=cur){
                pq.add(new Node(cur,curnum));
                if(pq.size()>k){
                    pq.poll();
                }
                curnum =1;
                cur =nums[i];
            }else{
                curnum++;
            }
        }
        int[] res = new int[k];
        pq.add(new Node(cur,curnum));
        if(pq.size()>k){
            pq.poll();
        }
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            res[i] = pq.poll().val;
        }
        return res;
    }
    class Node{
        int val; int num;
        public Node(int val, int num){this.val = val;this.num = num;}
    }

    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3};
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(input,2));
    }
}