package com.cw.test;

import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chenwei01 on 2018/3/23.
 */
public class Person  implements Comparable<Person>{


    private int age;

    private int sex;

    private int height;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Person(int age, int sex, int height) {
        this.age = age;
        this.sex = sex;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                '}';
    }

    public static void main(String[] args) {

        Person person1=new Person(23,1,178);
        Person person2=new Person(23,1,198);
        Person person3=new Person(21,0,167);
        Person person4=new Person(33,1,188);
        Person person5=new Person(793,0,168);

        List list=new ArrayList();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);


        Collections.sort(list);
        System.out.println(list);
    }


    public int compare(Person o1, Person o2) {

        if (o1.getAge() - o2.getAge()>0) {
            return 3;
        }else if (o1.getAge() - o2.getAge() < 0) {
            return -3;
        } else {
            if (o1.getSex() > o2.getSex()) {
                return 2;
            } else if (o1.getSex() < o2.getSex()) {
                return -2;
            } else {
                if (o1.getHeight() > o2.getHeight()) {
                    return 1;
                } else if (o1.getHeight() < o2.getHeight()) {
                    return -1;
                }
            }
        }


        return 0;
    }

    @Override
    public int compareTo(Person o) {

        if (this.getAge() - o.getAge()>0) {
            return 3;
        }else if (this.getAge() - o.getAge() < 0) {
            return -3;
        } else {
            if (this.getSex() > o.getSex()) {
                return 2;
            } else if (this.getSex() < o.getSex()) {
                return -2;
            } else {
                if (this.getHeight() > o.getHeight()) {
                    return 1;
                } else if (this.getHeight() < o.getHeight()) {
                    return -1;
                }
            }
        }



        return 0;
    }
}
