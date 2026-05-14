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
        if(head == null || head.next == null){
            return;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        ListNode temp = slowPointer.next;
        slowPointer.next = null;
        slowPointer = temp;
        
        ListNode previous = null;
        while(slowPointer != null){
            ListNode nextSlowPointer = slowPointer.next;
            slowPointer.next = previous;
            previous = slowPointer;
            slowPointer = nextSlowPointer;
        }

        slowPointer = previous;
        while(slowPointer != null){
            ListNode nextHead = head.next;
            ListNode nextSlowPointer = slowPointer.next;

            head.next = slowPointer;
            slowPointer.next = nextHead;

            head = nextHead;
            slowPointer = nextSlowPointer;
        }
    }
}








