import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Node> stk  =new Stack<>();
        int res  = 0;
        for(int i =0;i<heights.length ;i++){
            if(stk.isEmpty()){
                stk.push(new Node(heights[i], i ));
            }else{
                if(heights[i] == stk.peek().height){
                    continue;
                }else if(heights[i]>stk.peek().height){
                    stk.push(new Node(heights[i], i));
                }else{
                    Node temp = null;
                    while(!stk.isEmpty()&&heights[i]<stk.peek().height){
                        temp = stk.pop();
                        res =Math.max(res, (i-temp.index)*temp.height);
                    }
                    if(stk.isEmpty()){
                        stk.add(new Node(heights[i],0));
                    }
                    if(heights[i] == stk.peek().height){
                        continue;
                    }else{
                        stk.add(new Node(heights[i], temp.index));
                    }
                }
            }
        }
        while(!stk.isEmpty()){
            Node temp = stk.pop();
            res = Math.max(res,(heights.length -temp.index)*temp.height );
        }
        return res;



    }
    class Node{
        int height;
        int index;
        public Node(int height, int index){
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(input));
    }
}