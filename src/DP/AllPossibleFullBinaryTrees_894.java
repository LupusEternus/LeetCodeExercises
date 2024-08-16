package DP;

import utils.TreeNode;

import java.util.*;


public class AllPossibleFullBinaryTrees_894 {
    Map<Integer, List<TreeNode>> mem = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        return allPossibleFBT(n, new HashMap<>());
    }

    public List<TreeNode> allPossibleFBT(int n, Map<Integer, List<TreeNode>> mem) {
        if (n % 2 == 0) return List.of();
        if (n == 1) return List.of(new TreeNode(0));
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        List<TreeNode> result = new ArrayList<>();

        int leftSize = 1;

        while (true) {
            int rightSize = n - 1 - leftSize;
            if (rightSize <= 0) break;

            List<TreeNode> left = allPossibleFBT(leftSize, mem);
            List<TreeNode> right = allPossibleFBT(rightSize, mem);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
            leftSize += 2;
            mem.put(n, result);
        }
        return result;
    }

}
