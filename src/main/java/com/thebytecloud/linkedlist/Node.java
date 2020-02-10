package com.thebytecloud.linkedlist;

public class Node<E extends Comparable<E>> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getData(){
            return data;
        }

        public Node<E> getNext(){
            return next;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }