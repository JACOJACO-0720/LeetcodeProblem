import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minStack = new PriorityQueue<>();
    PriorityQueue<Integer> maxStack = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(minStack.isEmpty()&&maxStack.isEmpty()){
            minStack.add(num);
        }else if(minStack.isEmpty()){
            int maxInt = maxStack.peek();
            if(maxInt<=num){
                minStack.add(num);
            }else{
                int temp = maxStack.poll();
                minStack.add(temp);
                maxStack.add(num);
            }

        }else if(maxStack.isEmpty()){
            int minInt = minStack.peek();
            if(minInt>=num){
                maxStack.add(num);
            }else{
                int temp = minStack.poll();
                maxStack.add(temp);
                minStack.add(num);
            }
        }else{
            if(maxStack.size() == minStack.size() ){
                int minInt = minStack.peek();
                if(minInt>=num){
                    maxStack.add(num);
                }else{
                    minStack.add(num);
                }
            }else if(maxStack.size() > minStack.size()){
                int maxInt = maxStack.peek();
                if(maxInt<=num){
                    minStack.add(num);
                }else{
                    int temp = maxStack.poll();
                    minStack.add(temp);
                    maxStack.add(num);
                }

            }else{
                int minInt = minStack.peek();
                if(minInt>=num){
                    maxStack.add(num);
                }else{
                    int temp = minStack.poll();
                    maxStack.add(temp);
                    minStack.add(num);
                }

            }
        }
    }

    public double findMedian() {
        if(minStack.size()==0&&maxStack.size()==0){
            return 0;
        }
        if(minStack.size()==maxStack.size()){
            return (minStack.peek()+maxStack.peek())/2.0;
        }else if(minStack.size()>maxStack.size()){
            return minStack.peek();
        }else{
            return maxStack.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */