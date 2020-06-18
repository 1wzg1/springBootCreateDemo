package myTest;

import java.util.List;
import java.util.Stack;

public class CreateListNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);    //创建链表对象 l1 （对应有参 和 无参 构造方法）
        l1.add(2);                //插入结点，打印
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
        if (null == head || null == head.getNext()) {
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
     *5
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
        while (!stack.isEmpty()) {
            cur.setNext(stack.pop());
            cur = cur.getNext();
            cur.setNext(null);
        }
        return reHead;
    }

    /*public String test() {
        List<String> range = stringRedisTemplate.boundListOps(phone + "-" + date).range(0, -1);

        long nowTime = System.currentTimeMillis();
        //首次计时
        if (CollectionUtils.isEmpty(range)) {
            stringRedisTemplate.opsForValue().set(phone + "-" + date + "-" + "time", String.valueOf(nowTime));
        }
        //满10次记录最近一个时间
        if (CollectionUtils.isNotEmpty(range) && range.size() == 10) {
            stringRedisTemplate.opsForValue().set(phone + "-" + date + "-" + "endtime", String.valueOf(nowTime));
        }
        String firstTime = stringRedisTemplate.opsForValue().get(phone + "-" + date + "-" + "time");
        System.out.println("firstTime:--------------" + firstTime);
        if (CollectionUtils.isNotEmpty(range) && range.size() >= 3) {
            //判断15分钟内是否获取超过10次验证码
            if (StringUtils.isNotEmpty(firstTime)) {
                System.out.println("剩余时间+" + (2 * 1000 * 60 - (nowTime - Long.parseLong(firstTime))) + "+++++" + "请求次数：" + range.size());
            }
            if (range.size() > 10 && StringUtils.isNotEmpty(firstTime) && (2 * 1000 * 60) - (nowTime - Long.parseLong(firstTime)) >= 0) {
                return "15分钟发送超过10次！";
            }*//*else{
              //发送图片验证码
              log.info("==========当天发送验证码次数为：{}！==========", range.size());
              return String.valueOf(range.size());
            }*//*
            String endTime = stringRedisTemplate.opsForValue().get(phone + "-" + date + "-" + "endtime");
            //最后一次发送短信过15分钟删除信息
            if (StringUtils.isNotEmpty(endTime) && (nowTime - Long.parseLong(endTime)) >= 2 * 1000 * 60) {
                System.out.println("++++++++++++++++++++" + "删除缓存！");
                stringRedisTemplate.opsForValue().set(phone + "-" + date + "-" + "time", String.valueOf(nowTime));
                stringRedisTemplate.delete(phone + "-" + date + "-" + "endtime");
                //次数不清0
                stringRedisTemplate.delete(phone + "-" + date);
            }
        }
    }
    public String test2(){
        //保存验证码+当前时间
        //获取次数
        int count=10;
        //最后一次时间
        int endTime=0;
        //现在时间
        int nowTime=0;
        if(count+1>10 && (countTime-((count-9)Time))<=15分钟){
            //把当前次数的时间给最后的时间
            endTime = countTime;
            if ((nowTime - endTime) < 15 分钟){
                return "15分钟后发送！";
            }
        }
        发送的
    }*/
}
