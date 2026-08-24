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
              ListNode beforeFirst = null;
        ListNode first = head;
        ListNode curr = first;

        ListNode last = curr;
        for (int i = 0; i < k - 1; i++) {
            if (last == null) {
                break;
            }
            last = last.next;
        }

        while (last != null) {
            ListNode prev = last.next;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }

            if (beforeFirst == null) {
                head = last;
            } else {
                beforeFirst.next = last;
            }

            beforeFirst = first;
            first = curr;
            last = curr;

            for (int i = 0; i < k - 1; i++) {
                if (last == null) {
                    break;
                }
                last = last.next;
            }
        }
        return head;
    }
}

