import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //2,3,5
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            int temp = target;
                temp = temp-candidates[i];
                if(temp<0){
                    break;
                }
                else if(temp==0){
                    List<Integer> tmpRes = new ArrayList<>();
                    tmpRes.add(candidates[i]);
                    List<Integer> newres = new ArrayList<>();
                    for (int j = 0; j < tmpRes.size(); j++) {
                        newres.add(tmpRes.get(j));
                    }
                    res.add(newres);
                    tmpRes.remove(tmpRes.size()-1);
                }else{
                    List<Integer> tmpRes = new ArrayList<>();
                    tmpRes.add(candidates[i]);
                    helperFunction(i, candidates, res, tmpRes, temp);
                }

        }

        return res;
    }

    void helperFunction(int start, int[] candidates, List<List<Integer>> res, List<Integer> tmpRes, int target){
        for (int i = start; i < candidates.length; i++) {
            int temp = target;
                temp = temp-candidates[i];
                if(temp<0){
                    break;
                }
                else if(temp==0){
                    tmpRes.add(candidates[i]);
                    List<Integer> newres = new ArrayList<>();
                    for (int j = 0; j < tmpRes.size(); j++) {
                        newres.add(tmpRes.get(j));
                    }
                    res.add(newres);
                    tmpRes.remove(tmpRes.size()-1);
                }else{

                    tmpRes.add(candidates[i]);
                    helperFunction(i, candidates, res, tmpRes, temp);
                    tmpRes.remove(tmpRes.size()-1);
                }


        }
        
    }

}