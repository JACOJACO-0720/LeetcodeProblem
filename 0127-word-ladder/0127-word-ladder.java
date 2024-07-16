class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        List<String> lst = new LinkedList<>(wordList);
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.add(beginWord);
        int count = 1;
        while(!wordList.isEmpty()){
            count++;
            int size = ad.size();
            for (int i = 0; i < size; i++) {
                Iterator<String> it = lst.iterator();
                String before = ad.pollFirst();
                while(it.hasNext()){
                    String  after = it.next();
                    if(helpFunction(before,after)){
                        ad.addLast(after);
                        it.remove();
                        if(after.equals(endWord)){
                            return count;
                        }
                    }

                }

            }
            if(ad.isEmpty()){
                return 0;
            }
        }
        return 0;

    }
    boolean helpFunction( String before, String after){
        int length = before.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(before.charAt(i)!=after.charAt(i)){
                count++;
                if(count>1){
                    return false;
                }
            }

        }
        return count==1;
    }

}