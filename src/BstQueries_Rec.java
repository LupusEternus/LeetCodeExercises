import utils.BinaryTreeNode;

import java.util.ArrayList;

/*
Problem statement
You are given an arbitrary binary search tree (BST) with N nodes numbered 1 to N, and each node is associated with a value.
You are also given Q queries, each of the Q queries are of the form [ L, R ], your task is to find the number of nodes in the BST which lie in the range L to R for each query.
 */
public class BstQueries_Rec {

    public static ArrayList<Integer> bstQueries(BinaryTreeNode<Integer> root, int q, int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            result.add(f(queries[i][0], queries[i][queries[i].length - 1], root));
        }
        return result;
    }

    private static int f(int low, int high, BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.data >= low && root.data <= high){
            return 1 + f(low,high,root.left) + f(low,high,root.right);
        }
        else if (root.data < low){
            return f(low,high,root.right);
        }else {
            return f(low,high,root.left);
        }
    }
}
