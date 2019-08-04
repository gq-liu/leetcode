/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { return head; }
        // handle the first two node
        ListNode curr = head;
        ListNode prev;
        head = head.next;
        curr.next = head.next;
        head.next = curr;
        prev = head.next;
        curr = curr.next;
        
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next = prev.next.next;
            prev.next.next = curr;
            
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
