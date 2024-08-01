import utils.TreeNode;

public class ConvertSortedArrayToBinarySearchTree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length -1);
    }

    private static TreeNode helper(int[] arr, int l, int r){
        if(l > r) return null;
        if(l == r) return new TreeNode(arr[l]);
        int mid = (l + r) /2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr,l,mid -1);
        root.right = helper(arr,mid+1, r);
        return root;

    }

}
