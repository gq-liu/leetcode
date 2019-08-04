/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// 边界判断
		if (l1 == null && l2 == null) { return null; }
		if (l1 == null || l2 == null) {
			return l1 == null ? l2:l1;
		}

		ListNode head;
		if (l1.val <= l2.val) {
		//	ListNode head = l1;
			l1 = l1.next;
		} else {
		//	ListNode head = l2;
			l2 = l2.next;
		}
		ListNode curr = head; // NOTE head 如果在if控制分支中申明，这里会出现head没有申明的错误
		while ( l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				curr.next = l1;
				curr = curr.next;
				l1 = l1.next;
			} else {
				curr.next = l2;
				curr = curr.next;
				l2 = l2.next;
			}
		}
		// maybe one of the list still has remaining part
		if (l1 != null) {
			curr.next = l1;
			return head;
		} else if (l2 != null) {
			curr.next = l2;
			return head;
		} else {
			return head;
		}
	}
}

// Using recursion
// recursion disadvantage : bigger space need, overflow
class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// checking input
		if (l1 == null) { return l2; } // if l2 is null too, also works 
		if (l2 == null) { return l1; }
		
		if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l2.next, l1);
			return l2;
		}
	}
}
