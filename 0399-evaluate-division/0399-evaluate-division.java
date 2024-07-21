import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, List<Node>> hm  = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> tempal = equations.get(i);
            double value = values[i];
            String num = tempal.get(0);
            String denum = tempal.get(1);
            List<Node> list = hm.getOrDefault(num, new ArrayList<>());
            list.add(new Node(denum,value));
            ////////////////////////
            List<Node> list2 = hm.getOrDefault(denum, new ArrayList<>());
            list2.add(new Node(num,1/value));
            hm.put(num, list);
            hm.put(denum, list2);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> temp = queries.get(i);
            HashSet<String> hs = new HashSet<>();
            double doubleresult = dfs(hm,temp.get(0),temp.get(1),hs, 1);
            result[i] = doubleresult;
            
        }
        return result;

    }
    double dfs (Map<String, List<Node>> hm, String start,String end, HashSet<String> hs, double result){
        hs.add(start);
        List<Node> listNode = null;
        if(hm.containsKey(start)){
            listNode = hm.get(start);
        }else{
            return -1;
        }
        
        
        for (int i = 0; i < listNode.size() ; i++) {
            Node tempNode = listNode.get(i);
            if(tempNode.str.equals(end)) {
                result *= tempNode.value;
                return result;
            }else{
                if(!hs.contains(tempNode.str) && hm.containsKey(tempNode.str)){
                    double value =  dfs(hm, tempNode.str,end, hs, result*tempNode.value);
                    if(value != -1){
                        return value;
                    }
                }
            }
        }
        return -1;
    }
    class Node {
        String str;
        double value;
        public Node(String str, double value){
            this.str =str;
            this.value = value;
        }
    }
}