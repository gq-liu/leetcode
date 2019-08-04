/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }
        // 把两个不同长度的链表补齐成为同样长度的，在短的链表前面补0，注意不改变 reference l1 l2 保持原来链表不变
		int l1Length = 0;
        int l2Length = 0;
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        while (currL1 != null) {
            l1Length++;
            currL1 = currL1.next;
        }
        while (currL2 != null) {
            l2Length++;
            currL2 = currL2.next;
        }
        currL1 = l1;
        currL2 = l2;
        if (l1Length > l2Length) {

            for (int i = 0; i < l1Length - l2Length; i++) {
                ListNode node = new ListNode(0);
                node.next = currL2;
                currL2 = node;
            }
        } else if (l1Length < l2Length) {
            for (int i = 0; i < l2Length - l1Length; i++) {
                ListNode node = new ListNode(0);
                node.next = currL1;
                currL1 = node;
            }
        }
        // 利用递归函数，算结果
        ListNode head = addTwoNumbersHelper(currL1, currL2);
        // 头部特殊处理
		if (head.val >= 10){
            head.val -= 10;
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }
    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2) {
        if (l1.next == null || l2.next == null) {
            ListNode curr = new ListNode(l1.val + l2.val);
            return curr;
        }
        ListNode nextNode = addTwoNumbersHelper(l1.next, l2.next);
        ListNode currNode = new ListNode(0);
        currNode.next = nextNode;
        int up = 0;
        if (nextNode.val >= 10) {
            nextNode.val -= 10;
            up = 1;
        }
        currNode.val = l1.val + l2.val + up;
        return currNode;
    }
}
