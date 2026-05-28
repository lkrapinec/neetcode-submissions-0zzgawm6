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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode prevStart = null;
        ListNode currStart = null;

        ListNode result = null;

        int count = 1;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;

            if (count % k == 0) {
                if (result == null) {
                    result = head;
                }
                if (prevStart != null) {
                    prevStart.next = head;
                }
            }

            if (count % k == 1) {
                if (currStart != null) {
                    currStart.next = head;
                    head.next = null;
                }

                prevStart = currStart;
                currStart = head;
            }

            head = temp;
            count++;
        }
        if(count % k != 1){

            head = prev;
            prev = null;
            while(head != null){

                ListNode temp = head.next;
                head.next = prev;
                prev = head;

                head = temp;
            }
        }

        return result;
    }
}


//3->2->1->4<-5
//prev = 5, prev.next = prev, 4->5
//prev = 4, prev.next = null, prev = null

