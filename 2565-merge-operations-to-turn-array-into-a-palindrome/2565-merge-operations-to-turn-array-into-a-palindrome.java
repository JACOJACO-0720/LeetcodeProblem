class Solution {
    public int minimumOperations(int[] nums) {
        ArrayDeque<Integer> ad =new ArrayDeque<>();
        for(int num: nums){
            ad.addLast(num);
        }

        int result = 0;
        while(ad.size()>=2){
            if(ad.peekFirst().equals(ad.peekLast())){
                ad.pollFirst();
                ad.pollLast();
            }else if(ad.peekFirst() >= ad.peekLast()){
                int temp = ad.pollLast();
                int temp1 = ad.pollLast();
                int temp2 =  temp + temp1;
                ad.addLast(temp2);
                result++;
            }else{
                int temp = ad.pollFirst();
                int temp1 = ad.pollFirst();
                int temp2 =  temp + temp1;
                ad.addFirst(temp2);
                result++;
            }

        }
        return result;
    }
}