/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private static int height(TreeNode root){
        if(root==null) return -1;
        int leftHeight=height(root.left);
        if(leftHeight==-2){
            return -2;
        }
        int rightHeight=height(root.right);
        if(rightHeight==-2){
            return -2;
        }
        if(Math.abs(leftHeight-rightHeight)>1) return -2;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-2;
    }
}
