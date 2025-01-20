class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, List<Integer>> hm = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char tempchar = s.charAt(i);
            if(hm.containsKey(tempchar)){
                hm.get(tempchar).set(1, i);
            }else{
                List<Integer> tmplst = new ArrayList<>();
                tmplst.add(i);
                tmplst.add(i);
                hm.put(tempchar,tmplst);
            }
        }
        HashSet<Character> hs  = new HashSet<>();
        int tmp = 0;
        int far = 0;
        int prev = -1;
        while(tmp < s.length()){
            while(tmp < s.length() && tmp<=far){
                if(!hs.contains(s.charAt(tmp))){
                     far = Math.max(far, hm.get(s.charAt(tmp)).get(1));
                }
                tmp++;
            }
            hs  = new HashSet<>();
            res.add(tmp-prev-1);
            prev = tmp-1;
            far = tmp;
        }

        return res;
    }
}