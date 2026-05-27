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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (true) {
            int min = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (min == -1) {
                    min = i;
                    continue;
                }

                if (lists[min].val > lists[i].val) {
                    min = i;
                }
            }
            if (min == -1) {
                break;
            }

            current.next = lists[min];

            ListNode temp = lists[min];
            lists[min] = lists[min].next;
            temp.next = null;

            current = current.next;
        }
        return dummy.next;
    }
}
