package rongcheng.linkList;

/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class _203_RemoveLinkedListElements {


    public ListNode removeElement(ListNode head, int val) {
        if (head == null) return null;
        //记录新链表的头
        ListNode newHead = null;
        //记录当前扫描到的Node位置
        ListNode currentNode = null;
        while (head != null) {
            if (val != head.val) {
                if (currentNode == null) {
                    currentNode = head;
                    newHead = head;
                } else {
                    //链表上添加新Node
                    currentNode.next = head;
                    //记录新Node的位置
                    currentNode = head;
                }
            }

            head = head.next;
        }

        //注意空指针
        if (currentNode == null) {
            return null;
        } else {
            //结束链表，currentNode就是链表的尾部
            currentNode.next = null;
        }
        return newHead;

    }


    public ListNode removeElements2(ListNode head, int val) {

        if (head == null) return null;
        //虚拟节点
        ListNode vNode = new ListNode(0);

        ListNode currentNodex = vNode;


        while (head != null) {

            if (val != head.val) {
                currentNodex.next = head;
                currentNodex = head;
            }
            head = head.next;
        }
        currentNodex.next = null;
        //虚拟节点的next就是新链表的head
        return vNode.next;


    }


    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while (head != null) {
            if (head.val != val) {
                newTail.next = head;
                newTail = head;
            }
            head = head.next;
        }
        newTail.next = null;
        return newHead.next;

    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

