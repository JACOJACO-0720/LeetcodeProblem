class Solution {
    public int appendCharacters(String s, String t) {
        if(s.contains(t)) return 0;
        int curS = 0;
        int curT = 0;
            while(curS<s.length() && curT<t.length()){
                char charT = t.charAt(curT);
                if(s.charAt(curS)==charT ){
                    curS++;
                    curT++;
                }else{
                    curS++;
                }
            }
            return t.length() - curT;
        
    }
}

// class Solution {
//     public int appendCharacters(String s, String t) {
//         int len1 = s.length();
//         int len2 = t.length();
//         int ptr1 = 0, ptr2 = 0;
//         while(ptr1 < len1 && ptr2 < len2) {
//             char charSearched = t.charAt(ptr2);
//             while(ptr1 < len1) {
//                 if(s.charAt(ptr1) == charSearched) {
//                     ptr2++;
//                     ptr1++;
//                     break;
//                 }
//                 else {
//                     ptr1++;
//                 }
//             }
//         }
//         return len2 - ptr2 ;
//     }
// }