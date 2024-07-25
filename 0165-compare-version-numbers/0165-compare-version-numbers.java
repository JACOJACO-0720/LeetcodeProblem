class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int left = 0;
        while(left<str1.length && left<str2.length){
            String st1 = str1[left];
            String st2 = str2[left];
            int num1 = Integer.valueOf(st1);
            int num2 = Integer.valueOf(st2);
            if(num1>num2){
                return 1;
            }else if(num1<num2){
                return -1;
            }
            left++;
        }
        if(left<str1.length){
            while(left<str1.length){
            String st1 = str1[left];
            int num1 = Integer.valueOf(st1);
            if(num1!=0){
                return 1;
            }
            left++;
            }
        }
        else if(left<str2.length){
            while(left<str2.length){
            String st2 = str2[left];
            int num2 = Integer.valueOf(st2);
            if(num2!=0){
                return -1;
            }
            left++;
            }
        }
        return 0;
    }
}