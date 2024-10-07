class Solution {
    public boolean closeStrings(String s1, String s2) {

        int arr1[] = new int[26];
        int arr2[] = new int[26];

        for(var a : s1.toCharArray()){
            arr1[a-'a']++;
        }

        for(var a : s2.toCharArray()){
            arr2[a-'a']++;
        } 

        for(int i=0; i<26; i++){
            if((arr1[i]==0 && arr2[i]!=0) || (arr1[i]!=0 && arr2[i]==0)) return false;
            int x = arr1[i];
            int y = arr2[i];
            for(int j=i+1; j<26; j++){
                if(arr1[j]==y){
                    arr1[i] = y;
                    arr1[j] = x;
                    break;
                }
            }
        }

        for(int i=0; i<26; i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
        
    }
}