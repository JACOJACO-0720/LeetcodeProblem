
import com.sun.jdi.StackFrame;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int i =0 ;i<asteroids.length;i++ ){
                int temp = asteroids[i];
                if(temp>0){
                    stk.add(temp);
                }else{
                    if(stk.isEmpty()){
                        stk.add(temp);
                    }else{
                        while(!stk.isEmpty() && stk.peek()>0){
                            int t = stk.pop();
                            if(t==Math.abs(temp)){
                                temp = 0;
                                break;
                            }else if(t>Math.abs(temp)){
                                stk.add(t);
                                temp= 0;
                                break;
                            }
                        }
                            if(temp!=0){
                                stk.add(temp);
                            }
                    }
                }

        }
        int[]  res = new int[stk.size()];
        int size = stk.size();
        for (int i = 0; i < size; i++) {
            res[res.length-1-i]=stk.pop();
        }
        return res;
    }
}