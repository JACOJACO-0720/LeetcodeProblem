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
        boolean carry = false;
        ListNode l1head = l1;
        ListNode l2head = l2;

        while(l1!=null && l2!=null){

            int tempsum = l1.val+l2.val;
            if(carry){
                tempsum ++;
                carry = false;
            }

            if(tempsum>=10){
                carry = true;
                tempsum = tempsum%10;
            }
            l1.val = tempsum;
            l2.val = tempsum;

            if(l1.next ==null && l2.next ==null && carry==true){
                ListNode ln = new ListNode(1);
                l1.next = ln;
                return l1head;
            }
            l1 = l1.next;
            l2 = l2.next;

            
        }

        if(l1!=null){
            while(l1!=null){
                if(carry==true){
                    l1.val++;
                    if(l1.val==10){
                        l1.val = 0;
                        if(l1.next==null){
                            ListNode ln = new ListNode(1);
                            l1.next = ln;
                            return l1head;
                        }else{
                            l1 = l1.next;
                        }
                        
                    }else{
                        return l1head;
                    }
                }else{
                    break;
                }
            }

        }


        else if(l2!=null){
            while(l2!=null){
                if(carry==true){
                    l2.val++;
                    if(l2.val==10){
                        l2.val = 0;
                        if(l2.next==null){
                            ListNode ln = new ListNode(1);
                            l2.next = ln;
                            return l2head;
                        }else{
                            l2 = l2.next;
                        }
                    }else{
                        return l2head;
                    }
                }else{
                    return l2head;
                }
            }
        }


        return l1head;



    }
}