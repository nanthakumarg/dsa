package com.thebytecloud.linkedlist;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    LinkedList<Integer> list1 = null;
    LinkedList<Integer> list2 = null;

    @org.junit.Before
    public void setUp() throws Exception {
        list1 = new LinkedList<Integer>();
        list1.addNode(10);
        list1.addNode(20);
        list1.addNode(30);
        list1.addNode(40);

    }

    public void printNode(Node<Integer> node) {

        Node<Integer> currentNode = node;
        while (node != null) {
            System.out.println("Node "+node.getData());
            node = node.getNext();
        }

    }

    @Test
    public void printNodesTest() {
        assertEquals(4, list1.countNodes());
        list1.printNodes();
    }

    @Test
    public void popElementTest() {
        Integer expected = 10;
        assertEquals(expected, list1.popElement());
    }

    @Test
    public void insertNthElementTest() {
        Integer elementToBeInserted = 25;
        list1.insertNth(2, elementToBeInserted);
        list1.printNodes();
        assertEquals(Integer.valueOf(10), list1.popElement());
        assertEquals(Integer.valueOf(20), list1.popElement());
        assertEquals(Integer.valueOf(25), list1.popElement());
        assertEquals(Integer.valueOf(30), list1.popElement());
    }

    @Test
    public void insertSortedTest() {
        Integer elementToBeInserted = 25;
        list1.insertSorted(elementToBeInserted);
        list1.printNodes();
        assertEquals(Integer.valueOf(10), list1.popElement());
        assertEquals(Integer.valueOf(20), list1.popElement());
        assertEquals(Integer.valueOf(25), list1.popElement());
        assertEquals(Integer.valueOf(30), list1.popElement());
    }

    @Test
    public void appendListTest() {
        LinkedList<Integer> newList = new LinkedList<Integer>();
        newList.addNode(100);
        newList.addNode(200);
        list1.appendList(newList);
        list1.printNodes();
        assertEquals(Integer.valueOf(10), list1.popElement());
        assertEquals(Integer.valueOf(20), list1.popElement());
        assertEquals(Integer.valueOf(30), list1.popElement());
        assertEquals(Integer.valueOf(40), list1.popElement());
        assertEquals(Integer.valueOf(100), list1.popElement());
        assertEquals(Integer.valueOf(200), list1.popElement());

    }

    /*@Test
    public void frontBackSplitTest() {

        list1.addNode(50);

        final List<LinkedList<Integer>> linkedLists = list1.frontBackSplit();
        for(LinkedList<Integer> ll : linkedLists) {
            ll.printNodes();
        }

        assertEquals(3, linkedLists.get(0).countNodes());
        assertEquals(2, linkedLists.get(1).countNodes());

    }*/

    @Test
    public void frontBackSplitTest() {

        list1.addNode(50);

        final List<Node<Integer>> linkedLists = list1.frontBackSplit();

        for (Node<Integer> node : linkedLists) {
            printNode(node);
            System.out.println("=======");
        }

        assertEquals(Integer.valueOf(10), linkedLists.get(0).getData());
        assertEquals(Integer.valueOf(40), linkedLists.get(1).getData());

    }

    @Test
    public void removeDuplicatesTest() {

    }

}