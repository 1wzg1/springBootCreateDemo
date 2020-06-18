package com.ztc.springB.bean;

public class Person {
    private String name;
    private Integer age;

    /**
     * 第几次出现
     */
    private Long time;

    /**
     * 共几次
     */
    private Long total;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", time=" + time +
                ", total=" + total +
                '}';
    }
}
