package com.ztc.springB.test;

public class TestReturn {
    //多线程和return的测试
    public static void main(String[] args) {
        System.out.println(start());
    }

    public  static int start(){
        Thread device1 = new Thread(new deviceThread("设备1"));
        Thread device2 = new Thread(new deviceThread("设备2"));
        Thread device3 = new Thread(new deviceThread("设备3"));
        device1.start();
        device2.start();
        device3.start();
        return 90;
    }

}
