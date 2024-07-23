/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        boolean isCarry = false;
        while(l1!=null&l2!=null){
            if(isCarry==true){
                if(l1.val+l2.val+1>=10){
                    isCarry=true;
                    sb.append((l1.val+l2.val+1)-10);
                }else{
                    sb.append((l1.val+l2.val+1)%10);
                    isCarry = false;
                }
            }else{
                if(l1.val+l2.val>=10){
                    isCarry=true;
                    sb.append((l1.val+l2.val)-10);
                }else{
                    sb.append((l1.val+l2.val)%10);
                    isCarry = false;
                }
            }

            l1=l1.next;
            l2=l2.next;
        }

        if(l1==null){
            while(l2!=null){
                if((l2.val + (isCarry?1:0))>=10){

                    sb.append((l2.val + 1)%10);
                   l2=l2.next;
                }else{
                    sb.append(l2.val+(isCarry?1:0));
                    isCarry=false;
  
                   l2=l2.next;
                }

            }

        }else{
           while(l1!=null){
                if((l1.val + (isCarry?1:0))>=10){

                    sb.append((l1.val + 1) %10);
                   l1=l1.next;
                }else{
                    sb.append(l1.val+(isCarry?1:0));
                    isCarry=false;
                    
                   l1=l1.next;
                }

            }
        }

        if(isCarry==true){
            sb.append('1');
        }

        ListNode head = new ListNode(Integer.valueOf(sb.charAt(0)-'0'));
        ListNode current =  head;
        for (int i = 1; i < sb.length(); i++) {
            ListNode temp = new ListNode(Integer.valueOf(sb.charAt(i)-'0'));
            current.next = temp;
            current = temp;
        }
        return head;
    }
}