package com.thebytecloud.stack;

import java.lang.reflect.Array;

public class ArrayBasedStack<E> implements Stack<E> {

    private E a[];
    private int top;
    private int capacity;

    public ArrayBasedStack(Class<E> clazz, int capacity) {
        a = (E[]) Array.newInstance(clazz, capacity);
        this.capacity = capacity;
        top = -1;
    }

    public boolean push(E element) {
        if(isFull()) {
            System.out.println("Stack overflow");
            return false;
        }
        a[++top] = element;
        return true;
    }

    public E pop() {
        if(isEmpty()){
            System.out.println("Stack underflow");
            return null;
        }
        return a[top--];
    }

    public E peek() {
        return a[top];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public boolean isFull() {
        return top == capacity-1;
    }
}
