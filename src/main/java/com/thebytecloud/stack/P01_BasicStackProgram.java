package com.thebytecloud.stack;

public class P01_BasicStackProgram {

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayBasedStack<Integer>(Integer.class, 5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Printing stack elements..");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
