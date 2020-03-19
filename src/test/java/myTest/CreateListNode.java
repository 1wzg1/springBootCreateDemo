package myTest;

import java.util.Stack;

public class CreateListNode {
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1);	//创建链表对象 l1 （对应有参 和 无参 构造方法）
        l1.add(2);				//插入结点，打印
        l1.add(3);
        l1.add(4);
        l1.print();
        //方法一
        ListNode reverse1 = reverse1(l1);
        System.out.println("");
        reverse1.print();
        //方法二
        ListNode reverse2 = reverse2(l1);
        System.out.println("");
        reverse2.print();
        //方法三
        ListNode reverse3 = reverse3(l1);
        System.out.println("");
        reverse3.print();


    }
    /**
     * 递归实现 当栈深度大于12000 则会出现StakOverflowError
     *
     * @param head
     * @return
     */
    public static ListNode reverse1(ListNode head) {
        if (null == head || null == head.getNext()){
            return head;
        }
        ListNode revHead = reverse1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return revHead;
    }
    /**
     * 遍历实现 通用实现方法
     *
     * @param head
     * @return
     */
    public static ListNode reverse2(ListNode head) {
        if (null == head || null == head.getNext())
            return head;
        ListNode pre = head;
        ListNode cur = head.getNext();
        while (null != cur.getNext()) {
            ListNode tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        cur.setNext(pre);
        head.setNext(null);
        return cur;
    }
    /**
     * 方法3 利用其他数据结构 stack
     * @param head
     * @return
     */
    public static ListNode reverse3(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        for (ListNode node = head; null != node; node = node.getNext()) {
            stack.add(node);
        }
        ListNode reHead = stack.pop();
        ListNode cur = reHead;
        while(!stack.isEmpty()){
            cur.setNext(stack.pop());
            cur = cur.getNext();
            cur.setNext(null);
        }
        return reHead;
    }
}
