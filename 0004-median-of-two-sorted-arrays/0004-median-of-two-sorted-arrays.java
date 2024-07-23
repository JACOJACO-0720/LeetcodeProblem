class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length+nums2.length;
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int num1Cnt = -1;
        int num2Cnt = -1;
        int totalCount = 0;
        int curNum = 0;
        int preNum = 0;
        if(totalLength%2==0){
            while(num1Cnt+1 < num1Length && num2Cnt+1<num2Length && totalCount < totalLength/2 + 1 ){
                if(nums1[num1Cnt+1]< nums2[num2Cnt+1]){

                    preNum = curNum;
                    curNum = nums1[num1Cnt+1];
                    num1Cnt++;
                    totalCount ++;

                }else{
                    preNum = curNum;
                    curNum = nums2[num2Cnt+1];
                    num2Cnt++;
                    totalCount ++;

                }
            }

            if(totalCount < totalLength/2 + 1){
                if(num2Cnt+1 == num2Length){
                    for (int i = 0; i <  totalLength/2 + 1 - totalCount ; i++) {
                         preNum = curNum;
                         curNum = nums1[num1Cnt+i+1];
                    }
                    return  (preNum+curNum)/2.0;
                }else{

                    for (int i = 0; i <  totalLength/2 + 1 - totalCount ; i++) {
                         preNum = curNum;
                         curNum = nums2[num2Cnt+i+1];
                    }
                    return  (preNum+curNum)/2.0;

                }

            }else{
                return (preNum+curNum)/2.0;
            }




        }else{

        while(num1Cnt+1 < num1Length && num2Cnt+1<num2Length && totalCount < totalLength/2 + 1 ){
                if(nums1[num1Cnt+1]< nums2[num2Cnt+1]){
                    curNum = nums1[num1Cnt+1];
                    num1Cnt++;
                    totalCount ++;

                }else{
                    curNum = nums2[num2Cnt+1];
                    num2Cnt++;
                    totalCount ++;
                    
                }
            }

            if(totalCount < totalLength/2 + 1){
                if(num2Cnt+1 == num2Length){
                    for (int i = 0; i <  totalLength/2 + 1 - totalCount ; i++) {
                         curNum = nums1[num1Cnt+i+1];
                    }
                    return  curNum;
                }else{

                    for (int i = 0; i <  totalLength/2 + 1 - totalCount ; i++) {
                         curNum = nums2[num2Cnt+i+1];
                    }
                    return  curNum;

                }

            }else{
                return curNum;
            }



        }

        
    }
}