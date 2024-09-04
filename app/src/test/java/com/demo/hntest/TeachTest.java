package com.demo.hntest;

import com.demo.hntest.base.People;
import com.demo.hntest.base.Student;
import com.demo.hntest.base.Teacher;

public class TeachTest {
    public static void main(String[] args) {
        People student = new Student("张三", 18);
        People teacher = new Teacher("李四", 28);
        student.eat();
        teacher.eat();

    }
}
