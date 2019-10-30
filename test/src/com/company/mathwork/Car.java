package com.company.mathwork;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-30 14:33
 */
public class Car extends Vehicle {
    @Override
    public void print() {
        System.out.println("print");
    }

    public void run() {
        System.out.println("run");
    }

    public static void main(String[] args) {
        Vehicle v = new Car();
        ((Car) v).run();
        v.print();
        ((Car) v).print();
    }
}
