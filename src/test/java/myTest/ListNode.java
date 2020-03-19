package myTest;

public class ListNode {
    int val;	//数值 data
    ListNode next;	// 结点 node

    ListNode(int x){	//可以定义一个有参构造方法，也可以定义一个无参构造方法
        val = x;
    }
    // 添加新的结点
    public void add(int newval) {
        ListNode newNode = new ListNode(newval);
        if(this.next == null)
            this.next = newNode;
        else
            this.next.add(newval);
    }
    // 打印链表
    public void print() {
        System.out.print(this.val);
        if(this.next != null)
        {
            System.out.print("-->");
            this.next.print();
        }
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
