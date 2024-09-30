class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        Stack<Node> stk  =new Stack<>();
        for(int i =0;i<nums.length ;i++){
            if(stk.isEmpty()){
                stk.push(new Node(nums[i], i ));
            }else{
                if(nums[i] == stk.peek().height){
                    continue;
                }else if(nums[i]>stk.peek().height){
                    stk.push(new Node(nums[i], i));
                }else{
                    Node temp = null;
                    while(!stk.isEmpty()&&nums[i]<stk.peek().height){
                        temp = stk.pop();
                        int area = (i-temp.index)*(temp.height-1);
                        if(area >= threshold){
                            return i-temp.index;
                        }
                    }
                    if(stk.isEmpty()){
                        stk.add(new Node(nums[i],0));
                    }
                    if(nums[i] == stk.peek().height){
                        continue;
                    }else{
                        stk.add(new Node(nums[i], temp.index));
                    }
                }
            }
        }
        while(!stk.isEmpty()){
            Node temp = stk.pop();
            int area = (nums.length -temp.index)*(temp.height);
            if(area > threshold){
                            return nums.length-temp.index;
            }
        }
        return -1;



    }
    class Node{
        int height;
        int index;
        public Node(int height, int index){
            this.height = height;
            this.index = index;
        }
    }
}