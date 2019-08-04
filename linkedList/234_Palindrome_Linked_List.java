/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// space O(1) time O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) { return true; }

		ListNode fastPointer = head;
		ListNode slowPointer = head;
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		// 处理前半段
		ListNode headHalfFront = head;
		while (head.next != slowPointer) {
			head = head.next;
		}
		head.next = null;
		// 后半段
		if (fastPointer != null ) { slowPointer = slowPointer.next; }
		ListNode headHalpAfter = reverseList(slowPointer);

		// compare
		while (headHalfFront != null) {
			if (headHalfFront.val != headHalfAfter.val) {
				return false;
			}
			headHalfFront = headHalfFront.next;
			headHalfAfter = headHalfAfter.next;
		}
		return true;
    }
	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (head != null) {
			head = head.next;
			curr.next = prev;
			prev = curr;
			curr = head;
		}
		return prev;
	}
}
