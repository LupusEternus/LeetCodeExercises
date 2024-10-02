import utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;

/*
Problem statement
You are given an arbitrary binary search tree (BST) with N nodes numbered 1 to N, and each node is associated with a value.
You are also given Q queries, each of the Q queries are of the form [ L, R ], your task is to find the number of nodes in the BST which lie in the range L to R for each query.
 */
public class BstQueries {

    public static ArrayList<Integer> bstQueries(BinaryTreeNode<Integer> root, int q, int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            result.add(f(queries[i][0], queries[i][queries[i].length - 1], root));
        }
        return result;
    }

    private static int f(int low, int high, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            BinaryTreeNode<Integer> currentNode = stack.pop();
            if (currentNode.data >= low && currentNode.data <= high) {
                count++;
            }
            if (currentNode.left != null && currentNode.data > low) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null && currentNode.data < high) {
                stack.push(currentNode.right);
            }
        }
        return count;
    }
}
