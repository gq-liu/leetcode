/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Attempt 1 : using two pointer, prev retain the first node of reversed list,
// 				the second pointer retain the current node needing proceed.
// 				Time O(n) space O(1)
class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		
		while (head != null) {
			head = head.next; // let head move to next node
			curr.next = prev; // curr point to prev
			prev = curr; // update prev point 
			curr = head; // update curr point
		}
		return prev;
	}
}
// Attempt 2 : Using recursion
// 			* curr.next.next = curr; curr.next = null;
class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null) { return null; }
		return reverseListHelper(head)i;
	}
	private ListNode reverseListHelper(ListNode head) {
		if (head.next == null) {
			return head;
		}
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p; // p always the first node of the reversed list 
	}
}
