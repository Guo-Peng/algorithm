package CodingInterviews.chapter2;

import java.util.Stack;

/**
 * 逆序打印链表
 * 使用栈 或者 递归
 */

public class LinkedListPrint {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
//        l.printList();
        l.inversePrint();
        l.inversePrintRecursive();
    }
}

class LinkedList {
    private Node first = null;

    private class Node {
        private Object obj;
        private Node next = null;

        Node(Object obj) {
            this.obj = obj;
        }
    }

    public void insert(Object obj) {
        Node newNode = new Node(obj);
        if (first == null)
            first = newNode;
        else {
            Node node = first;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }

    public void printList() {
        if (first == null)
            return;
        else {
            Node node = first;
            while (node != null) {
                System.out.println(node.obj);
                node = node.next;
            }
        }
    }

    public void inversePrint() {
        Stack result = new Stack();
        Node node = first;
        while (node != null) {
            result.push(node.obj);
            node = node.next;
        }


        while (!result.empty()) {
            System.out.println(result.pop());
        }
    }

    public void inversePrintRecursive() {
        inverse(first);
    }

    private void inverse(Node node) {
        if (node != null) {
            inverse(node.next);
            System.out.println(node.obj);
        }
    }
}
