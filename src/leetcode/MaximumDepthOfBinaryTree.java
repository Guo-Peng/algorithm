package leetcode;


import java.util.*;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    TreeNode root;

    public void init(int[] tree) {
        Queue<TreeNode> q = new LinkedList<>();
        root = new TreeNode(tree[0]);
        q.offer(root);
        int i = 0;
        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            if (i < tree.length - 1 && parent != null) {
                parent.left = new TreeNode(tree[++i]);
                if (parent.left.val == -1)
                    parent.left = null;
                q.offer(parent.left);
            }

            if (i < tree.length - 1 && parent != null) {
                parent.right = new TreeNode(tree[++i]);
                if (parent.right.val == -1)
                    parent.right = null;
                q.offer(parent.right);
            }

        }

    }

    public void print() {
        print(root);
    }

    public void print(TreeNode node) {
        if(node == null)
            return;
        System.out.println(node.val);
        print(node.left);
        print(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int count = 0;

    public int maxDepth(TreeNode root) {
        depth(root, 1);
        return count;
    }

    public void depth(TreeNode node, int d) {
        if (node == null)
            return;
        if (node.left != null)
            depth(node.left, d + 1);
        if (node.right != null)
            depth(node.right, d + 1);
        if (d > count)
            count = d;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0, -1, -1, 0, -1, -1, -1, 0};
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        tree.init(a);
        tree.print();
        System.out.println(tree.maxDepth(tree.root));
    }
}
