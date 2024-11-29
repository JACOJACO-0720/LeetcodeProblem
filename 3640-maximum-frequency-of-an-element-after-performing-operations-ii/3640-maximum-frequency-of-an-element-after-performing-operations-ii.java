import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = 0;
        TreeMap<Integer, Node> treeMap = new TreeMap();
        for (int i = 0; i < nums.length; i++) {

            Node tmpNode = treeMap.getOrDefault(nums[i], new Node());
            tmpNode.val = nums[i];
            tmpNode.corenum++;
            treeMap.put(nums[i], tmpNode);

            Node upNode = treeMap.getOrDefault(nums[i]+k , new Node());
            upNode.val = nums[i];
            upNode.upnum++;
            treeMap.put(nums[i]+k, upNode);

            Node downNode = treeMap.getOrDefault(nums[i] - k , new Node());
            downNode.val = nums[i];
            downNode.downnum++;
            treeMap.put(nums[i] - k, downNode);
        }

       int cur = 0;
        int res = 0;
        int numOperationsused = 0;
        for (Map.Entry<Integer, Node> entry : treeMap.descendingMap().entrySet()) {
            Node value = entry.getValue();
            numOperationsused += value.upnum;
            numOperationsused -= value.corenum;
            cur += value.upnum;
            res =Math.max(res,cur + Math.min(numOperations - numOperationsused, 0));
            cur -= value.downnum;
            numOperationsused+=value.corenum;
            numOperationsused-=value.downnum;
        }

        return res;
    }


    class Node {
        int val;
        int corenum;
        int upnum;
        int downnum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxFrequency(new int[]{1,12,82},53,1 ));
    }
}