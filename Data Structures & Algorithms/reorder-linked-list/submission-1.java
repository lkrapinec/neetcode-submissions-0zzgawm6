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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast == null){
                ListNode tmp = slow.next;
                slow.next = null;

                slow = tmp;
            }else{
                slow = slow.next;
            }
            
        }

        ListNode prev = null;
        while(slow != null){
            ListNode tmp = slow.next;
            slow.next = prev;

            prev = slow;
            slow = tmp;
        }


        ListNode start = head;
        ListNode end = prev;

        while(start != null){
            ListNode tmpStart = start.next;
            ListNode tmpEnd = end.next;

            start.next = end;
            end.next = tmpStart;

            start = tmpStart;
            end = tmpEnd;
        }
    }
}
//use slow and fast pointers to determine the middle of the list
//from middle to end reverse pointers

//2->4->6<-8