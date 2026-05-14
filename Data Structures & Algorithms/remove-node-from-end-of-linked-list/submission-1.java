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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        for(int i = 0; i < n; i++){
            right = right.next;
        }

        ListNode prev = null;
        while(right != null){
            prev = left;
            left = left.next;
            right = right.next;
        }

        if(prev == null){
            return head.next;
        }

        //left is element before nth
        ListNode temp = prev.next;
        prev.next = temp.next;
        temp.next = null;

        return head; 
    }
}

//use two pointers
//second is n spaces after first
//when first is null,  second is nth element
//remove that element