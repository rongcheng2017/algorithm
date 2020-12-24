package rongcheng.linkList;

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class _86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        //记录小于x的链表head
        ListNode preNode = new ListNode(0);
        //记录小于x链表的尾部
        ListNode currentPreNode = preNode;
        //记录大于等于x的链表的head
        ListNode endNode = new ListNode(0);
        //记录大于等于x的链表的尾部
        ListNode currentEndNode = endNode;

        while (head != null) {
            if (head.val < x) {
                currentPreNode.next = head;
                currentPreNode = head;
            } else {
                currentEndNode.next = head;
                currentEndNode = head;
            }
            head = head.next;
        }
        //最后个结点必须置空，不然可能形成环形链表
        currentEndNode.next = null;
        //串接两个链表
        currentPreNode.next = endNode.next;
        return preNode.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
