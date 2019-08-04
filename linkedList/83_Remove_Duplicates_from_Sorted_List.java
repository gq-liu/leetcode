/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * 
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
		if (head == null) { return null; }
		ListNode curr = head;
		while (curr.next != null) { // 这里用curr.next != null : 循环中有 curr.next.next, 保证其不发生空指针错误·
			if (curr.next.val == curr.val) {
				curr.next = curr.next.next; //当发生删除的动作时，curr指针不能后移
			} else { 
				curr = curr.next;
			}
			//curr = curr.next;
		}
		return head;
    }
}
