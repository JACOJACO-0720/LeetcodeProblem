
import java.nio.file.attribute.PosixFileAttributeView;class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Node> stk = new Stack<>();
        for(int i =0;i<temperatures.length;i++){
            int temp = temperatures[i];
            Node tempNode = new Node(i, temp);
           while(!stk.isEmpty() && tempNode.temperature > stk.peek().temperature){
                Node n = stk.pop();
                res[n.posi] = tempNode.posi-n.posi;
           }
            stk.add(tempNode);
        }
        while(!stk.isEmpty()){
            Node tempNode = stk.pop();
            res[tempNode.posi] = 0; 
        }
        return res;
    }
    class Node{
        int posi;
        int temperature;
        public Node(int posi, int temperature){
            this.posi = posi;
            this.temperature = temperature;
        }
    }
}