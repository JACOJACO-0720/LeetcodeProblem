class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(int i =0;i< strings.length;i++){
            String str = strings[i];
            StringBuilder sb = new StringBuilder();
            sb.append(0);
            char base = str.charAt(0);
            for(int j =1;j< str.length();j++){
                char tmpstr = str.charAt(j);
                int tmp = (int)(base - tmpstr);
                if(tmp<0){
                    tmp+=26;
                } 
                if(tmp>=26){
                    tmp-=26;
                }
                sb.append(tmp);
            }
            hm.putIfAbsent(sb.toString(), new ArrayList<>());
            hm.get(sb.toString()).add(str);


        }
        return new ArrayList<>(hm.values());

    }
}