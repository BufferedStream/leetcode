package ninetyNineProblems;

/**
 * @auther zengbo on 2020/3/30
 * 2. 两数相加
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class addTwoNumbers {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    //[2,4,3]
    //[5,6,4]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1.val + getVal(l2) > 9) {
            l1.val = (l1.val + getVal(l2)) % 10;

            if(l1.next == null) {
                l1.next = new ListNode(1);
                if(l2.next == null) {
                    return l1;
                }
            } else if(l2.next == null){
                l2.next = new ListNode(1);
            } else {
                l1.next.val += 1;
            }
            addTwoNumbers(l1.next, l2.next);

        } else {
            l1.val = (l1.val + getVal(l2)) % 10;

            if(l2.next == null) {
                return l1;
            } else {
                if(l1.next == null) {
                    l1.next = new ListNode(0);
                    addTwoNumbers(l1.next, l2.next);
                } else {
                    addTwoNumbers(l1.next, l2.next);
                }
            }

        }

        return l1;
    }

    public int getVal(ListNode l) {
        return l == null ? 0 : l.val;
    }
}
