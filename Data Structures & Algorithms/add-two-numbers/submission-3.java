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
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            
            int sum = val1 + val2 + carry;
            if(sum > 9){
                sum -= 10;
                carry = 1;
            }else{
                carry = 0;
            }

            curr.next = new ListNode(sum);
            curr =curr.next;
            
            l1 = l1 == null ? null :l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carry == 1){
            curr.next = new ListNode(1);
        }

        return dummy.next;
    }
}