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
        ListNode prevGroup = null;
        ListNode groupStart = head;
        ListNode groupEnd = findKth(groupStart, k);

        while(groupEnd != null){
            ListNode curr = groupStart;
            ListNode prev = groupEnd.next;
            for(int i = 0; i < k; i++){
                ListNode next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }

            if(prevGroup == null){
                head = groupEnd;
            }else{
                prevGroup.next = groupEnd;
            }

            prevGroup = groupStart;
            groupStart = curr;
            groupEnd = findKth(groupStart, k);
        }

        return head;
    }

    private ListNode findKth(ListNode node, int k){
        if(node == null){
            return null;
        }

        ListNode result = node;
        for(int i = 0; i < k -1; i++){
            if(result == null){
                return null;
            }
            result = result.next;
        }

        return result;
    }
}
