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
        ListNode head = null;

        ListNode prev = null;
        ListNode next = null;
        while(l1 != null || l2 != null){
            int sum;
            if(l1 == null){
                sum = l2.val;
            }else if(l2 == null){
                sum = l1.val;
            }else{
                sum = l1.val + l2.val;
            }

            ListNode curr = new ListNode();
            if(next != null){
                sum += next.val;
            }

            if(sum > 9){
                sum -= 10;
                next = new ListNode(1);
                curr.next = next;

            }else{
                next = null;
            }

            curr.val = sum;
            if(prev == null){
                head = curr;
            }else{
                prev.next = curr;
            }

            prev = curr;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return head;
    }
}

//idea: go through list and sum nodes at same positions
//if sum is bigger than 9, carry second digit to a new node