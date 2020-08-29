package com.xc.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    //    @Value( "lisi" )
    private String name;
    //    @Value( "29" )
    private Integer age;


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Value("${person.nickName}")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
