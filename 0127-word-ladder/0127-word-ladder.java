import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> hm = new HashMap<>();
        wordList.add(beginWord);
        for(String word : wordList){
            hm.put(word, new ArrayList<String>());
        }
        for(String word: wordList){
            StringBuilder sb = new StringBuilder(word);
            for(int i = 0;i<word.length(); i++){
                char origin = sb.charAt(i);
                for(int j = 0;j<26;j++){
                    sb.setCharAt(i, (char)('a'+j));
                    if(!word.equals(sb.toString())){
                        if(hm.containsKey(sb.toString())){
                            hm.get(word).add(sb.toString());
                        }
                    }

                }
                sb.setCharAt(i,origin);
            }
        }
        if(!hm.containsKey(endWord)){
            return 0;
        }
        int res = 1;
        List<String> tmplst = hm.get(beginWord);
        HashSet<String> hs = new HashSet<>();
        ArrayDeque<String> ad = new ArrayDeque<>();
        for(String t: tmplst){
            ad.add(t);
            hs.add(t);
        }
        while(!ad.isEmpty()){
            res++;
            int size= ad.size();
            for(int i =0;i< size; i++){
                String tmpstr = ad.poll();
                if(tmpstr.equals(endWord)){
                    return res;
                }else{
                    List<String> lst =  hm.get(tmpstr);
                    for(int j =0;j<lst.size();j++){
                        if(!hs.contains(lst.get(j))){
                            ad.add(lst.get(j));
                            hs.add(lst.get(j));
                        }
                    }


                }

            }
        }
        return 0;
    }
}