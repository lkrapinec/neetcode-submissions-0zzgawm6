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
        if(lists.length == 0){
            return null;
        }
        while (lists.length > 1) {
            ListNode[] mergedLists = new ListNode[(lists.length + 1) / 2 ];
            for (int i = 0; i < lists.length; i += 2) {
                ListNode list1 = lists[i];
                ListNode list2 = i + 1 < lists.length ? lists[i + 1] : null;

                mergedLists[i / 2] = mergeTwoList(list1, list2);
            }

            lists = mergedLists;
        }

        return lists[0];
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2){
        if(list2 == null){
            return list1;
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if(list1 == null){
            curr.next = list2;
        }else{
            curr.next = list1;
        }
        
        return dummy.next;
    }
}
