package CodingInterviews.chapter2;


/**
 * Created by guopeng on 16/8/22.
 */
public class ConstructTree {

}

class Tree {
    private Node root = null;

    private class Node {
        Object data;

        Node father = null;
        Node left = null;
        Node right = null;

        Node(Object data) {
            this.data = data;
        }
    }

    public void treePrint(String order) {
        switch (order) {
            case "pre":
                printPre(root);
            case "in":
                printIn(root);
            case "last":
                printLast(root);
        }
    }

    private void printPre(Node node) {
        if (node != null) {
            System.out.println(node.data);
            printPre(node.left);
            printPre(node.right);
        }
    }

    private void printIn(Node node) {
        if (node != null) {
            printIn(node.left);
            System.out.println(node.data);
            printIn(node.right);
        }
    }

    private void printLast(Node node) {
        if (node != null) {
            printLast(node.left);
            printLast(node.right);
            System.out.println(node.data);
        }
    }

//    public void construct(int[] preorder, int[] inorder) {
//        if (preorder.length == 0)
//            return;
//        root = new Node(preorder[0]);
//        root.left =
//    }
//
//    private Node constructCore(int[] preorder, int[] inorder) {
//
//    }

}