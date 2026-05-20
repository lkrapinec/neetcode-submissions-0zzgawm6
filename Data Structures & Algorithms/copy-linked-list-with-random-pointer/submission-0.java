/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node newHead = new Node(head.val);

        if(head.next == null){
            if(head.random != null){
                newHead.random = newHead;
            }
            return newHead;
        }
        
        Node current = head.next;
        Node previous = newHead;
        while (current != null){
            Node temp = new Node(current.val);
            previous.next = temp;
            previous = temp;

            current = current.next;
        }

        current = head;
        Node newNode = newHead;
        while (current != null){
            if(current.random == null){
                current = current.next;
                newNode = newNode.next;
                continue;
            }

            Node temp = current.random;
            Node startHead = head;
            Node startNewHead = newHead;
            while(startHead != temp){
                startNewHead = startNewHead.next;
                startHead = startHead.next;
            }
            newNode.random = startNewHead;

            newNode = newNode.next;
            current = current.next;
        }
        return newHead;
    }
}
//go through list twice, once to create a copy with next pointers, and other time to assign random pointer
//memorize position of each node so you can know how to assign random pointer

//array for random positions [null,Node(5),Node(1), Node(7)]
//start from the head and calculate distance 
