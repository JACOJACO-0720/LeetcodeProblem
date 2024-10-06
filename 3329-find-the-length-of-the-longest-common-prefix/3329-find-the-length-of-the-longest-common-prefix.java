class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        String[] str1 = new String[arr1.length];
        String[] str2 = new String[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            str1[i] = String.valueOf(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            str2[i] = String.valueOf(arr2[i]);
        }
        
        Node root = new Node();
        for (int i = 0; i < str2.length; i++) {
            buildtree(root, str2[i]);
        }
        
        int res = 0;
        for (int i = 0; i < str1.length; i++) {
            String temp = str1[i];
            int tmpres = search(root, temp);
            res =Math.max(tmpres,res);

        }
        return res;

    }
    int search(Node root, String temp){
        int res = 0 ;
        for (int i = 0; i < temp.length(); i++) {
            char t = temp.charAt(i);
            if(root.nodelist[t-'0']==null){
                return res;
            }else{
                res++;
                root = root.nodelist[t-'0'];
            }
        }
        return res;

    }
    void buildtree(Node root, String str){
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if(root.nodelist[temp-'0']==null){
                root.nodelist[temp-'0'] = new Node();
                root = root.nodelist[temp-'0'];
            }else{
                 root = root.nodelist[temp-'0'];
            }
        }
    }


    class Node{
        Node[] nodelist = new Node[10];
    }
}
