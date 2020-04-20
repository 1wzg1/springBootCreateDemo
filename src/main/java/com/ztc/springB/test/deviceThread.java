package com.ztc.springB.test;

public class deviceThread implements Runnable{
    private String name;

    protected deviceThread(String name){
        this.name=name;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(this.name+"   "+i);
                Thread.sleep(100);
            }
        }catch (Exception e){

        }
    }
}
