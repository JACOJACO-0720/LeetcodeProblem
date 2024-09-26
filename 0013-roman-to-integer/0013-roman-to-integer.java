class Solution {
    public int romanToInt(String s) {
        int finalResult = 0;
        HashMap<Character, Integer> hm =new HashMap<>();
        hm.put('I', 1 );
        hm.put('V', 5 );
        hm.put('X', 10 );
        hm.put('L', 50 );
        hm.put('C', 100 );
        hm.put('D', 500 );
        hm.put('M', 1000 );
        for (int i = 0; i < s.length(); i++) {
            int sum = 0;
            char current = s.charAt(i);
            int currentInt = hm.get(current);
            sum += currentInt;
            int forward = i+1;
            while(forward<s.length()){
                if(s.charAt(forward)==current){
                    sum += currentInt;
                    forward++;
                    i = forward-1;
                }else{
                    if(hm.get(s.charAt(forward))>currentInt){
                        sum = -sum;
                    }
                    i = forward-1;
                    break;
                }
            }
            finalResult+=sum;
        }
        return finalResult;
    }

}