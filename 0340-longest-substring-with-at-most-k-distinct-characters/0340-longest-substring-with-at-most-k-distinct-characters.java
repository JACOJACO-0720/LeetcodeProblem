import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length()==1){
            if(k==0) return 0;
            else return 1;
        }
        int distinct = 0 ;
        int left = 0;
        int right =0 ;
        int res = 0;
        int[] map = new int[1000];
        while(left<s.length() && right<s.length()){
            if(map[s.charAt(right)]==0){
                map[s.charAt(right)]=1;
                distinct++;
            }else{
                map[s.charAt(right)]++;

            }
            if(distinct<=k){

                res= Math.max(res, right-left+1);
                right++;
            }else{
                while(distinct>k){
                    map[s.charAt(left)]--;
                    if(map[s.charAt(left)]==0){
                        distinct--;
                    }
                    left++;
                }
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("a",2));
    }
}