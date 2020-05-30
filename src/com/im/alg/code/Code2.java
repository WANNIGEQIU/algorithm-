package com.im.alg.code;

import javax.swing.*;
import java.util.LinkedList;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code2 {
    /**
     * 首先要有个结果的链表还要记录进位和当前计算的位置处理好各种情况 如 [1,8] 和 [0]
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode current; int carry = 0;
        ListNode ret = new ListNode(0);
        current = ret;
        while (l1 != null || l2 != null) {
            int sum =  (l1 == null? 0:l1.val)  + (l2 == null? 0: l2.val) + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = current.next;
           if (l1 != null) l1 = l1.next;
           if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) current.next = new ListNode(carry);
            return ret.next;
    }

    private static  class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }


}
