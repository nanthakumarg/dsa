package com.thebytecloud.stack;

/**
 * Stack can be created using Array and Linked Lists.
 *
 */
public interface Stack<E> {

    public boolean push(E element);
    public E pop();
    public E peek();
    public int size();
    public boolean isEmpty();
    public boolean isFull();
}
